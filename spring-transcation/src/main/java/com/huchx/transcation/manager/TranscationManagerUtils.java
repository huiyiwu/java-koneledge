package com.huchx.transcation.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//手动管理事务控制类
@Component
public class TranscationManagerUtils {
    @Autowired
    DataSourceTransactionManager manager;

    public TransactionStatus begin(){
        TransactionStatus transaction = manager.getTransaction(new DefaultTransactionDefinition());
        return transaction;
    }

    public void commit(TransactionStatus transaction){
        manager.commit(transaction);
    }

    public void rollback(TransactionStatus transaction){
        manager.rollback(transaction);
    }
}
