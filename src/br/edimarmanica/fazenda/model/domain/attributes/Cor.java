/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.attributes;

/**
 *
 * @author edimar
 */
public enum Cor {
    Branca (1, "Branca"), Preta (2, "Preta"), Holandes(3, "Holandês"), Vermelha(4, "Vermelha"), Amarela(5, "Amarela"), Fumaca(6, "Fumaça");
    
    private int id;
    private String descricao;

    private Cor(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
