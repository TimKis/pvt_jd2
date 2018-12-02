package by.pvt.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.security.InvalidParameterException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import by.pvt.util.HibernateUtil;

/**
 *
 */
public class DaoImpl<T> {

    private Class<T> persistentClass;

    public DaoImpl(Class<T> type) {
        this.persistentClass = type;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }


    public T saveOrUpdate(T t) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return t;
    }

    @NotNull
    public T load(Serializable id) {
        if (id == null) throw new IllegalArgumentException("Persistant instance id must not be null");
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T t = null;
        try {
            t = (T)session.load(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        if (t == null) throw new IllegalStateException("Persistance instance doesn't exist");
        return t;
    }

    @Nullable
    public T find(Serializable id) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T t = null;
        try {
            t = (T)session.get(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return t;
    }




}
