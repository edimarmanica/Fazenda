/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import br.edimarmanica.fazenda.util.ValidacaoException;

/**
 *
 * @author edimar
 */
public abstract class Entidade {

    public abstract void validar() throws ValidacaoException;
}
