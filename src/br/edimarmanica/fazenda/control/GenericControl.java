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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
    protected int total;
    protected int start;
    protected int end;
    protected Integer limit = 10;
    protected Integer offset = 0;
    protected List<Integer> offsetCombo;
    protected List<Integer> limitCombo;

    public GenericControl() {
        instanceDao();

        objsTabela = ObservableCollections.observableList(new ArrayList<T>());
        offsetCombo = ObservableCollections.observableList(new ArrayList<Integer>());

        Integer[] limits = {10, 20};
        limitCombo = Arrays.asList(limits); //esse não é dinâmico por isso não tem o observable

        cfgComboBD();
        cfgComboENUM();

        limpar();
        configPagination();
    }

    public abstract void instanceDao();

    public abstract void cfgComboBD();

    public abstract void cfgComboENUM();

    public final void limpar() {
        this.objDigitado = null;
        setObjDigitado(getNewObject());
    }

    public abstract T getNewObject();

    public final void pesquisar() {
        objsTabela.clear();
        objsTabela.addAll(dao.search(objDigitado, limit, offset));
    }

    public final void configPagination() {
        total = dao.getNumberOfResults(objDigitado);

        int offsetSelected = offset;
        offsetCombo.clear();//isso apaga o valor de offset selecionado
        for (int i = 0; i < total / limit; i += limit) {
            offsetCombo.add(i);
        }
        offset = offsetSelected;
        start = offset;
        end = offset + limit;

        pesquisar();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        Integer oldLimit = this.limit;
        this.limit = limit;

        if (limit != null && !Objects.equals(oldLimit, limit)) {
            this.offset = 0;//pq mudou o limit
            System.out.println("Entrou aki: "+oldLimit+" X "+limit);
            configPagination();
        }
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {

        Integer oldOffset = this.offset;
        this.offset = offset;
        System.out.println("Offset: " + oldOffset + " X " + offset);
        if (offset != null && !Objects.equals(oldOffset, offset)) {
            pcs.firePropertyChange("offset", oldOffset, offset);
            configPagination();
        }
    }

    public List<Integer> getOffsetCombo() {
        return offsetCombo;
    }

    public void setOffsetCombo(List<Integer> offsetCombo) {
        this.offsetCombo = offsetCombo;
    }

    public List<Integer> getLimitCombo() {
        return limitCombo;
    }

    public void setLimitCombo(List<Integer> limitCombo) {
        this.limitCombo = limitCombo;
    }

    public void salvar() throws ValidacaoException {
        ((Entidade) objDigitado).validar();
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

}
