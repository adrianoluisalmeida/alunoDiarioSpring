/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

//import br.csi.modelo.Aluno;
import br.csi.modelo.Totais;
//import br.csi.modelo.Turma;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Component;

/**
 *
 * @author adriano
 */
@Component
public class TotaisDAO {

    public Integer getMedicamentos(Integer id) throws Exception {
        Integer total = 0;

        String sql = "select count(*) as total\n"
                + "from aluno, (select turma_id\n"
                + "from atividade where id = " + id + ") as turma\n"
                + "where turma.turma_id = aluno.turma_id and id in (select aluno_id from aluno_medicamento group by aluno_id\n"
                + ")";

        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            total = rs.getInt("total");
        }

        return total;
    }

    public Integer getOk(Integer id) throws Exception {
        Integer total = 0;
        String sql = "select count(*) as total\n"
                + "from aluno, (select turma_id\n"
                + "from atividade where id = " + id + ") as turma\n"
                + "where turma.turma_id = aluno.turma_id and id not in (select aluno_id from aluno_medicamento group by aluno_id\n"
                + ")";

        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            total = rs.getInt("total");
        }

        return total;
    }

    public Totais get(Integer id) throws Exception {
        String sql = "select * from aluno where id =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Totais t = new Totais();

        while (rs.next()) {
            t.setMedicamentos(this.getMedicamentos(id));
            t.setOk(this.getOk(id));
        }
        return t;
    }
}
