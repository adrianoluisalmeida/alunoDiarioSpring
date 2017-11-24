package br.csi.modelo;

import java.io.Serializable;
//import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adriano
 */
public class Turma implements Serializable {

    private Integer id;
    
    @NotNull(message="O nome deve ser preenchido")
    @Size(min = 5, message="Nome deve ter pelo menos 5 carateres")
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
