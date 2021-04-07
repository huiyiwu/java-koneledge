package com.huchx.transcation.service;

import com.huchx.transcation.dao.UserDao;
import com.huchx.transcation.manager.TranscationManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
/**
 * 手动控制事务管理类
 */
//    @Autowired
//    TranscationManagerUtils managerUtils;

//    public void add(){
//        TransactionStatus transaction = null;
//        try {
//            transaction = managerUtils.begin();
//            userDao.add("huchx","12");
//            int i = 10/0;//发生异常后无法存到数据库
//            userDao.add("wang","19");
//            managerUtils.commit(transaction);
//        }catch (Exception e){
//            e.printStackTrace();
//            managerUtils.rollback(transaction);
//        }
//    }

//    /**
//     * XML配置事务管理类
//     */
//    public void add(){
//        try {
//            userDao.add("huchx-"+System.currentTimeMillis(),"12");
//            int i = 10/0;//发生异常后无法存到数据库
//            userDao.add("wang-"+System.currentTimeMillis(),"19");
//        }catch (Exception e){
//            e.printStackTrace();
//            //如果使用try...catch包围，必须使用此方法回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
//    }
    /**
     * 使用注解控制事务管理
     */
    @Transactional
    public void add(){
        try {
            userDao.add("huchx-"+System.currentTimeMillis(),"12");
            int i = 10/0;//发生异常后无法存到数据库
            userDao.add("wang-"+System.currentTimeMillis(),"19");
        }catch (Exception e){
            e.printStackTrace();
            //如果使用try...catch包围，必须使用此方法回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
