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
public enum Booleano {
    Nao((short)0, "Não"), Sim((short)1, "Sim");

    private short id;
    private String descricao;

    private Booleano(short id, String descricao) {
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
