/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author edimar
 */
public class Conexao {
    private static EntityManagerFactory emf;
    
    private static Conexao conexao;
    
    private Conexao(){
        emf = Persistence.createEntityManagerFactory("FazendaPU");
    }
    
    public synchronized static EntityManager getEntityManager(){
        if (conexao == null){
            conexao = new Conexao();
        }
        
        return emf.createEntityManager();
    }
}
