/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import br.edimarmanica.fazenda.model.domain.TipoCaixa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edimar
 */
public class TipoCaixaDaoImpl extends CrudDaoImpl<TipoCaixa, Integer> {

    @Override
    protected Integer getChave(TipoCaixa e) {
        return e.getCdTipoCaixa();
    }

    @Override
    protected String getSql(TipoCaixa e) {
        StringBuilder sql = new StringBuilder("FROM TipoCaixa p ");
        sql.append("WHERE 1=1 ");

        if (e.getCdTipoCaixa()!= null) {
            sql.append("AND p.cdTipoCaixa = :codigo ");
        }

        if (e.getNmTipoCaixa()!= null) {
            sql.append("AND p.nmTipoCaixa like :nome ");
        }
        
        if (e.getCdTipoCaixaPai() != null){
            sql.append("AND p.cdTipoCaixaPai.cdTipoCaixa = :tipoPai ");
        }
        
        if (e.getIdTipo() != null){
            sql.append("AND p.idTipo = :fluxo ");
        }
        
         if (e.getCdBb() != null){
            sql.append("AND p.cdBb = :cdBb ");
        }
        
        sql.append(getSqlExtension(e));
        
        sql.append("ORDER BY p.nmTipoCaixa");
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getSqlParametros(TipoCaixa e) {
        Map<String, Object> params = new HashMap<>();
        if (e.getCdTipoCaixa()!= null) {
            params.put("codigo", e.getCdTipoCaixa());
        }

        if (e.getNmTipoCaixa()!= null) {
            params.put("nome", "%" + e.getNmTipoCaixa()+ "%");
        }
        
        if (e.getCdTipoCaixaPai()!= null) {
            params.put("tipoPai", e.getCdTipoCaixaPai());
        }
        
        if (e.getIdTipo() != null){
            params.put("fluxo", e.getIdTipo());
        }
        
        if (e.getCdBb()!= null){
            params.put("cdBb", e.getCdBb());
        }
        
        return params;
    }
    
    public List<TipoCaixa> buscarTiposCaixaPai(){
        TipoCaixaDaoImpl dao = new TipoCaixaDaoImpl();
        TipoCaixa requisitos = new TipoCaixa();
        requisitos.addNullField("p.cdTipoCaixaPai");
        return dao.search(requisitos);
    }
}
