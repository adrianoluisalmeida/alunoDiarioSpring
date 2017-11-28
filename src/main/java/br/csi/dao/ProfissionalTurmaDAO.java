package br.csi.dao;

import br.csi.modelo.Profissional;
import br.csi.modelo.ProfissionalTurma;
import br.csi.modelo.Turma;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class ProfissionalTurmaDAO implements DAO<ProfissionalTurma> {

    @Override
    public boolean deletar(ProfissionalTurma profissional) throws Exception {

        String sql = "DELETE from profissional_turma where profissional_id =?";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, profissional.getProfissional().getId());
        stmt.executeUpdate();
        return true;
    }

    @Override
    public Integer inserir(ProfissionalTurma profissional) throws Exception {
        String sql = "insert into profissional_turma(profissional_id, turma_id) "
                + "values(?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);

        stmt.setInt(1, profissional.getProfissional().getId());
        stmt.setInt(2, profissional.getTurma().getId());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public ArrayList<ProfissionalTurma> listar(Integer profissional_id) throws Exception {
        ArrayList<ProfissionalTurma> profissionais = new ArrayList<>();

        String sql = "select * from profissional_turma where profissional_id = ?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, profissional_id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Integer prof_id = rs.getInt("profissional_id");
            Integer turma_id = rs.getInt("turma_id");

            TurmaDAO tdao = new TurmaDAO();
            Turma turma = new Turma();

            ProfissionalTurma profissional = new ProfissionalTurma(new Profissional(prof_id), tdao.get(turma_id));
            profissionais.add(profissional);
        }

        System.out.println("Metodo executado com sucesso...");

        return profissionais;
    }

    @Override
    public boolean atualizar(ProfissionalTurma t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfissionalTurma get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProfissionalTurma> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
