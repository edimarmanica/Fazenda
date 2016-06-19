/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import br.edimarmanica.fazenda.model.domain.Animal;
import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.domain.enums.Sexo;
import br.edimarmanica.fazenda.model.domain.enums.SituacaoAnimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edimar
 */
public class AnimalDaoImpl extends CrudDaoImpl<Animal, Integer> {

    @Override
    protected Integer getChave(Animal e) {
        return e.getCdAnimal();
    }

    @Override
    protected String getSql(Animal e) {
        StringBuilder sql = new StringBuilder("FROM Animal p ");
        sql.append("WHERE 1=1 ");

        if (e.getPessoa() != null) {
            sql.append("AND p.cdAnimal = :codigo ");
        }

        if (e.getNmAnimal()!= null) {
            sql.append("AND p.nmAnimal like :nome ");
        }
        
        if (e.getPessoa() != null){
            sql.append("AND p.pessoa.cdPessoa = :cdPessoa ");
        }
        
        if (e.getIdSexo() != null){
            sql.append("AND p.idSexo = :sexo ");
        }
        
        if (e.getIdSituacao()!= null){
            sql.append("AND p.idSituacao = :situacao ");
        }
        
        sql.append(getSqlExtension(e));
        
        sql.append("ORDER BY p.dtNascimento DESC");
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getSqlParametros(Animal e) {
        Map<String, Object> params = new HashMap<>();
        if (e.getPessoa() != null) {
            params.put("codigo", e.getPessoa());
        }

        if (e.getNmAnimal()!= null) {
            params.put("nome", "%" + e.getNmAnimal()+ "%");
        }
        
        if (e.getPessoa() != null){
            params.put("cdPessoa", e.getPessoa().getCdPessoa());
        }
        
        if (e.getIdSexo() != null){
            params.put("sexo", e.getIdSexo());
        }
        
        if (e.getIdSituacao()!= null){
            params.put("situacao", e.getIdSituacao());
        }
        return params;
    }
    
    public List<Pessoa> buscarPessoas(){
        PessoaDaoImpl pessoaDao = new PessoaDaoImpl();
        return pessoaDao.search(new Pessoa(), 0, 1000);
    }
    
    public List<Animal> buscarTourosAtivos(){
        AnimalDaoImpl dao = new AnimalDaoImpl();
        Animal requisitos = new Animal();
        requisitos.setIdSexo(Sexo.M);
        requisitos.setIdSituacao(SituacaoAnimal.Normal);
        return dao.search(requisitos, 0, 1000);
    }
    
    public List<Animal> buscarVacasAtivas(){
        AnimalDaoImpl dao = new AnimalDaoImpl();
        Animal requisitos = new Animal();
        requisitos.setIdSexo(Sexo.F);
        requisitos.setIdSituacao(SituacaoAnimal.Normal);
        return dao.search(requisitos, 0, 1000);
    }
}
