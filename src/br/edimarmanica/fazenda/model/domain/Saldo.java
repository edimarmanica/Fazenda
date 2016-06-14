/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edimar
 */
@Entity
@Table(name = "saldo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saldo.findAll", query = "SELECT s FROM Saldo s"),
    @NamedQuery(name = "Saldo.findByCdSaldo", query = "SELECT s FROM Saldo s WHERE s.cdSaldo = :cdSaldo"),
    @NamedQuery(name = "Saldo.findByDtSaldo", query = "SELECT s FROM Saldo s WHERE s.dtSaldo = :dtSaldo"),
    @NamedQuery(name = "Saldo.findByVlSaldo", query = "SELECT s FROM Saldo s WHERE s.vlSaldo = :vlSaldo")})
public class Saldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_saldo")
    private Integer cdSaldo;
    @Basic(optional = false)
    @Column(name = "dt_saldo")
    @Temporal(TemporalType.DATE)
    private Date dtSaldo;
    @Basic(optional = false)
    @Column(name = "vl_saldo")
    private BigInteger vlSaldo;

    public Saldo() {
    }

    public Saldo(Integer cdSaldo) {
        this.cdSaldo = cdSaldo;
    }

    public Saldo(Integer cdSaldo, Date dtSaldo, BigInteger vlSaldo) {
        this.cdSaldo = cdSaldo;
        this.dtSaldo = dtSaldo;
        this.vlSaldo = vlSaldo;
    }

    public Integer getCdSaldo() {
        return cdSaldo;
    }

    public void setCdSaldo(Integer cdSaldo) {
        this.cdSaldo = cdSaldo;
    }

    public Date getDtSaldo() {
        return dtSaldo;
    }

    public void setDtSaldo(Date dtSaldo) {
        this.dtSaldo = dtSaldo;
    }

    public BigInteger getVlSaldo() {
        return vlSaldo;
    }

    public void setVlSaldo(BigInteger vlSaldo) {
        this.vlSaldo = vlSaldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdSaldo != null ? cdSaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saldo)) {
            return false;
        }
        Saldo other = (Saldo) object;
        if ((this.cdSaldo == null && other.cdSaldo != null) || (this.cdSaldo != null && !this.cdSaldo.equals(other.cdSaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.Saldo[ cdSaldo=" + cdSaldo + " ]";
    }
    
}
