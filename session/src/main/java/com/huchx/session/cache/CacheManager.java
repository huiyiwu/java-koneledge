package com.huchx.session.cache;

import sun.misc.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheManager {
    public Map<String,CustomCache> cacheMap = new HashMap<>();
    public void set(String key,Object value){
        set(key,value,null);
    }

    /**
     * 存储缓存值
     * @param key
     * @param value
     * @param time
     */
    private synchronized void set(String key, Object value, Long time) {
        if (value==null){
            return;
        }
        CustomCache cache = new CustomCache();
        cache.setKey(key);
        cache.setValue(value);
        cache.setTimeOut(time);
        cacheMap.put(key,cache);
    }

    /**
     * 获取缓存值
     * @param key
     * @return
     */
    private synchronized Object get(String key){
        CustomCache cache = cacheMap.get(key);
        if (cache==null){
            return null;
        }else {
            return  cache.getValue();
        }
    }

    /**
     * 删除缓存值
     * @param key
     */
    private synchronized void del(String key){
        cacheMap.remove(key);
    }
    /**
     * 检查有效性
     */
    public synchronized void checkValidityData(){
        for (String key: cacheMap.keySet()){
            CustomCache cache =  cacheMap.get(key);
            Long timeOut = cache.getTimeOut();
            if (timeOut==null){
                return;
            }
            long currentTime = System.currentTimeMillis();
            long endTime = timeOut;
            long result = currentTime-endTime;
            if (result>0){
                System.out.println("缓存已过期，清除："+key);
                cacheMap.remove(key);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CacheManager cacheManager = new CacheManager();
        cacheManager.set("name","huchx",5000l);
        System.out.println(cacheManager.get("name"));
        ScheduledExecutorService scheduledExecutorPool = Executors.newScheduledThreadPool(5);
        scheduledExecutorPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始检查缓存有效性");
                cacheManager.checkValidityData();
            }
        },5000, TimeUnit.MILLISECONDS);
        Thread.sleep(5000);
        System.out.println(cacheManager.get("name"));
    }

}
