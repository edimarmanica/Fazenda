/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain.converters;

import br.edimarmanica.fazenda.model.domain.enums.Booleano;
import br.edimarmanica.fazenda.model.domain.enums.Option;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author edimar
 */
@Converter
public class BooleanoConverter extends OptionConverter implements AttributeConverter<Option, Short>{

    @Override
    public Option[] values() {
        return Booleano.values();
    }

}
