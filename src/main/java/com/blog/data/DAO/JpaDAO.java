package com.blog.data.DAO;
import com.blog.exception.DAOException;
import com.blog.util.HibernateUtil;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class JpaDAO<E> {
    protected EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    public Optional<E> create(E entity) throws DAOException{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw new DAOException("Create 에러 발생" + entity.toString() , Level.ERROR);
        } finally {
            entityManager.close();
        }
    }

    public Optional<E> update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw new DAOException("Update 에러 발생" + entity.toString() , Level.ERROR);
        } finally {
            entityManager.close();
        }
        return Optional.ofNullable(entity);
    }

    public Optional<E> find(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Optional<E> entity = Optional.ofNullable(entityManager.find(type, id));
        entityManager.close();
        return entity;
    }

    public boolean delete(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            Object references = entityManager.getReference(type, id);
            entityTransaction.begin();
            entityManager.remove(references);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public List<E> findAllWithNamedQuery(String queryName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }


}
