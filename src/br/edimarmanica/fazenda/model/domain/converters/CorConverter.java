/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.Cor;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public class CorConverter implements AttributeConverter<Cor, Short>{

    @Override
    public Short convertToDatabaseColumn(Cor attribute) {
        return attribute.getId();
    }

    @Override
    public Cor convertToEntityAttribute(Short dbData) {
        if (dbData == null){
            return null;
        }
        
        for(Cor op: Cor.values()){
            if (op.getId() == dbData){
                return op;
            }
        }
        return null;
    }
    
}
