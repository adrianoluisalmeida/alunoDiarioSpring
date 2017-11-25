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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author adriano
 */
@Controller
public class TurmasController {

    @Autowired
    private TurmaDAO dao;

    @RequestMapping("/turmas")
    public String index(Model model) {
        try {
            model.addAttribute("turmas", dao.listar());
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "turmas/index");

        return "app";
    }

    @RequestMapping(value = "/turmas/criar", method = GET)
    public String create(Model model) {
        model.addAttribute("page", "turmas/create");

        return "app";
    }

    @RequestMapping(value = "/turmas/store", method = POST)
    public String store(@Valid Turma turma, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("page", "turmas/create");
            
            return "app";
        }
        
        try {
            dao.inserir(turma);
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/turmas";
    }

    @RequestMapping(value = "/turmas/editar/{id}", method = GET)
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("turma", dao.get(id));
            model.addAttribute("id", id);
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "turmas/edit");
        return "app";
    }

    @RequestMapping(value = "/turmas/update/{id}", method = POST)
    public String update(@PathVariable("id") int id, Turma turma) {

        turma.setId(id);

        try {
            dao.atualizar(turma);
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/turmas";
    }

    @RequestMapping(value = "/turmas/remove/{id}", method = GET)
    public String remove(@PathVariable("id") int id, Turma turma) {

        turma.setId(id);

        try {
            dao.deletar(turma);
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/turmas";

    }

}
