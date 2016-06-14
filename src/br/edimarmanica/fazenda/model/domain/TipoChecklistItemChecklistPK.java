/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author edimar
 */
@Embeddable
public class TipoChecklistItemChecklistPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cd_item_checklist")
    private int cdItemChecklist;
    @Basic(optional = false)
    @Column(name = "cd_tipo_checklist")
    private int cdTipoChecklist;

    public TipoChecklistItemChecklistPK() {
    }

    public TipoChecklistItemChecklistPK(int cdItemChecklist, int cdTipoChecklist) {
        this.cdItemChecklist = cdItemChecklist;
        this.cdTipoChecklist = cdTipoChecklist;
    }

    public int getCdItemChecklist() {
        return cdItemChecklist;
    }

    public void setCdItemChecklist(int cdItemChecklist) {
        this.cdItemChecklist = cdItemChecklist;
    }

    public int getCdTipoChecklist() {
        return cdTipoChecklist;
    }

    public void setCdTipoChecklist(int cdTipoChecklist) {
        this.cdTipoChecklist = cdTipoChecklist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cdItemChecklist;
        hash += (int) cdTipoChecklist;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoChecklistItemChecklistPK)) {
            return false;
        }
        TipoChecklistItemChecklistPK other = (TipoChecklistItemChecklistPK) object;
        if (this.cdItemChecklist != other.cdItemChecklist) {
            return false;
        }
        if (this.cdTipoChecklist != other.cdTipoChecklist) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.TipoChecklistItemChecklistPK[ cdItemChecklist=" + cdItemChecklist + ", cdTipoChecklist=" + cdTipoChecklist + " ]";
    }
    
}
