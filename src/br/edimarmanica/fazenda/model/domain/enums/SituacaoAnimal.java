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
public enum SituacaoAnimal {
    Normal((short) 1, "Normal"), Vendido((short) 2, "Vendido"), Morreu((short) 3, "Morreu"),
    TerceiroAtivo((short) 4, "Terc. Ativo"), TerceiroInativo((short) 5, "Terc. Inativo");

    private short id;
    private String descricao;

    private SituacaoAnimal(short id, String descricao) {
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
        return descricao; //To change body of generated methods, choose Tools | Templates.
    }

}
