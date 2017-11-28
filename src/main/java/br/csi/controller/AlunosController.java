package br.csi.controller;

import br.csi.dao.AlunoDAO;
import br.csi.dao.AlunoMedicamentoDAO;
import br.csi.dao.TurmaDAO;
import br.csi.modelo.Aluno;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author adriano
 */
@Controller
public class AlunosController {

    @Autowired
    private AlunoDAO dao;

    @RequestMapping("/alunos")
    public String index(@ModelAttribute("msg") String msg, Model model) {
        try {
            model.addAttribute("alunos", dao.listar());
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "alunos/index");

        return "app";
    }

    @Autowired
    private TurmaDAO daoTurma;

    @RequestMapping(value = "/alunos/criar", method = GET)
    public String create(@ModelAttribute("aluno") Aluno aluno, Model model) {
        try {
            model.addAttribute("turmas", daoTurma.listar());
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "alunos/create");

        return "app";
    }

    @Autowired
    private AlunoMedicamentoDAO mdao;

    @RequestMapping(value = "/alunos/store", method = POST)
    public String store(@Valid Aluno aluno, BindingResult result, Model model, HttpServletRequest request, @RequestParam("turma_id") int turma_id, @RequestParam("nascimento") String nascimento, final RedirectAttributes redirectAttributes) {

        aluno.setTurma(new Turma(turma_id));
        aluno.setNascimento(DateUtils.toDate(nascimento, "dd/MM/yyyy"));

        if (result.hasErrors()) {
            try {
                model.addAttribute("turmas", daoTurma.listar());
                model.addAttribute("page", "alunos/create");
                return "app";
            } catch (Exception ex) {
                Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            Integer aluno_id = dao.inserir(aluno);
            redirectAttributes.addFlashAttribute("msg", "Aluno cadastrado com sucesso !");
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/alunos";
    }

    @RequestMapping(value = "/alunos/editar/{id}", method = GET)
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("turmas", daoTurma.listar());
            model.addAttribute("aluno", dao.get(id));
            model.addAttribute("id", id);
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "alunos/edit");
        return "app";
    }

    @RequestMapping(value = "/alunos/update/{id}", method = POST)
    public String update(@Valid Aluno aluno, BindingResult result, Model model, @PathVariable("id") int id, @RequestParam("turma_id") int turma_id, @RequestParam("nascimento") String nascimento, final RedirectAttributes redirectAttributes) throws Exception {

        aluno.setId(id);
        aluno.setTurma(new Turma(turma_id));
        aluno.setNascimento(DateUtils.toDate(nascimento, "dd/MM/yyyy"));

        if (result.hasErrors()) {
            return "redirect:/alunos/editar/" + id;
        }

        try {
            dao.atualizar(aluno);
            redirectAttributes.addFlashAttribute("msg", "Aluno atualizado com sucesso !");
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/alunos";
    }

    @RequestMapping(value = "/alunos/remove/{id}", method = GET)
    public String remove(@PathVariable("id") int id, Aluno aluno, final RedirectAttributes redirectAttributes) {
        aluno.setId(id);
        try {
            dao.deletar(aluno);
            redirectAttributes.addFlashAttribute("msg", "Aluno removido com sucesso !");
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/alunos";

    }

}
