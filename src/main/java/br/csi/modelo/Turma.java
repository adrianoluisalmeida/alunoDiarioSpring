package br.csi.modelo;

import java.io.Serializable;

/**
 *
 * @author adriano
 */
public class Turma implements Serializable{

    private Integer id;
    private String nome;

    public Turma() {

    }

    public Turma(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Turma(String nome) {
        this.nome = nome;
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

}
