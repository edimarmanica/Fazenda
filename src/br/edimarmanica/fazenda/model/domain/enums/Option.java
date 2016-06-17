/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.enums;

/**
 *
 * @author edimar
 */
public interface Option {

    String getDescricao();

    short getId();

    void setDescricao(String descricao);

    void setId(short id);

    @Override
    String toString();
}
