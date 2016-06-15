/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.SituacaoAnimal;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public class SituacaoAnimalConverter implements AttributeConverter<SituacaoAnimal, Short>{

    @Override
    public Short convertToDatabaseColumn(SituacaoAnimal attribute) {
        return attribute.getId();
    }

    @Override
    public SituacaoAnimal convertToEntityAttribute(Short dbData) {
        for(SituacaoAnimal op: SituacaoAnimal.values()){
            if (op.getId() == dbData){
                return op;
            }
        }
        return null;
    }
    
}
