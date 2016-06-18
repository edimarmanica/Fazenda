/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import br.edimarmanica.fazenda.util.ValidacaoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edimar
 */
public abstract class Entidade {

    public List<String> nullFields;
    public List<String> notNullFields;

    public abstract void validar() throws ValidacaoException;

    public List<String> getNotNullFields() {
        return notNullFields;
    }

    public void setNotNullFields(List<String> notNullFields) {
        this.notNullFields = notNullFields;
    }

    public void addNotNullField(String field) {
        if (this.notNullFields == null) {
            this.notNullFields = new ArrayList<>();
        }
        this.notNullFields.add(field);
    }

    public List<String> getNullFields() {
        return nullFields;
    }

    public void setNullFields(List<String> nullFields) {
        this.nullFields = nullFields;
    }

    public void addNullField(String field) {
        if (this.nullFields == null) {
            this.nullFields = new ArrayList<>();
        }
        this.nullFields.add(field);
    }
}
