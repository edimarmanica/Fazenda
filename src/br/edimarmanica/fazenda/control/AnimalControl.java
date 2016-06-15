/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.AnimalDaoImpl;
import br.edimarmanica.fazenda.model.service.ServiceLocator;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import br.edimarmanica.fazenda.model.dao.CrudDao;
import br.edimarmanica.fazenda.model.domain.Animal;
import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.domain.attributes.Cor;
import br.edimarmanica.fazenda.model.domain.attributes.Sexo;
import br.edimarmanica.fazenda.model.domain.attributes.SimNao;
import br.edimarmanica.fazenda.model.domain.attributes.Situacao;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author edimar
 */
public final class AnimalControl {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private Animal objDigitado;
    private Animal objSelecionado;
    private List<Animal> objsTabela;
    private List<Pessoa> proprietariosCombo;
    private List<Animal> paiCombo;
    private List<Animal> maeCombo;
    private List<Animal> touroCombo;
    private List<Sexo> sexoCombo;
    private List<Situacao> situacaoCombo;
    private List<SimNao> mamandoCombo;
    private List<Cor> corCombo;

    public List<Animal> getTouroCombo() {
        return touroCombo;
    }

    public void setTouroCombo(List<Animal> touroCombo) {
        this.touroCombo = touroCombo;
    }

    public List<Situacao> getSituacaoCombo() {
        return situacaoCombo;
    }

    public void setSituacaoCombo(List<Situacao> situacaoCombo) {
        this.situacaoCombo = situacaoCombo;
    }

    private final AnimalDaoImpl dao;

    public AnimalControl() {
        dao = new AnimalDaoImpl();
        objsTabela = ObservableCollections.observableList(new ArrayList<Animal>());

        proprietariosCombo = ObservableCollections.observableList(new ArrayList<Pessoa>());
        proprietariosCombo.addAll(dao.buscarPessoas());

        paiCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        paiCombo.addAll(dao.buscarTourosAtivos());

        touroCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        touroCombo.addAll(dao.buscarTourosAtivos());

        maeCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        maeCombo.addAll(dao.buscarVacasAtivas());

        sexoCombo = Arrays.asList(Sexo.values());
        situacaoCombo = Arrays.asList(Situacao.values());
        corCombo = Arrays.asList(Cor.values());
        mamandoCombo = Arrays.asList(SimNao.values());

        novo();
        pesquisar();
    }

    public List<SimNao> getMamandoCombo() {
        return mamandoCombo;
    }

    public void setMamandoCombo(List<SimNao> mamandoCombo) {
        this.mamandoCombo = mamandoCombo;
    }

    public List<Cor> getCorCombo() {
        return corCombo;
    }

    public void setCorCombo(List<Cor> corCombo) {
        this.corCombo = corCombo;
    }

    public void novo() {
        setObjDigitado(new Animal());
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

    public Animal getObjDigitado() {
        return objDigitado;
    }

    public void setObjDigitado(Animal objDigitado) {
        Animal oldObjDigitada = this.objDigitado;
        this.objDigitado = objDigitado;
        pcs.firePropertyChange("objDigitado", oldObjDigitada, objDigitado);
    }

    public Animal getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(Animal objSelecionado) {
        this.objSelecionado = objSelecionado;

        if (this.objSelecionado != null) {
            setObjDigitado(objSelecionado);
        }
    }

    public List<Animal> getObjsTabela() {
        return objsTabela;
    }

    public void setObjsTabela(List<Animal> objsTabela) {
        this.objsTabela = objsTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

    public List<Pessoa> getProprietariosCombo() {
        return proprietariosCombo;
    }

    public void setProprietariosCombo(List<Pessoa> proprietariosCombo) {
        this.proprietariosCombo = proprietariosCombo;
    }

    public List<Animal> getPaiCombo() {
        return paiCombo;
    }

    public void setPaiCombo(List<Animal> paiCombo) {
        this.paiCombo = paiCombo;
    }

    public List<Animal> getMaeCombo() {
        return maeCombo;
    }

    public void setMaeCombo(List<Animal> maeCombo) {
        this.maeCombo = maeCombo;
    }

    public List<Sexo> getSexoCombo() {
        return sexoCombo;
    }

    public void setSexoCombo(List<Sexo> sexoCombo) {
        this.sexoCombo = sexoCombo;
    }

}
