/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.FluxoCaixa;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public class FluxoCaixaConverter implements AttributeConverter<FluxoCaixa, Short>{

    @Override
    public Short convertToDatabaseColumn(FluxoCaixa attribute) {
        return attribute.getId();
    }

    @Override
    public FluxoCaixa convertToEntityAttribute(Short dbData) {
        for(FluxoCaixa op: FluxoCaixa.values()){
            if (op.getId() == dbData){
                return op;
            }
        }
        return null;
    }
}
