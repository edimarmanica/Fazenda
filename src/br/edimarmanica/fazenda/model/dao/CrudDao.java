/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author edimar
 * @param <E>
 */
public interface CrudDao<E> {

    void delete(E e);

    void insertOrUpdate(E e);

    List<E> search(E e, int limit, int offset);

    int getNumberOfResults(E e);

    public Query getQuery(E e);

}
