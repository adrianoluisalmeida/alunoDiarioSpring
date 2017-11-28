package br.csi.dao;

import br.csi.modelo.Aluno;
import br.csi.modelo.AlunoMedicamento;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class AlunoMedicamentoDAO {

    public AlunoMedicamento get(Integer id) throws Exception {
        String sql = "select * from aluno_medicamento where id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        AlunoMedicamento a = new AlunoMedicamento();
        while (rs.next()) {
            a.setNome(rs.getString("nome"));
            a.setDescricao(rs.getString("descricao"));
            a.setAluno(new Aluno(rs.getInt("aluno_id")));
        }
        return a;
    }

    public boolean deletar(AlunoMedicamento aluno) throws Exception {

        String sql = "DELETE from aluno_medicamento where id =?";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, aluno.getId());
        stmt.executeUpdate();
        return true;
    }

    public boolean inserir(AlunoMedicamento aluno) throws Exception {
        String sql = "insert into aluno_medicamento(nome, descricao, aluno_id) "
                + "values(?, ?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getDescricao());
        stmt.setInt(3, aluno.getAluno().getId());

        stmt.execute();
        return true;
    }

    public ArrayList<AlunoMedicamento> listar(Integer aluno_id) throws Exception {
        ArrayList<AlunoMedicamento> alunoMedicamentos = new ArrayList<>();

        String sql = "select * from aluno_medicamento where aluno_id = ?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, aluno_id);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Aluno al = new Aluno(rs.getInt("aluno_id"));

            AlunoMedicamento aluno = new AlunoMedicamento(id, nome, descricao, al);
            alunoMedicamentos.add(aluno);
        }

        return alunoMedicamentos;
    }

}