package br.csi.dao;

import br.csi.modelo.Usuario;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/*

create table usuario(
login varchar(50),
senha varchar(50) not null,
primary key (login)
)

 */
@Component
public class UsuarioDAO implements DAO<Usuario> {

    public boolean autenticado(Usuario u) throws Exception {

        String sql = "select * from usuario "
                + "            where login = '" + u.getLogin() + "' "
                + "            and senha = '" + u.getSenha() + "'";

        PreparedStatement stmt = ConectaPostgres.
                getConexao().
                prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Usuario logado "
                    + rs.getString("login"));
            return true;
        }

        return false;
    }

    @Override
    public boolean atualizar(Usuario u) throws Exception {
        String sql = "update usuario set login =?, senha =? "
                + "where login = ?";
        PreparedStatement stmt
                = ConectaPostgres.getConexao()
                        .prepareStatement(sql);

        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getLogin());

        stmt.executeUpdate();
        return true;
    }

    public Usuario getUsuario(String login) throws Exception {
        String sql = "select * from usuario where login =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();
        Usuario u = new Usuario();
        while (rs.next()) {
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
        }
        return u;
    }

    @Override
    public boolean deletar(Usuario usuario) throws Exception {

        String sql = "DELETE from usuario where login =?";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1, usuario.getLogin());
        stmt.executeUpdate();
        return true;
    }

    @Override
    public Integer inserir(Usuario usuario) throws Exception {
        String sql = "insert into usuario(login, senha) "
                + "values(?,?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public ArrayList<Usuario> listar() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // carregar o driver           
        // criar a declaracao (statement) sql
        String sql = "select * from usuario";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        // executar instrucao sql
        ResultSet rs = stmt.executeQuery();
        // manipular o resultado da instrucao sql
        while (rs.next()) {

            String login = rs.getString("login");
            String senha = rs.getString("senha");
            //System.out.println("id: "+id+" login: "+login+" senha: "+senha);

            Usuario usuario = new Usuario(login, senha);
            usuarios.add(usuario);
        }

        System.out.println("Metodo executado com sucesso...");

        return usuarios;
    }

    @Override
    public Usuario get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
