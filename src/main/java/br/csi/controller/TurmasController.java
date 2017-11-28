package br.csi.controller;

import br.csi.dao.TurmaDAO;
import br.csi.modelo.Turma;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author adriano
 */
@Controller
public class TurmasController {

    @Autowired
    private TurmaDAO dao;

    @RequestMapping("/turmas")
    public String index(@ModelAttribute("msg") String msg, Model model) {
        try {
            model.addAttribute("turmas", dao.listar());
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "turmas/index");

        return "app";
    }

    @RequestMapping(value = "/turmas/criar", method = GET)
    public String create(@ModelAttribute("turma") Turma turma, Model model) {
        model.addAttribute("page", "turmas/create");
        return "app";
    }

    @RequestMapping(value = "/turmas/store", method = POST)
    public String store(@Valid Turma turma, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("page", "turmas/create");
            return "app";
        }

        try {
            dao.inserir(turma);
            redirectAttributes.addFlashAttribute("msg", "Turma cadastrada com sucesso !");
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/turmas";
    }

    @RequestMapping(value = "/turmas/editar/{id}", method = GET)
    public String edit(@ModelAttribute("turma") Turma turma, @PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("turma", dao.get(id));
            model.addAttribute("id", id);
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "turmas/edit");
        return "app";
    }

    @RequestMapping(value = "/turmas/update/{id}")
    public String update(@Valid Turma turma, @PathVariable("id") int id,
            final RedirectAttributes redirectAttributes, BindingResult result, Model model) {

        model.addAttribute("id", id);

        if (result.hasErrors()) {
            return "redirect:/turmas/editar/" + id;
        }
        turma.setId(id);
        try {
            dao.atualizar(turma);
            redirectAttributes.addFlashAttribute("msg", "Turma atualizada com sucesso !");
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/turmas";
    }

    @RequestMapping(value = "/turmas/remove/{id}", method = GET)
    public String remove(@PathVariable("id") int id, Turma turma, final RedirectAttributes redirectAttributes) {

        turma.setId(id);

        try {
            dao.deletar(turma);
            redirectAttributes.addFlashAttribute("msg", "Turma removida com sucesso !");
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/turmas";

    }

}
