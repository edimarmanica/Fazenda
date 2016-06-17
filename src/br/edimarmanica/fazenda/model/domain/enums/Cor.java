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
public enum Cor implements Option {
    Branca((short) 1, "Branca"), Preta((short) 2, "Preta"), Holandes((short) 3, "Holandês"),
    Vermelha((short) 4, "Vermelha"), Amarela((short) 5, "Amarela"), Fumaca((short) 6, "Fumaça");

    private short id;
    private String descricao;

    private Cor(short id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public short getId() {
        return id;
    }

    @Override
    public void setId(short id) {
        this.id = id;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
