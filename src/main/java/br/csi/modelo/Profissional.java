package br.csi.modelo;

import br.csi.util.Registro;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author adriano
 */
public class Profissional extends Registro implements Serializable {

    private Integer id;
    @NotNull(message = "O campo nome deve ser preenchido")
    private String nome;
    @NotNull(message = "O sexo deve ser preenchido")
    private String sexo;
    @NotNull(message = "O email deve ser preenchido")
    private String email;
    @NotNull(message = "O funcao deve ser preenchido")
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
