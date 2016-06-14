/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.service;

import br.edimarmanica.fazenda.model.dao.CrudDaoImpl;
import br.edimarmanica.fazenda.model.dao.CrudDao;
import br.edimarmanica.fazenda.model.dao.PessoaDaoImpl;

/**
 *
 * @author edimar
 */
public class ServiceLocator {

    public static CrudDao getPessoaDao() {
        return new PessoaDaoImpl();
    }
    
}
