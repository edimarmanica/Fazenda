/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.service.ServiceLocator;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import br.edimarmanica.fazenda.model.dao.CrudDao;

/**
 *
 * @author edimar
 */
public final class PessoaControl {
    
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private Pessoa pessoaDigitada;
    private Pessoa pessoaSelecionada;
    private List<Pessoa> pessoasTabela;
    
    private final CrudDao dao;
    
    public PessoaControl() {
        dao = ServiceLocator.getPessoaDao();
        pessoasTabela = ObservableCollections.observableList(new ArrayList<Pessoa>());
        
        limpar();
        pesquisar();
    }
    
    public void limpar() {
        setPessoaDigitada(new Pessoa());
    }
    
    public void pesquisar() {
        pessoasTabela.clear();
        pessoasTabela.addAll(dao.search(pessoaDigitada));
    }
    
    public void salvar() throws ValidacaoException{
        pessoaDigitada.validar();
        dao.insertOrUpdate(pessoaDigitada);
        limpar();
        pesquisar();
    }
    
    public void excluir(){
        dao.delete(pessoaDigitada);
        limpar();
        pesquisar();
    }
    
    public Pessoa getPessoaDigitada() {
        return pessoaDigitada;
    }
    
    public void setPessoaDigitada(Pessoa pessoaDigitada) {
        Pessoa oldPessoaDigitada = this.pessoaDigitada;
        this.pessoaDigitada = pessoaDigitada;
        pcs.firePropertyChange("pessoaDigitada", oldPessoaDigitada, pessoaDigitada);
    }
    
    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }
    
    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
        
        if (this.pessoaSelecionada != null){
            System.out.println("aki");
            setPessoaDigitada(pessoaSelecionada);
        }
    }
    
    public List<Pessoa> getPessoasTabela() {
        return pessoasTabela;
    }
    
    public void setPessoasTabela(List<Pessoa> pessoasTabela) {
        this.pessoasTabela = pessoasTabela;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        pcs.addPropertyChangeListener(pcl);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener pcl){
        pcs.removePropertyChangeListener(pcl);
    }
    
}
