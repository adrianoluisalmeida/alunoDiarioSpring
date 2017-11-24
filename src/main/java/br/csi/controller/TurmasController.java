/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

//import br.csi.dao.TurmaDAO;
import br.csi.dao.TurmaDAO;
import br.csi.modelo.Turma;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    
//    @Autowired
//    private TurmaDAO dao;
    
    @RequestMapping(value = "/turmas/editar/{id}", method = GET)
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("turma", dao.get(id));
        } catch (Exception ex) {
            Logger.getLogger(TurmasController.class.getName()).log(Level.SEVERE, null, ex);
        }
         model.addAttribute("page", "turmas/edit");
        return "app";
    }

}
