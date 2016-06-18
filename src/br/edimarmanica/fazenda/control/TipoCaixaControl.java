/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.TipoCaixaDaoImpl;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import br.edimarmanica.fazenda.model.domain.TipoCaixa;
import br.edimarmanica.fazenda.model.domain.enums.FluxoCaixa;
import java.util.Arrays;

/**
 *
 * @author edimar
 */
public final class TipoCaixaControl extends GenericControl<TipoCaixa> {

    private List<TipoCaixa> paiCombo;
    private List<FluxoCaixa> fluxoCombo;

    public TipoCaixaControl() {
        super();
    }

    public List<TipoCaixa> getPaiCombo() {
        return paiCombo;
    }

    public void setPaiCombo(List<TipoCaixa> paiCombo) {
        this.paiCombo = paiCombo;
    }

    public List<FluxoCaixa> getFluxoCombo() {
        return fluxoCombo;
    }

    public void setFluxoCombo(List<FluxoCaixa> fluxoCombo) {
        this.fluxoCombo = fluxoCombo;
    }

    @Override
    public TipoCaixa getNewObject() {
        return new TipoCaixa();
    }

    @Override
    public void instanceDao() {
        dao = new TipoCaixaDaoImpl();
    }

    @Override
    public void cfgComboBD() {
        paiCombo = ObservableCollections.observableList(new ArrayList<TipoCaixa>());
        paiCombo.addAll(((TipoCaixaDaoImpl)dao).buscarTiposCaixaPai());
    }

    @Override
    public void cfgComboENUM() {
        fluxoCombo = Arrays.asList(FluxoCaixa.values());
    }

}
