/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.Sexo;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public class SexoConverter implements AttributeConverter<Sexo, Short>{

    @Override
    public Short convertToDatabaseColumn(Sexo attribute) {
        return attribute.getId();
    }

    @Override
    public Sexo convertToEntityAttribute(Short dbData) {
        for(Sexo op: Sexo.values()){
            if (op.getId() == dbData){
                return op;
            }
        }
        return null;
    }
    
}
