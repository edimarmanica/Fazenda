/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.control;

import br.edimarmanica.fazenda.model.dao.CaixaDaoImpl;
import br.edimarmanica.fazenda.model.dao.Conexao;
import br.edimarmanica.fazenda.model.dao.TipoCaixaDaoImpl;
import br.edimarmanica.fazenda.model.domain.Caixa;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import br.edimarmanica.fazenda.model.domain.Pessoa;
import br.edimarmanica.fazenda.model.domain.TipoCaixa;
import br.edimarmanica.fazenda.util.ValidacaoException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author edimar
 */
public final class LoadBBControl {

    private List<Pessoa> pessoaCombo;
    private String file;
    private Pessoa pessoa;

    private final CaixaDaoImpl daoCaixa;
    private final TipoCaixaDaoImpl daoTipo;

    public LoadBBControl() {
        daoCaixa = new CaixaDaoImpl();
        daoTipo = new TipoCaixaDaoImpl();
        cfgComboBD();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoaCombo() {
        return pessoaCombo;
    }

    public void setPessoaCombo(List<Pessoa> pessoaCombo) {
        this.pessoaCombo = pessoaCombo;
    }

    public void cfgComboBD() {
        pessoaCombo = ObservableCollections.observableList(new ArrayList<Pessoa>());
        pessoaCombo.addAll(daoCaixa.buscarPessoas());
    }

    public void load() throws ValidacaoException {

        if (pessoa == null) {
            throw new ValidacaoException("Preencha o campo Pessoa!");
        }

        if (file == null) {
            throw new ValidacaoException("Preencha o campo Arquivo!");
        }

        if (!load(pessoa, file)) {
            throw new ValidacaoException("Problemas ao importar os dados!");
        }
    }

    private boolean load(Pessoa pessoa, String file) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        boolean error = false;

        try (CSVParser parser = CSVParser.parse(new File(file), Charset.forName("ISO-8859-1"), CSVFormat.EXCEL.withHeader())) {
            for (CSVRecord record : parser) {
                TipoCaixa tc = new TipoCaixa();
                tc.setCdBb(new BigInteger(record.get("Número do documento")));

                if (tc.getCdBb() != null) {
                    List<TipoCaixa> tcs = daoTipo.search(tc);
                    if (tcs != null && tcs.size() == 1) {
                        Caixa caixa = new Caixa();
                        caixa.setCdTipoCaixa(tcs.get(0));
                        caixa.setCdPessoa(pessoa);
                        caixa.setVlCaixa(Math.abs(new Double(record.get("Valor"))));
                        caixa.setDtPagamento(new Date(record.get("Data")));
                        caixa.setDtVencimento(new Date(record.get("Data")));
                        caixa.setDsCaixa("IMPORTAÇÃO BB 02");
                        em.persist(caixa);
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(LoadBBControl.class.getName()).log(Level.SEVERE, null, ex);
            error = true;
        }

        if (!error) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }
        em.close();
        return !error;
    }

}
