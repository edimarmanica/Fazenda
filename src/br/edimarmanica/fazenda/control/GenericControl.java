/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.CrudDao;
import br.edimarmanica.fazenda.model.domain.Entidade;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author edimar
 */
public abstract class GenericControl<T> {

    protected final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    protected T objDigitado;
    protected T objSelecionado;
    protected List<T> objsTabela;
    protected CrudDao<T> dao;

    public GenericControl() {
        instanceDao();

        objsTabela = ObservableCollections.observableList(new ArrayList<T>());
        cfgComboBD();
        cfgComboENUM();

        limpar();
        pesquisar();
    }

    public abstract void instanceDao();

    public abstract void cfgComboBD();

    public abstract void cfgComboENUM();

    public final void limpar() {
        setObjDigitado(getNewObject());
    }

    public abstract T getNewObject();

    public final void pesquisar() {
        objsTabela.clear();
        objsTabela.addAll(dao.search(objDigitado));
    }

    public void salvar() throws ValidacaoException {
        ((Entidade)objDigitado).validar();
        dao.insertOrUpdate(objDigitado);
        limpar();
        pesquisar();
    }

    public void excluir() {
        dao.delete(objDigitado);
        limpar();
        pesquisar();
    }
    
    public T getObjDigitado() {
        return objDigitado;
    }
    
    public void setObjDigitado(T objDigitado) {
        T oldObjDigitado = this.objDigitado;
        this.objDigitado = objDigitado;
        pcs.firePropertyChange("objDigitado", oldObjDigitado, objDigitado);
    }

    public T getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(T objSelecionado) {
        this.objSelecionado = objSelecionado;
        if (this.objSelecionado != null) {
            setObjDigitado(objSelecionado);
        }
    }

    public List<T> getObjsTabela() {
        return objsTabela;
    }

    public void setObjsTabela(List<T> objsTabela) {
        this.objsTabela = objsTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

}
