/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import br.edimarmanica.fazenda.model.domain.converters.FluxoCaixaConverter;
import br.edimarmanica.fazenda.model.domain.enums.FluxoCaixa;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edimar
 */
@Entity
@Table(name = "tipo_caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCaixa.findAll", query = "SELECT t FROM TipoCaixa t"),
    @NamedQuery(name = "TipoCaixa.findByCdTipoCaixa", query = "SELECT t FROM TipoCaixa t WHERE t.cdTipoCaixa = :cdTipoCaixa"),
    @NamedQuery(name = "TipoCaixa.findByNmTipoCaixa", query = "SELECT t FROM TipoCaixa t WHERE t.nmTipoCaixa = :nmTipoCaixa"),
    @NamedQuery(name = "TipoCaixa.findByIdTipo", query = "SELECT t FROM TipoCaixa t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TipoCaixa.findByCdBb", query = "SELECT t FROM TipoCaixa t WHERE t.cdBb = :cdBb")})
public class TipoCaixa extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "cd_tipo_caixa")
    private Integer cdTipoCaixa;
    @Basic(optional = false)
    @Column(name = "nm_tipo_caixa")
    private String nmTipoCaixa;
    @Basic(optional = false)
    @Convert(converter = FluxoCaixaConverter.class)
    @Column(name = "id_tipo")
    private FluxoCaixa idTipo;
    @Column(name = "cd_bb")
    private Integer cdBb;
    @JoinColumn(name = "cd_tipo_caixa_pai", referencedColumnName = "cd_tipo_caixa")
    @ManyToOne
    private TipoCaixa cdTipoCaixaPai;

    public TipoCaixa() {
    }

    public TipoCaixa(Integer cdTipoCaixa) {
        this.cdTipoCaixa = cdTipoCaixa;
    }

    public TipoCaixa(Integer cdTipoCaixa, String nmTipoCaixa, FluxoCaixa idTipo) {
        this.cdTipoCaixa = cdTipoCaixa;
        this.nmTipoCaixa = nmTipoCaixa;
        this.idTipo = idTipo;
    }

    public Integer getCdTipoCaixa() {
        return cdTipoCaixa;
    }

    public void setCdTipoCaixa(Integer cdTipoCaixa) {
        this.cdTipoCaixa = cdTipoCaixa;
    }

    public String getNmTipoCaixa() {
        return nmTipoCaixa;
    }

    public void setNmTipoCaixa(String nmTipoCaixa) {
        this.nmTipoCaixa = nmTipoCaixa.toUpperCase();
    }

    public FluxoCaixa getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(FluxoCaixa idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getCdBb() {
        return cdBb;
    }

    public void setCdBb(Integer cdBb) {
        this.cdBb = cdBb;
    }

    public TipoCaixa getCdTipoCaixaPai() {
        return cdTipoCaixaPai;
    }

    public void setCdTipoCaixaPai(TipoCaixa cdTipoCaixaPai) {
        this.cdTipoCaixaPai = cdTipoCaixaPai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoCaixa != null ? cdTipoCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCaixa)) {
            return false;
        }
        TipoCaixa other = (TipoCaixa) object;
        if ((this.cdTipoCaixa == null && other.cdTipoCaixa != null) || (this.cdTipoCaixa != null && !this.cdTipoCaixa.equals(other.cdTipoCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmTipoCaixa;
    }

    @Override
    public void validar() throws ValidacaoException {
        if (this.nmTipoCaixa == null || this.nmTipoCaixa.trim().isEmpty()) {
            throw new ValidacaoException("Campo nome não preenchido!");
        }
    }

}
