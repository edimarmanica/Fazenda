/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.dao.PessoaDaoImpl;

/**
 *
 * @author edimar
 */
public final class PessoaControl extends GenericControl<Pessoa>{
    public PessoaControl() {
        super();
    }

    @Override
    public void instanceDao() {
        dao = new PessoaDaoImpl();
    }

    @Override
    public void cfgComboBD() {
        //nada
    }

    @Override
    public void cfgComboENUM() {
        //nada
    }

    @Override
    public Pessoa getNewObject() {
        return new Pessoa();
    }
    
}
