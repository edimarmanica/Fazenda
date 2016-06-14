/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import br.edimarmanica.fazenda.model.domain.Pessoa;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author edimar
 */
public class PessoaDaoImpl extends CrudDaoImpl<Pessoa, Integer> {

    @Override
    protected Integer getChave(Pessoa e) {
        return e.getCdPessoa();
    }

    @Override
    protected String getSql(Pessoa e) {
        StringBuilder sql = new StringBuilder("FROM Pessoa p ");
        sql.append("WHERE 1=1 ");

        if (e.getCdPessoa() != null) {
            sql.append("AND p.cdPessoa = :codigo ");
        }

        if (e.getNmPessoa() != null) {
            sql.append("AND p.nmPessoa like :nome ");
        }
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getSqlParametros(Pessoa e) {
        Map<String, Object> params = new HashMap<>();
        if (e.getCdPessoa() != null) {
            params.put("codigo", e.getCdPessoa());
        }

        if (e.getNmPessoa() != null) {
            params.put("nome", "%" + e.getNmPessoa() + "%");
        }
        return params;
    }
}
