package br.csi.dao;

import br.csi.modelo.Profissional;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;


@Component
public class ProfissionalDAO {

    public boolean atualizar(Profissional p) throws Exception {
        String sql = "update profissional set nome=?, sexo=?, email=?, funcao=?"
                + "where id = ?";
        PreparedStatement stmt
                = ConectaPostgres.getConexao()
                        .prepareStatement(sql);

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getSexo());
        stmt.setString(3, p.getEmail());
        stmt.setString(4, p.getFuncao());
        stmt.setInt(5, p.getId());

        stmt.executeUpdate();
        return true;
    }

    public Profissional get(Integer id) throws Exception {
        String sql = "select * from profissional where id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Profissional a = new Profissional();
        while (rs.next()) {
            a.setNome(rs.getString("nome"));
            a.setSexo(rs.getString("sexo"));
            a.setEmail(rs.getString("email"));
            a.setFuncao(rs.getString("funcao"));
        }
        return a;
    }

    public boolean deletar(Profissional profissional) throws Exception {

        String sql = "DELETE from profissional where id =?";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, profissional.getId());
        stmt.executeUpdate();
        return true;
    }

    public Integer inserir(Profissional profissional) throws Exception {
        String sql = "insert into profissional(nome, sexo, email, funcao) "
                + "values(?, ?, ?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setString(1, profissional.getNome());
        stmt.setString(2, profissional.getSexo());
        stmt.setString(3, profissional.getEmail());
        stmt.setString(4, profissional.getFuncao());

//        System.out.println("nome: + profissional.getNome() + "plano saude:" + profissional.getPlano_saude());
        stmt.executeUpdate();

        // now get the ID:
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        
        return 0;
//         productId;
//        resturn true;
    }

    public ArrayList<Profissional> listar() throws Exception {
        ArrayList<Profissional> profissionais = new ArrayList<>();

        String sql = "select * from profissional";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");
            String sexo = rs.getString("sexo");
            String email = rs.getString("email");
            String funcao = rs.getString("funcao");

            Profissional profissional = new Profissional(id, nome, sexo, email, funcao);
            profissionais.add(profissional);
        }

        System.out.println("Metodo executado com sucesso...");

        return profissionais;
    }

}
