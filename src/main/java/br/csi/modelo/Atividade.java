/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.modelo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author adriano
 */
public class Atividade implements Serializable {

    private Integer id;
    private String descricao;
    private Date data;
    private Turma turma;
//    private Time hora;
//    private String plano_saude;
//    private String plano_numero;
//    private String sexo;
    public Atividade(){
        
    }
    public Atividade(Integer id, String descricao, Date data, Turma turma){
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.turma = turma;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
}
