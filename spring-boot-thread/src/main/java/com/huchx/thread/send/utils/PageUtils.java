package com.huchx.thread.send.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    static public<T> List<List<T>> paingList(List<T> list,int pageSize){
        int totalSize = list.size();
        int page = (totalSize+(pageSize-1))/pageSize;
        List<List<T>> lists = new ArrayList<>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < totalSize; j++) {
                int pageIndex = ((j+1)+(pageSize-1))/pageSize;
                if (pageIndex == (i+1)){
                    subList.add(list.get(i));
                }
                if ((j+1)==(j+1)*pageSize){
                    break;
                }
            }
            lists.add(subList);
        }
        return lists;
    }
}
