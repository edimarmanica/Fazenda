/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.Booleano;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public class BooleanConverter implements AttributeConverter<Booleano, Short>{

    @Override
    public Short convertToDatabaseColumn(Booleano attribute) {
        return attribute.getId();
    }

    @Override
    public Booleano convertToEntityAttribute(Short dbData) {
        for(Booleano op: Booleano.values()){
            if (op.getId() == dbData){
                return op;
            }
        }
        return null;
    }
    
}
