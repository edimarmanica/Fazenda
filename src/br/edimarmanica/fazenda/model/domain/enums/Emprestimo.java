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
public enum Emprestimo implements Option {
    EMPRESTIMO((short)1, "Empréstimo"), DEVOLUCAO((short)2, "Devolução");

    private short id;
    private String descricao;

    private Emprestimo(short id, String descricao) {
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

    @Override
    public String toString() {
        return descricao;
    }
}
