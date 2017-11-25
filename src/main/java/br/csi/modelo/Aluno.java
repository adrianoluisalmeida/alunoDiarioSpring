package br.csi.modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adriano
 */
public class Aluno implements Serializable {

    private Integer id;

    @NotNull(message = "O nome deve ser preenchido")
    @Size(min = 5, message = "Nome deve ter pelo menos 5 carateres")
    private String nome;
    private String plano_saude;
    private String plano_numero;
    private String sexo;
    private Date nascimento;
    private Turma turma;

//    public void Aluno(Integer id, String nome, String plano_saude, String plano_numero, String sexo, String nascimento) {
//        this.id = id;
//        this.nome = nome;
//        this.plano_saude = plano_saude;
//        this.plano_numero = plano_numero;
//        this.sexo = sexo;
//        this.nascimento = nascimento;
//    }
//    public Aluno(Integer id, String nome, String plano_saude, String plano_numero, String sexo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public Aluno(Integer id, String nome, String plano_saude, String plano_numero, String sexo, Date nascimento) {
        this.id = id;
        this.nome = nome;
        this.plano_saude = plano_saude;
        this.plano_numero = plano_numero;
        this.sexo = sexo;
        this.nascimento = nascimento;
    }

    public Aluno(Integer id, String nome, String plano_saude, String plano_numero, String sexo, Date nascimento, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.plano_saude = plano_saude;
        this.plano_numero = plano_numero;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.turma = turma;
    }

    public Aluno() {

    }

    public Aluno(int id) {
       this.id = id;
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

    public String getPlano_saude() {
        return plano_saude;
    }

    public void setPlano_saude(String plano_saude) {
        this.plano_saude = plano_saude;
    }

    public String getPlano_numero() {
        return plano_numero;
    }

    public void setPlano_numero(String plano_numero) {
        this.plano_numero = plano_numero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
