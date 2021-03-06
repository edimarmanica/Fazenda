/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.Option;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public abstract class OptionConverter implements AttributeConverter<Option, Short> {

    @Override
    public Short convertToDatabaseColumn(Option attribute) {
        if (attribute == null){
            return null;
        }
        
        return attribute.getId();
    }

    @Override
    public Option convertToEntityAttribute(Short dbData) {
        
        if (dbData == null){
            return null;
        }
        
        for (Option op : values()) {
            if (op.getId() == dbData) {
                return op;
            }
        }
        return null;
    }

    public abstract Option[] values();
}
