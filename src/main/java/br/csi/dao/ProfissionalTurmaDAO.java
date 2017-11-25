package br.csi.dao;

import br.csi.modelo.Profissional;
import br.csi.modelo.ProfissionalTurma;
import br.csi.modelo.Turma;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class ProfissionalTurmaDAO {

//    public boolean atualizar(ProfissionalTurma p)throws Exception{
//        String sql = "update profissional_turma set turma_id=?, profissional_id=?"
//                + "where turma_id = ? and profissional_id = ?";
//        PreparedStatement stmt = 
//                ConectaPostgres.getConexao()
//                        .prepareStatement(sql);
//        
//    stmt.setString(1, p.getTurma());
//    stmt.setString(2, p.getSexo());
//    stmt.setString(3, p.getEmail());
//    stmt.setString(4, p.getFuncao());
//    stmt.setInt(5, p.getId());
//        
//    stmt.executeUpdate();
//        return true;
//    }
    
//    public ProfissionalTurma get(Integer profissional_id) throws Exception{
//        String sql = "select * from profissional_turma where profissional_id =?";
//        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
//        stmt.setInt(1, profissional_id);
//        ResultSet rs = stmt.executeQuery();
//        ProfissionalTurma a = new ProfissionalTurma();
//        while(rs.next()){
//            a.setProfissional(new Profissional(rs.getInt("profissional_id")));
//            a.setTurma(new Turma(rs.getInt("turma_id")));
//        }
//        return a;
//    }
    
    public boolean deletar(ProfissionalTurma profissional) throws Exception{
        
        String sql = "DELETE from profissional_turma where profissional_id =?";
        
        PreparedStatement stmt = 
                    ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, profissional.getProfissional().getId());
//        stmt.setInt(2, profissional.getTurma().getId());
        stmt.executeUpdate();
        return true;
    }
 
    public boolean inserir(ProfissionalTurma profissional) throws Exception {
        String sql = "insert into profissional_turma(profissional_id, turma_id) "
                + "values(?, ?)";

        PreparedStatement stmt
                = ConectaPostgres.getConexao().prepareStatement(sql);
        
        stmt.setInt(1, profissional.getProfissional().getId());
        stmt.setInt(2, profissional.getTurma().getId());

        stmt.execute();
        return true;
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

}
