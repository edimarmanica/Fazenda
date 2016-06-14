/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author edimar
 * @param <E>
 * @param <I>
 */
public abstract class CrudDaoImpl<E,I> implements CrudDao<E> {

    protected abstract I getChave(E e);
    
    protected abstract String getSql(E e);
    
    protected abstract Map<String, Object> getSqlParametros(E e);
    
    @Override
    public void insertOrUpdate(E e) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        if (getChave(e) != null) {
            e = em.merge(e);
        }
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(E e) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        e = em.merge(e);
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }
    
    
    
    @Override
    public List<E> search(E e){
        EntityManager em = Conexao.getEntityManager();
        Query query = em.createQuery(getSql(e));
        Map<String, Object> parametros = getSqlParametros(e);
        for(String key: parametros.keySet()){
            query.setParameter(key, parametros.get(key));
        }
        return query.getResultList();
    }
}
