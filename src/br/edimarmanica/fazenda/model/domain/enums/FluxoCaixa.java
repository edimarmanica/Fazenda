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
public enum FluxoCaixa {
    ENTRADA((short)1, "Entrada"), SAIDA((short)2, "Saída");
    
    private short id;
    private String descricao;

    private FluxoCaixa(short id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
}
