/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.dao;

import br.edimarmanica.fazenda.model.domain.Animal;
import br.edimarmanica.fazenda.model.domain.Caixa;
import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.domain.TipoCaixa;
import br.edimarmanica.fazenda.model.domain.enums.Booleano;
import br.edimarmanica.fazenda.model.domain.enums.SituacaoAnimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edimar
 */
public class CaixaDaoImpl extends CrudDaoImpl<Caixa, Integer> {

    @Override
    protected Integer getChave(Caixa e) {
        return e.getCdCaixa();
    }

    @Override
    protected String getSql(Caixa e) {
        StringBuilder sql = new StringBuilder("FROM Caixa p ");
        sql.append("WHERE 1=1 ");

        if (e.getCdAnimal() != null) {
            sql.append("AND p.cdCaixa = :codigo ");
        }

        if (e.getDsCaixa() != null) {
            sql.append("AND p.dsCaixa like :descricao ");
        }

        if (e.getCdPessoa() != null) {
            sql.append("AND p.cdPessoa.cdPessoa = :cdPessoa ");
        }

        if (e.getIdEmprestimo() != null) {
            sql.append("AND p.idEmprestimo = :emprestimo ");
        }

        if (e.getDtPagamentoMaior() != null) {
            sql.append("AND p.dtPagamento >= :dtPgtoMaior ");
        }

        if (e.getDtPagamentoMenor() != null) {
            sql.append("AND p.dtPagamento <= :dtPgtoMenor ");
        }

        if (e.getDtVencimentoMaior() != null) {
            sql.append("AND p.dtVencimento >= :dtVctoMaior ");
        }

        if (e.getDtVencimentoMenor() != null) {
            sql.append("AND p.dtVencimento <= :dtVctoMenor ");
        }

        if (e.getIdPago() != null) {
            if (e.getIdPago() == Booleano.Nao) {
                sql.append("AND p.dtPagamento IS NULL ");
            } else {
                sql.append("AND p.dtPagamento IS NOT NULL ");
            }
        }

        sql.append(getSqlExtension(e));

        sql.append("ORDER BY p.dtPagamento DESC, p.dtVencimento DESC");
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getSqlParametros(Caixa e) {
        Map<String, Object> params = new HashMap<>();
        if (e.getCdAnimal() != null) {
            params.put("codigo", e.getCdAnimal());
        }

        if (e.getDsCaixa() != null) {
            params.put("descricao", "%" + e.getDsCaixa() + "%");
        }

        if (e.getCdPessoa() != null) {
            params.put("cdPessoa", e.getCdPessoa().getCdPessoa());
        }

        if (e.getIdEmprestimo() != null) {
            params.put("emprestimo", e.getIdEmprestimo());
        }

        if (e.getDtPagamentoMaior() != null) {
            params.put("dtPgtoMaior", e.getDtPagamentoMaior());
        }

        if (e.getDtPagamentoMenor() != null) {
            params.put("dtPgtoMenor", e.getDtPagamentoMenor());
        }

        if (e.getDtVencimentoMaior() != null) {
            params.put("dtVctoMaior", e.getDtVencimentoMaior());
        }

        if (e.getDtVencimentoMenor() != null) {
            params.put("dtVctoMenor", e.getDtVencimentoMenor());
        }

        return params;
    }

    public List<Pessoa> buscarPessoas() {
        PessoaDaoImpl pessoaDao = new PessoaDaoImpl();
        return pessoaDao.search(new Pessoa());
    }

    public List<Animal> buscarAnimaisAtivos() {
        AnimalDaoImpl dao = new AnimalDaoImpl();
        Animal requisitos = new Animal();
        requisitos.setIdSituacao(SituacaoAnimal.Normal);
        return dao.search(requisitos);
    }

    public List<TipoCaixa> buscarTipoCaixa() {
        TipoCaixaDaoImpl dao = new TipoCaixaDaoImpl();
        TipoCaixa requisitos = new TipoCaixa();
        requisitos.addNotNullField("p.cdTipoCaixa");
        return dao.search(requisitos);
    }
}
