/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.CaixaDaoImpl;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import br.edimarmanica.fazenda.model.domain.Animal;
import br.edimarmanica.fazenda.model.domain.Caixa;
import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.domain.TipoCaixa;
import br.edimarmanica.fazenda.model.domain.enums.Emprestimo;
import java.util.Arrays;

/**
 *
 * @author edimar
 */
public final class CaixaControl extends GenericControl<Caixa> {

    private List<Pessoa> pessoaCombo;
    private List<TipoCaixa> tipoCaixaCombo;
    private List<Animal> animalCombo;
    private List<Pessoa> pessoaEmprestimoCombo;
    private List<Emprestimo> emprestimoCombo;
    

    public CaixaControl() {
        super();
    }

  
    @Override
    public void instanceDao() {
        dao = new CaixaDaoImpl();
    }

    public List<Pessoa> getPessoaCombo() {
        return pessoaCombo;
    }

    public void setPessoaCombo(List<Pessoa> pessoaCombo) {
        this.pessoaCombo = pessoaCombo;
    }

    public List<TipoCaixa> getTipoCaixaCombo() {
        return tipoCaixaCombo;
    }

    public void setTipoCaixaCombo(List<TipoCaixa> tipoCaixaCombo) {
        this.tipoCaixaCombo = tipoCaixaCombo;
    }

    public List<Animal> getAnimalCombo() {
        return animalCombo;
    }

    public void setAnimalCombo(List<Animal> animalCombo) {
        this.animalCombo = animalCombo;
    }

    public List<Pessoa> getPessoaEmprestimoCombo() {
        return pessoaEmprestimoCombo;
    }

    public void setPessoaEmprestimoCombo(List<Pessoa> pessoaEmprestimoCombo) {
        this.pessoaEmprestimoCombo = pessoaEmprestimoCombo;
    }

    public List<Emprestimo> getEmprestimoCombo() {
        return emprestimoCombo;
    }

    public void setEmprestimoCombo(List<Emprestimo> emprestimoCombo) {
        this.emprestimoCombo = emprestimoCombo;
    }

    @Override
    public void cfgComboBD() {
        pessoaCombo = ObservableCollections.observableList(new ArrayList<Pessoa>());
        pessoaCombo.addAll(((CaixaDaoImpl) dao).buscarPessoas());

        tipoCaixaCombo = ObservableCollections.observableList(new ArrayList<TipoCaixa>());
        tipoCaixaCombo.addAll(((CaixaDaoImpl) dao).buscarTipoCaixa());

        animalCombo = ObservableCollections.observableList(new ArrayList<Animal>());
        animalCombo.addAll(((CaixaDaoImpl) dao).buscarAnimaisAtivos());

        pessoaEmprestimoCombo = ObservableCollections.observableList(new ArrayList<Pessoa>());
        pessoaEmprestimoCombo.addAll(((CaixaDaoImpl) dao).buscarPessoas());
    }

    @Override
    public void cfgComboENUM() {
        emprestimoCombo = Arrays.asList(Emprestimo.values());
        
    }

    @Override
    public Caixa getNewObject() {
        return new Caixa();
    }
}
