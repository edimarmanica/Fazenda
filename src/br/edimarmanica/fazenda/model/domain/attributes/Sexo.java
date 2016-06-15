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
public enum Sexo {
    F((short)0), M((short)1);

    private short id;

    private Sexo(short id) {
        this.id = id;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name();
    }
    
    

}
