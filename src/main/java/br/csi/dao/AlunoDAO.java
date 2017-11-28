package br.csi.dao;

import br.csi.modelo.Aluno;
import br.csi.modelo.Turma;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class AlunoDAO implements DAO<Aluno> {

    @Override
    public boolean atualizar(Aluno a) throws Exception {
        String sql = "update aluno set nome=?, plano_saude=?, plano_numero=?, sexo=?, nascimento=?, turma_id=? "
                + "where id = ?";
        PreparedStatement stmt
                = ConectaPostgres.getConexao()
                        .prepareStatement(sql);

        stmt.setString(1, a.getNome());
        stmt.setString(2, a.getPlano_saude());
        stmt.setString(3, a.getPlano_numero());
        stmt.setString(4, a.getSexo());
        stmt.setDate(5, new java.sql.Date(a.getNascimento().getTime()));
        stmt.setInt(6, a.getTurma().getId());
        stmt.setInt(7, a.getId());

        stmt.executeUpdate();
        return true;
    }

    @Override
    public Aluno get(Integer id) throws Exception {
        String sql = "select * from aluno where id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Aluno a = new Aluno();
        while (rs.next()) {
            a.setNome(rs.getString("nome"));
            a.setPlano_saude(rs.getString("plano_saude"));
            a.setPlano_numero(rs.getString("plano_numero"));
            a.setSexo(rs.getString("sexo"));
            a.setNascimento(rs.getDate("nascimento"));
            a.setTurma(new Turma(rs.getInt("turma_id")));
        }
        return a;
    }

    @Override
    public boolean deletar(Aluno aluno) throws Exception {

        String sql = "DELETE from aluno where id =?";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, aluno.getId());
        stmt.executeUpdate();
        return true;
    }

    @Override
    public Integer inserir(Aluno aluno) throws Exception {
        String sql = "insert into aluno(nome, plano_saude, plano_numero, sexo, nascimento, turma_id) "
                + "values(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getPlano_saude());
        stmt.setString(3, aluno.getPlano_numero());
        stmt.setString(4, aluno.getSexo());
        stmt.setDate(5, new java.sql.Date(aluno.getNascimento().getTime()));
        stmt.setInt(6, aluno.getTurma().getId());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    @Override
    public ArrayList<Aluno> listar() throws Exception {
        ArrayList<Aluno> alunos = new ArrayList<>();

        String sql = "select * from aluno order by id desc";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");
            String plano_saude = rs.getString("plano_saude");
            String plano_numero = rs.getString("plano_numero");
            String sexo = rs.getString("sexo");
            Date nascimento = rs.getDate("nascimento");

            Aluno aluno = new Aluno(id, nome, plano_saude, plano_numero, sexo, nascimento);
            alunos.add(aluno);
        }

        return alunos;
    }

    public ArrayList<Aluno> listarAlunosAtividades(Integer atividade_id) throws Exception {
        ArrayList<Aluno> alunosAtividades = new ArrayList<>();

        String sql = "select *, (select count(*) from aluno_medicamento where aluno_medicamento.aluno_id  = aluno.id group by aluno_id)  as count_medicamentos\n"
                + "from aluno\n"
                + "where turma_id IN (select turma_id from atividade where atividade.id = " + atividade_id + ");";

        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");
            String plano_saude = rs.getString("plano_saude");
            String plano_numero = rs.getString("plano_numero");
            String sexo = rs.getString("plano_numero");
            Date nascimento = rs.getDate("nascimento");

            Aluno aluno = new Aluno(id, nome, plano_saude, plano_numero, sexo, nascimento);
            if (rs.getString("count_medicamentos") == null) {
                aluno.setMedicamentos(0);
            } else {
                aluno.setMedicamentos(Integer.parseInt(rs.getString("count_medicamentos")));
            }
            alunosAtividades.add(aluno);
        }

        return alunosAtividades;
    }

}
