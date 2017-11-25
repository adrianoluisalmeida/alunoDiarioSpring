package br.csi.modelo;

import java.io.Serializable;

/**
 *
 * @author adriano
 */
public class Profissional implements Serializable {

    private Integer id;
    private String nome;
    private String sexo;
    private String email;
    private String funcao;

    public Profissional() {
    }

    public Profissional(Integer id) {
        this.id = id;
    }

    public Profissional(Integer id, String nome, String sexo, String email, String funcao) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.funcao = funcao;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
