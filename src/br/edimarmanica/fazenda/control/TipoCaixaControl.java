/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.TipoCaixaDaoImpl;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
public final class TipoCaixaControl {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private TipoCaixa objDigitado;
    private TipoCaixa objSelecionado;
    private List<TipoCaixa> objsTabela;
    private List<TipoCaixa> paiCombo;
    private List<FluxoCaixa> fluxoCombo;

    private final TipoCaixaDaoImpl dao;

    public TipoCaixaControl() {
        dao = new TipoCaixaDaoImpl();
        objsTabela = ObservableCollections.observableList(new ArrayList<TipoCaixa>());

        paiCombo = ObservableCollections.observableList(new ArrayList<TipoCaixa>());
        paiCombo.addAll(dao.buscarTiposCaixaPai());

        fluxoCombo = Arrays.asList(FluxoCaixa.values());

        novo();
        pesquisar();
    }

    public void novo() {
        setObjDigitado(new TipoCaixa());
    }

    public void pesquisar() {
        objsTabela.clear();
        objsTabela.addAll(dao.search(objDigitado));
    }

    public void salvar() throws ValidacaoException {
        objDigitado.validar();
        dao.insertOrUpdate(objDigitado);
        novo();
        pesquisar();
    }

    public void excluir() {
        dao.delete(objDigitado);
        novo();
        pesquisar();
    }

    public TipoCaixa getObjDigitado() {
        return objDigitado;
    }

    public void setObjDigitado(TipoCaixa objDigitado) {
        TipoCaixa oldObjDigitada = this.objDigitado;
        this.objDigitado = objDigitado;
        pcs.firePropertyChange("objDigitado", oldObjDigitada, objDigitado);
    }

    public TipoCaixa getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(TipoCaixa objSelecionado) {
        this.objSelecionado = objSelecionado;

        if (this.objSelecionado != null) {
            setObjDigitado(objSelecionado);
        }
    }

    public List<TipoCaixa> getObjsTabela() {
        return objsTabela;
    }

    public void setObjsTabela(List<TipoCaixa> objsTabela) {
        this.objsTabela = objsTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
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

}
