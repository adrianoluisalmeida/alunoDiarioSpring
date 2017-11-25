package br.csi.dao;

import br.csi.modelo.Aluno;
import br.csi.modelo.Atividade;
import br.csi.modelo.Turma;
import br.csi.util.ConectaPostgres;
import java.sql.Date;
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
public class AtividadeDAO {

    public boolean atualizar(Atividade a) throws Exception {
        String sql = "update atividade set descricao=?, data=?, turma_id=? "
                + "where id = ?";
        PreparedStatement stmt
                = ConectaPostgres.getConexao()
                        .prepareStatement(sql);

        stmt.setString(1, a.getDescricao());
        stmt.setDate(2, a.getData());
        stmt.setInt(3, a.getTurma().getId());
        stmt.setInt(4, a.getId());

        System.out.println("descricao:" + a.getDescricao() + " data: " + a.getData() + " turma" + a.getTurma().getId());

        stmt.executeUpdate();
        return true;
    }

    public Atividade get(Integer id) throws Exception {
        String sql = "select * from atividade where id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Atividade a = new Atividade();
        while (rs.next()) {
            a.setDescricao(rs.getString("descricao"));
            a.setData(rs.getDate("data"));
            a.setTurma(new Turma(rs.getInt("turma_id")));
        }
        return a;
    }

    public boolean deletar(Atividade atividade) throws Exception {

        String sql = "DELETE from atividade where id =?";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, atividade.getId());
        stmt.executeUpdate();
        return true;
    }

    public Integer inserir(Atividade atividade) throws Exception {
        String sql = "insert into atividade(descricao, data, turma_id) "
                + "values(?, ?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setString(1, atividade.getDescricao());
        stmt.setDate(2, atividade.getData());
        stmt.setInt(3, atividade.getTurma().getId());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public ArrayList<Atividade> listar() throws Exception {
        ArrayList<Atividade> atividades = new ArrayList<>();

        String sql = "select * from atividade";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String descricao = rs.getString("descricao");
            Date data = rs.getDate("data");
            Turma turma = new Turma(rs.getInt("turma_id"));
//            String plano_saude = rs.getString("plano_saude");
//            String plano_numero = rs.getString("plano_numero");
//            String sexo = rs.getString("plano_numero");

            Atividade atividade = new Atividade(id, descricao, data, turma);
            atividades.add(atividade);
        }

        System.out.println("Metodo executado com sucesso...");

        return atividades;
    }

}
