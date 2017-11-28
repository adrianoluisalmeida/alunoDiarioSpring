package br.csi.dao;

import br.csi.modelo.Turma;
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
public class TurmaDAO {

    
    
    public boolean atualizar(Turma t)throws Exception{
        String sql = "update turma set nome=? "
                + "where id = ?";
        PreparedStatement stmt = 
                ConectaPostgres.getConexao()
                        .prepareStatement(sql);
        
    stmt.setString(1, t.getNome());
    stmt.setInt(2, t.getId());
        
    stmt.executeUpdate();
        return true;
    }
    
    
    public Turma get(Integer id) throws Exception{
        String sql = "select * from turma where id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Turma t = new Turma();
        while(rs.next()){
            t.setNome(rs.getString("nome"));
        }
        return t;
    }
    
    public boolean deletar(Turma turma) throws Exception{
        
        String sql = "DELETE from turma where id =?";
        
        PreparedStatement stmt = 
                    ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, turma.getId());
        stmt.executeUpdate();
        return true;
    }
    
    public boolean inserir(Turma usuario) throws Exception{
        String sql = "insert into turma(nome) "
                + "values(?)";
        
        PreparedStatement stmt = 
                ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.execute();
        
        return true;
    }
    
    
     public ArrayList<Turma> listar() throws Exception{
        ArrayList<Turma> turmas = new ArrayList<>(); 
            
             // carregar o driver           
            // criar a declaracao (statement) sql
            String sql = "select * from turma  order by id desc";
            PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
            // executar instrucao sql
            ResultSet rs = stmt.executeQuery();
            // manipular o resultado da instrucao sql
            while(rs.next()){
              
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.println("id: "+id+" login: "+nome);
            
                Turma turma = new Turma(id, nome);
                turmas.add(turma);
            }
            
             System.out.println("Metodo executado com sucesso...");
       
       
        return turmas;
    }
    
    
}
