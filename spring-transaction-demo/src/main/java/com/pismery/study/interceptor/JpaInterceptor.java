package com.pismery.study.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class JpaInterceptor extends EmptyInterceptor {
    /**
     * Using Stack is for Nested transaction.
     */
    transient ThreadLocal<Deque<Num>> threadLocal = new ThreadLocal<>();


    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, org.hibernate.type.Type[] types) {
        Num num = popStack();
        num.increment(NumType.FLUSH_DIRTY_NUM);
        pushStack(num);
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        Num num = popStack();
        num.increment(NumType.LOAD_NUM);
        pushStack(num);
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        Num num = popStack();
        num.increment(NumType.SAVE_NUM);
        pushStack(num);
        return super.onSave(entity, id, state, propertyNames, types);
    }


    @Override
    public void afterTransactionBegin(Transaction tx) {
        pushStack(new Num());

        printLog("begin transaction...");
        super.afterTransactionBegin(tx);
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        printLog("complete transaction... onLoad:{},onSave:{},flushDirty:{}"
                , getCurrentNum(NumType.LOAD_NUM)
                , getCurrentNum(NumType.SAVE_NUM)
                , getCurrentNum(NumType.FLUSH_DIRTY_NUM)
        );
        super.afterTransactionCompletion(tx);
    }


    private void printLog(String msg, Object... arguments) {
        if (log.isDebugEnabled())
            log.debug(msg, arguments);
    }

    private void pushStack(Num num) {
        Deque<Num> numDeque = threadLocal.get();

        if (numDeque == null) {
            numDeque = new ArrayDeque<>();
        }

        numDeque.push(num);
        threadLocal.set(numDeque);
    }

    private Num popStack() {
        Deque<Num> numDeque = threadLocal.get();
        if (numDeque == null)
            //this is for support propagation transaction will no trigger the afterTransactionBegin
            return new Num();

        Num pop = numDeque.pop();
        threadLocal.set(numDeque);

        if (numDeque.isEmpty()) {
            threadLocal.remove();
        }

        return pop;
    }

    private Integer getCurrentNum(NumType numType) {
        return threadLocal.get().peek().getNum(numType);
    }


    private class Num {
        int loadNum;
        int saveNum;
        int flushDirtyNum;

        public void increment(NumType numType) {
            if (numType == NumType.LOAD_NUM)
                loadNum++;
            if (numType == NumType.SAVE_NUM)
                saveNum++;
            if (numType == NumType.FLUSH_DIRTY_NUM)
                flushDirtyNum++;
        }

        public int getNum(NumType numType) {
            if (numType == NumType.LOAD_NUM)
                return loadNum;
            if (numType == NumType.SAVE_NUM)
                return saveNum;
            if (numType == NumType.FLUSH_DIRTY_NUM)
                return flushDirtyNum;

            return 0;
        }

    }

    private enum NumType {
        LOAD_NUM, SAVE_NUM, FLUSH_DIRTY_NUM
    }

}
