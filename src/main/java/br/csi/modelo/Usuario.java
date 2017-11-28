package br.csi.modelo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario implements Serializable {

    @NotNull(message = "O campo login deve ser preenchido")
    @Size(min = 4, message = "Login deve ter pelo menos 4 carateres")
    private String login;
    @NotNull(message = "O campo senha deve ser preenchido")
    @Size(min = 4, message = "Senha deve ter pelo menos 4 carateres")
    private String senha;

    public Usuario(String login, String senha) {
        this.senha = senha;
        this.login = login;
    }

    public Usuario() {

    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
