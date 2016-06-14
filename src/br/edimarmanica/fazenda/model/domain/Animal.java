/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
public class Animal implements Serializable {

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
    @Column(name = "id_sexo")
    private short idSexo;
    @Basic(optional = false)
    @Column(name = "id_situacao")
    private short idSituacao;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_venda")
    private BigDecimal vlVenda;
    @Column(name = "dt_venda")
    @Temporal(TemporalType.DATE)
    private Date dtVenda;
    @Column(name = "dt_pegou_cria")
    @Temporal(TemporalType.DATE)
    private Date dtPegouCria;
    @Basic(optional = false)
    @Column(name = "id_mamando")
    private short idMamando;
    @Column(name = "ds_observacao")
    private String dsObservacao;
    @Column(name = "id_cor")
    private Integer idCor;
    @OneToMany(mappedBy = "cdAnimal")
    private Collection<Caixa> caixaCollection;
    @OneToMany(mappedBy = "cdAnimalMae")
    private Collection<Animal> animalCollection;
    @JoinColumn(name = "cd_animal_mae", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdAnimalMae;
    @OneToMany(mappedBy = "cdAnimalPai")
    private Collection<Animal> animalCollection1;
    @JoinColumn(name = "cd_animal_pai", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdAnimalPai;
    @OneToMany(mappedBy = "cdTouroPegouCria")
    private Collection<Animal> animalCollection2;
    @JoinColumn(name = "cd_touro_pegou_cria", referencedColumnName = "cd_animal")
    @ManyToOne
    private Animal cdTouroPegouCria;
    @JoinColumn(name = "cd_pessoa", referencedColumnName = "cd_pessoa")
    @ManyToOne
    private Pessoa cdPessoa;

    public Animal() {
    }

    public Animal(Integer cdAnimal) {
        this.cdAnimal = cdAnimal;
    }

    public Animal(Integer cdAnimal, String nmAnimal, short idSexo, short idSituacao, short idMamando) {
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
        this.nmAnimal = nmAnimal;
    }

    public short getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(short idSexo) {
        this.idSexo = idSexo;
    }

    public short getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(short idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public BigDecimal getVlVenda() {
        return vlVenda;
    }

    public void setVlVenda(BigDecimal vlVenda) {
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

    public short getIdMamando() {
        return idMamando;
    }

    public void setIdMamando(short idMamando) {
        this.idMamando = idMamando;
    }

    public String getDsObservacao() {
        return dsObservacao;
    }

    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
    }

    public Integer getIdCor() {
        return idCor;
    }

    public void setIdCor(Integer idCor) {
        this.idCor = idCor;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
    }

    @XmlTransient
    public Collection<Animal> getAnimalCollection() {
        return animalCollection;
    }

    public void setAnimalCollection(Collection<Animal> animalCollection) {
        this.animalCollection = animalCollection;
    }

    public Animal getCdAnimalMae() {
        return cdAnimalMae;
    }

    public void setCdAnimalMae(Animal cdAnimalMae) {
        this.cdAnimalMae = cdAnimalMae;
    }

    @XmlTransient
    public Collection<Animal> getAnimalCollection1() {
        return animalCollection1;
    }

    public void setAnimalCollection1(Collection<Animal> animalCollection1) {
        this.animalCollection1 = animalCollection1;
    }

    public Animal getCdAnimalPai() {
        return cdAnimalPai;
    }

    public void setCdAnimalPai(Animal cdAnimalPai) {
        this.cdAnimalPai = cdAnimalPai;
    }

    @XmlTransient
    public Collection<Animal> getAnimalCollection2() {
        return animalCollection2;
    }

    public void setAnimalCollection2(Collection<Animal> animalCollection2) {
        this.animalCollection2 = animalCollection2;
    }

    public Animal getCdTouroPegouCria() {
        return cdTouroPegouCria;
    }

    public void setCdTouroPegouCria(Animal cdTouroPegouCria) {
        this.cdTouroPegouCria = cdTouroPegouCria;
    }

    public Pessoa getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Pessoa cdPessoa) {
        this.cdPessoa = cdPessoa;
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
        return "br.edimarmanica.fazenda.bd.Animal[ cdAnimal=" + cdAnimal + " ]";
    }
    
}
