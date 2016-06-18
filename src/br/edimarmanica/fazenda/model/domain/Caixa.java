/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import br.edimarmanica.fazenda.model.domain.converters.BooleanoConverter;
import br.edimarmanica.fazenda.model.domain.converters.EmprestimoConverter;
import br.edimarmanica.fazenda.model.domain.enums.Booleano;
import br.edimarmanica.fazenda.model.domain.enums.Emprestimo;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edimar
 */
@Entity
@Table(name = "caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.findByCdCaixa", query = "SELECT c FROM Caixa c WHERE c.cdCaixa = :cdCaixa"),
    @NamedQuery(name = "Caixa.findByVlCaixa", query = "SELECT c FROM Caixa c WHERE c.vlCaixa = :vlCaixa"),
    @NamedQuery(name = "Caixa.findByDtPagamento", query = "SELECT c FROM Caixa c WHERE c.dtPagamento = :dtPagamento"),
    @NamedQuery(name = "Caixa.findByDsCaixa", query = "SELECT c FROM Caixa c WHERE c.dsCaixa = :dsCaixa"),
    @NamedQuery(name = "Caixa.findByDtVencimento", query = "SELECT c FROM Caixa c WHERE c.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "Caixa.findByIdEmprestimo", query = "SELECT c FROM Caixa c WHERE c.idEmprestimo = :idEmprestimo"),
    @NamedQuery(name = "Caixa.findByDsObservacao", query = "SELECT c FROM Caixa c WHERE c.dsObservacao = :dsObservacao")})
public class Caixa extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_caixa")
    private Integer cdCaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vl_caixa")
    private BigDecimal vlCaixa;
    @Column(name = "dt_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dtPagamento;
    @Column(name = "ds_caixa")
    private String dsCaixa;
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Column(name = "id_emprestimo")
    @Convert(converter = EmprestimoConverter.class)
    private Emprestimo idEmprestimo;
    @Column(name = "ds_observacao")
    private String dsObservacao;
    @JoinColumn(name = "cd_animal", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdAnimal;
    @JoinColumn(name = "cd_pessoa_emprestimo", referencedColumnName = "cd_pessoa")
    @ManyToOne
    private Pessoa cdPessoaEmprestimo;
    @JoinColumn(name = "cd_pessoa", referencedColumnName = "cd_pessoa")
    @ManyToOne(optional = false)
    private Pessoa cdPessoa;
    @JoinColumn(name = "cd_tipo_caixa", referencedColumnName = "cd_tipo_caixa")
    @ManyToOne(optional = false)
    private TipoCaixa cdTipoCaixa;
    //campos apenas de pesquisa
    @Transient
    private Date dtPagamentoMenor;
    @Transient
    private Date dtPagamentoMaior;
    @Transient
    private Booleano idPago;
    @Transient
    private Date dtVencimentoMenor;
    @Transient
    private Date dtVencimentoMaior;

    public Date getDtPagamentoMenor() {
        return dtPagamentoMenor;
    }

    public void setDtPagamentoMenor(Date dtPagamentoMenor) {
        this.dtPagamentoMenor = dtPagamentoMenor;
    }

    public Date getDtPagamentoMaior() {
        return dtPagamentoMaior;
    }

    public void setDtPagamentoMaior(Date dtPagamentoMaior) {
        this.dtPagamentoMaior = dtPagamentoMaior;
    }

    public Booleano getIdPago() {
        return idPago;
    }

    public void setIdPago(Booleano idPago) {
        this.idPago = idPago;
    }

    public Date getDtVencimentoMenor() {
        return dtVencimentoMenor;
    }

    public void setDtVencimentoMenor(Date dtVencimentoMenor) {
        this.dtVencimentoMenor = dtVencimentoMenor;
    }

    public Date getDtVencimentoMaior() {
        return dtVencimentoMaior;
    }

    public void setDtVencimentoMaior(Date dtVencimentoMaior) {
        this.dtVencimentoMaior = dtVencimentoMaior;
    }

    public Caixa() {
    }

    public Caixa(Integer cdCaixa) {
        this.cdCaixa = cdCaixa;
    }

    public Caixa(Integer cdCaixa, BigDecimal vlCaixa) {
        this.cdCaixa = cdCaixa;
        this.vlCaixa = vlCaixa;
    }

    public Integer getCdCaixa() {
        return cdCaixa;
    }

    public void setCdCaixa(Integer cdCaixa) {
        this.cdCaixa = cdCaixa;
    }

    public BigDecimal getVlCaixa() {
        return vlCaixa;
    }

    public void setVlCaixa(BigDecimal vlCaixa) {
        this.vlCaixa = vlCaixa;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public String getDsCaixa() {
        return dsCaixa;
    }

    public void setDsCaixa(String dsCaixa) {
        this.dsCaixa = dsCaixa.toUpperCase();
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Emprestimo getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Emprestimo idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public String getDsObservacao() {
        return dsObservacao;
    }

    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
    }

    public Animal getCdAnimal() {
        return cdAnimal;
    }

    public void setCdAnimal(Animal cdAnimal) {
        this.cdAnimal = cdAnimal;
    }

    public Pessoa getCdPessoaEmprestimo() {
        return cdPessoaEmprestimo;
    }

    public void setCdPessoaEmprestimo(Pessoa cdPessoaEmprestimo) {
        this.cdPessoaEmprestimo = cdPessoaEmprestimo;
    }

    public Pessoa getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Pessoa cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public TipoCaixa getCdTipoCaixa() {
        return cdTipoCaixa;
    }

    public void setCdTipoCaixa(TipoCaixa cdTipoCaixa) {
        this.cdTipoCaixa = cdTipoCaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCaixa != null ? cdCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.cdCaixa == null && other.cdCaixa != null) || (this.cdCaixa != null && !this.cdCaixa.equals(other.cdCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.Caixa[ cdCaixa=" + cdCaixa + " ]";
    }

    @Override
    public void validar() throws ValidacaoException {
        if (this.dsCaixa == null || this.dsCaixa.trim().isEmpty()) {
            throw new ValidacaoException("Campo descrição não preenchido!");
        }
    }

}
