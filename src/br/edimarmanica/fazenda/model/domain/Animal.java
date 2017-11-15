/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import br.edimarmanica.fazenda.model.domain.converters.BooleanoConverter;
import br.edimarmanica.fazenda.model.domain.enums.Booleano;
import br.edimarmanica.fazenda.model.domain.enums.Cor;
import br.edimarmanica.fazenda.model.domain.enums.Sexo;
import br.edimarmanica.fazenda.model.domain.enums.SituacaoAnimal;
import br.edimarmanica.fazenda.model.domain.converters.CorConverter;
import br.edimarmanica.fazenda.model.domain.converters.SexoConverter;
import br.edimarmanica.fazenda.model.domain.converters.SituacaoAnimalConverter;
import br.edimarmanica.fazenda.model.domain.enums.Option;
import br.edimarmanica.fazenda.util.DateUtils;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edimar
 */
@Entity
@Table(name = "animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findByCdAnimal", query = "SELECT a FROM Animal a WHERE a.cdAnimal = :cdAnimal"),
    @NamedQuery(name = "Animal.findByNmAnimal", query = "SELECT a FROM Animal a WHERE a.nmAnimal = :nmAnimal"),
    @NamedQuery(name = "Animal.findByIdSexo", query = "SELECT a FROM Animal a WHERE a.idSexo = :idSexo"),
    @NamedQuery(name = "Animal.findByIdSituacao", query = "SELECT a FROM Animal a WHERE a.idSituacao = :idSituacao"),
    @NamedQuery(name = "Animal.findByDtNascimento", query = "SELECT a FROM Animal a WHERE a.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Animal.findByVlVenda", query = "SELECT a FROM Animal a WHERE a.vlVenda = :vlVenda"),
    @NamedQuery(name = "Animal.findByDtVenda", query = "SELECT a FROM Animal a WHERE a.dtVenda = :dtVenda"),
    @NamedQuery(name = "Animal.findByDtPegouCria", query = "SELECT a FROM Animal a WHERE a.dtPegouCria = :dtPegouCria"),
    @NamedQuery(name = "Animal.findByIdMamando", query = "SELECT a FROM Animal a WHERE a.idMamando = :idMamando"),
    @NamedQuery(name = "Animal.findByDsObservacao", query = "SELECT a FROM Animal a WHERE a.dsObservacao = :dsObservacao"),
    @NamedQuery(name = "Animal.findByIdCor", query = "SELECT a FROM Animal a WHERE a.idCor = :idCor")})
public class Animal extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "cd_animal")
    private Integer cdAnimal;
    @Basic(optional = false)
    @Column(name = "nm_animal")
    private String nmAnimal;
    @Basic(optional = false)
    @Convert(converter = SexoConverter.class)
    @Column(name = "id_sexo")
    private Sexo idSexo;
    @Basic(optional = false)
    @Convert(converter = SituacaoAnimalConverter.class)
    @Column(name = "id_situacao")
    private SituacaoAnimal idSituacao = SituacaoAnimal.Normal;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_venda")
    private Double vlVenda;
    @Column(name = "dt_venda")
    @Temporal(TemporalType.DATE)
    private Date dtVenda;
    @Column(name = "dt_pegou_cria")
    @Temporal(TemporalType.DATE)
    private Date dtPegouCria;
    @Basic(optional = false)
    @Convert(converter = BooleanoConverter.class)
    @Column(name = "id_mamando")
    private Option idMamando;
    @Column(name = "ds_observacao")
    private String dsObservacao;
    @Column(name = "id_cor")
    @Convert(converter = CorConverter.class)
    private Cor idCor;
    @JoinColumn(name = "cd_animal_mae", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdAnimalMae;
    @JoinColumn(name = "cd_animal_pai", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdAnimalPai;
    @JoinColumn(name = "cd_touro_pegou_cria", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdTouroPegouCria;
    @JoinColumn(name = "cd_pessoa", referencedColumnName = "cd_pessoa")
    @ManyToOne
    private Pessoa pessoa;

    public Animal() {
    }

    public Animal(Integer cdAnimal) {
        this.cdAnimal = cdAnimal;
    }

    public Animal(Integer cdAnimal, String nmAnimal, Sexo idSexo, SituacaoAnimal idSituacao, Booleano idMamando) {
        this.cdAnimal = cdAnimal;
        this.nmAnimal = nmAnimal;
        this.idSexo = idSexo;
        this.idSituacao = idSituacao;
        this.idMamando = idMamando;
    }

    public Integer getCdAnimal() {
        return cdAnimal;
    }

    public void setCdAnimal(Integer cdAnimal) {
        this.cdAnimal = cdAnimal;
    }

    public String getNmAnimal() {
        return nmAnimal;
    }

    public void setNmAnimal(String nmAnimal) {
        this.nmAnimal = nmAnimal.toUpperCase();
    }

    public Sexo getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Sexo idSexo) {
        this.idSexo = idSexo;
    }

    public SituacaoAnimal getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(SituacaoAnimal idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Double getVlVenda() {
        return vlVenda;
    }

    public void setVlVenda(Double vlVenda) {
        this.vlVenda = vlVenda;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Date getDtPegouCria() {
        return dtPegouCria;
    }

    public void setDtPegouCria(Date dtPegouCria) {
        this.dtPegouCria = dtPegouCria;
    }

    public Option getIdMamando() {
        return idMamando;
    }

    public void setIdMamando(Option idMamando) {
        this.idMamando = idMamando;
    }

    public String getDsObservacao() {
        return dsObservacao;
    }

    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
    }

    public Cor getIdCor() {
        return idCor;
    }

    public void setIdCor(Cor idCor) {
        this.idCor = idCor;
    }

    public Animal getCdAnimalMae() {
        return cdAnimalMae;
    }

    public void setCdAnimalMae(Animal cdAnimalMae) {
        this.cdAnimalMae = cdAnimalMae;
    }

    public Animal getCdAnimalPai() {
        return cdAnimalPai;
    }

    public void setCdAnimalPai(Animal cdAnimalPai) {
        this.cdAnimalPai = cdAnimalPai;
    }

    public Animal getCdTouroPegouCria() {
        return cdTouroPegouCria;
    }

    public void setCdTouroPegouCria(Animal cdTouroPegouCria) {
        this.cdTouroPegouCria = cdTouroPegouCria;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdAnimal != null ? cdAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.cdAnimal == null && other.cdAnimal != null) || (this.cdAnimal != null && !this.cdAnimal.equals(other.cdAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nmAnimal;
    }

    @Override
    public void validar() throws ValidacaoException {
        if (this.nmAnimal == null || this.nmAnimal.trim().isEmpty()) {
            throw new ValidacaoException("Campo nome não preenchido!");
        }
    }
    
    public int getAnos(){
        return DateUtils.getYears(dtNascimento);
    }
    
    public int getMeses(){
        return DateUtils.getMonths(dtNascimento);
    }
    
    public Date getPrevisaoCria(){
        return DateUtils.addDays(dtPegouCria, 0, 9, 20, true);
    }

}
