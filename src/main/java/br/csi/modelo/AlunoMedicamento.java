/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.modelo;

import br.csi.util.Registro;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adriano
 */
public class AlunoMedicamento extends Registro implements Serializable {
    Integer id;
    
    @NotNull(message = "O nome deve ser preenchido")
    @Size(min = 5, message = "Nome deve ter pelo menos 5 carateres")
    String nome;
    String descricao;
    Aluno aluno;
    
    public AlunoMedicamento(){
        
    }
    
    public AlunoMedicamento(Integer id, String nome, String descricao, Aluno aluno){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
