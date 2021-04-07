package com.huchx.thread.send.controller;

import com.huchx.thread.send.entity.UserEntity;
import com.huchx.thread.send.utils.PageUtils;

import java.util.ArrayList;
import java.util.List;

public class UserThread  extends Thread{
    List<UserEntity> list;
    public UserThread() {
    }
    public UserThread(List<UserEntity> list){
        this.list = list;
    }

    @Override
    public void run() {
        for (UserEntity userEntity:list){
            System.out.println("用户："+userEntity.getUserId()+";用户名："+userEntity.getUserName()+"由线程"+Thread.currentThread().getName()+"发送通知");
        }
    }

    public static void main(String[] args) {
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UserEntity userEntity = new UserEntity("userId"+i,"userName"+i);
            list.add(userEntity);
        }
        int pageSize = 50;
        List<List<UserEntity>> lists = PageUtils.paingList(list,pageSize);
        int threadSize = lists.size();
        for (int i = 0; i < threadSize; i++) {
            List<UserEntity> userList = lists.get(i);
            UserThread userThread = new UserThread(list);
            userThread.start();
        }
    }
}
