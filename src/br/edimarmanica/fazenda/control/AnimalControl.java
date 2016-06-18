/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.AnimalDaoImpl;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import br.edimarmanica.fazenda.model.domain.Animal;
import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.domain.enums.Cor;
import br.edimarmanica.fazenda.model.domain.enums.Sexo;
import br.edimarmanica.fazenda.model.domain.enums.Booleano;
import br.edimarmanica.fazenda.model.domain.enums.SituacaoAnimal;
import java.util.Arrays;

/**
 *
 * @author edimar
 */
public final class AnimalControl extends GenericControl<Animal> {

    private List<Pessoa> proprietariosCombo;
    private List<Animal> paiCombo;
    private List<Animal> maeCombo;
    private List<Animal> touroCombo;
    private List<Sexo> sexoCombo;
    private List<SituacaoAnimal> situacaoCombo;
    private List<Booleano> mamandoCombo;
    private List<Cor> corCombo;

    public List<Animal> getTouroCombo() {
        return touroCombo;
    }

    public void setTouroCombo(List<Animal> touroCombo) {
        this.touroCombo = touroCombo;
    }

    public List<SituacaoAnimal> getSituacaoCombo() {
        return situacaoCombo;
    }

    public void setSituacaoCombo(List<SituacaoAnimal> situacaoCombo) {
        this.situacaoCombo = situacaoCombo;
    }

    public AnimalControl() {
        super();
    }

    public List<Booleano> getMamandoCombo() {
        return mamandoCombo;
    }

    public void setMamandoCombo(List<Booleano> mamandoCombo) {
        this.mamandoCombo = mamandoCombo;
    }

    public List<Cor> getCorCombo() {
        return corCombo;
    }

    public void setCorCombo(List<Cor> corCombo) {
        this.corCombo = corCombo;
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

    @Override
    public void instanceDao() {
        dao = new AnimalDaoImpl();
    }

    @Override
    public void cfgComboBD() {
        proprietariosCombo = ObservableCollections.observableList(new ArrayList<Pessoa>());
        proprietariosCombo.addAll(((AnimalDaoImpl) dao).buscarPessoas());

        paiCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        paiCombo.addAll(((AnimalDaoImpl) dao).buscarTourosAtivos());

        touroCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        touroCombo.addAll(((AnimalDaoImpl) dao).buscarTourosAtivos());

        maeCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        maeCombo.addAll(((AnimalDaoImpl) dao).buscarVacasAtivas());
    }

    @Override
    public void cfgComboENUM() {
        sexoCombo = Arrays.asList(Sexo.values());
        situacaoCombo = Arrays.asList(SituacaoAnimal.values());
        corCombo = Arrays.asList(Cor.values());
        mamandoCombo = Arrays.asList(Booleano.values());
    }

    @Override
    public Animal getNewObject() {
        return new Animal();
    }

}
