package br.csi.dao;

//import br.csi.modelo.Aluno;
import br.csi.modelo.Atividade;
import br.csi.modelo.Turma;
import br.csi.util.ConectaPostgres;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class AtividadeDAO {

    public boolean atualizar(Atividade a) throws Exception {
        String sql = "update atividade set descricao=?, data=?, turma_id=?, hora=? "
                + "where id = ?";
        PreparedStatement stmt
                = ConectaPostgres.getConexao()
                        .prepareStatement(sql);

        stmt.setString(1, a.getDescricao());
        stmt.setDate(2, new java.sql.Date(a.getData().getTime()));
        stmt.setInt(3, a.getTurma().getId());
        stmt.setTime(4, a.getHora());
        stmt.setInt(5, a.getId());

        System.out.println("descricao:" + a.getDescricao() + " hora: " + a.getHora() + " turma" + a.getTurma().getId());

        stmt.executeUpdate();
        return true;
    }

    public Atividade get(Integer id) throws Exception {
        String sql = "select atividade.*, turma.nome as turma_nome from atividade inner join turma on turma.id = atividade.turma_id where atividade.id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Atividade a = new Atividade();

        while (rs.next()) {
            a.setDescricao(rs.getString("descricao"));
            a.setData(rs.getDate("data"));
            a.setHora(rs.getTime("hora"));
            a.setTurma(new Turma(rs.getInt("turma_id"), rs.getString("turma_nome")));
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
        String sql = "insert into atividade(descricao, data, turma_id, hora) "
                + "values(?, ?, ?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setString(1, atividade.getDescricao());
        stmt.setDate(2, new java.sql.Date(atividade.getData().getTime()));
        stmt.setInt(3, atividade.getTurma().getId());
        stmt.setTime(4, atividade.getHora());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public ArrayList<Atividade> listar() throws Exception {
        ArrayList<Atividade> atividades = new ArrayList<>();

        String sql = "select *, turma.nome as nome_turma from atividade inner join turma on atividade.turma_id = turma.id";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String descricao = rs.getString("descricao");
            Date data = rs.getDate("data");
            Turma turma = new Turma(rs.getInt("turma_id"), rs.getString("nome_turma"));
            Time hora = rs.getTime("hora");

            Atividade atividade = new Atividade(id, descricao, data, turma, hora);
            atividades.add(atividade);
        }

        System.out.println("Metodo executado com sucesso...");

        return atividades;
    }


}
