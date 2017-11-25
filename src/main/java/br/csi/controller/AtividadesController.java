package br.csi.controller;

import br.csi.dao.AtividadeDAO;
import br.csi.dao.TurmaDAO;
import br.csi.modelo.Atividade;
import br.csi.modelo.Turma;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import br.csi.util.DateUtils;

/**
 *
 * @author adriano
 */
@Controller
public class AtividadesController {

    @Autowired
    private AtividadeDAO dao;

    @RequestMapping("/atividades")
    public String index(Model model) {
        try {
            model.addAttribute("atividades", dao.listar());
        } catch (Exception ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "atividades/index");

        return "app";
    }

    @Autowired
    private TurmaDAO daoTurma;

    @RequestMapping(value = "/atividades/criar", method = GET)
    public String create(Model model) {
        try {
            model.addAttribute("turmas", daoTurma.listar());
        } catch (Exception ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "atividades/create");

        return "app";
    }

//    @Autowired
//    private AlunoMedicamentoDAO mdao;
    @RequestMapping(value = "/atividades/store", method = POST)
    public String store(Atividade atividade, BindingResult result, Model model, HttpServletRequest request, @RequestParam("turma_id") int turma_id, @RequestParam("data") String data) {

        atividade.setTurma(new Turma(turma_id));
        atividade.setData(DateUtils.toDate(data, "dd/MM/yyyy"));

//        if (result.hasErrors()) {
//            model.addAttribute("page", "atividades/create");
//            return "app";
//        }
        try {
            Integer atividade_id = dao.inserir(atividade);
        } catch (Exception ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/atividades";
    }

    @RequestMapping(value = "/atividades/editar/{id}", method = GET)
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("turmas", daoTurma.listar());
            model.addAttribute("atividade", dao.get(id));
            model.addAttribute("id", id);
        } catch (Exception ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "atividades/edit");
        return "app";
    }

    @RequestMapping(value = "/atividades/update/{id}")
    public String update(@PathVariable("id") int id, Atividade atividade, BindingResult result, Model model, HttpServletRequest request, @RequestParam("turma_id") int turma_id, @RequestParam("data") String data) {

        atividade.setId(id);
        atividade.setTurma(new Turma(turma_id));
        atividade.setData(DateUtils.toDate(data, "dd/MM/yyyy"));
        
        try {
            dao.atualizar(atividade);
        } catch (Exception ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/atividades";
    }

    @RequestMapping(value = "/atividades/remove/{id}", method = GET)
    public String remove(@PathVariable("id") int id, Atividade atividade) {
        atividade.setId(id);
        try {
            dao.deletar(atividade);
        } catch (Exception ex) {
            Logger.getLogger(AtividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/atividades";

    }

}
