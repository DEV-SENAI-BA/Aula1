package com.senai.senai.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T extends EntidadeBase> {
    public EntityManager getEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("senai_PU");
        return emf.createEntityManager();
    }
    
    public T salvar(T t) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(t); // Salva ou atualiza.
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
    }
    
    public void remover(Class<T> clazz, Integer id) {
        EntityManager em = getEM();
        T t = null;
        t = em.find(clazz, id);
        try {
            em.getTransaction().begin();
            em.remove(t); //Executa o delete.
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
     
    }
    
    public T consultaPorId(Class<T> clazz, Integer id) {
        EntityManager em = getEM();
        T t = null;
        try {
            t = em.find(clazz, id); //Executa o select.
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
    }
}