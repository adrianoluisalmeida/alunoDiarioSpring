/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.AlunoMedicamentoDAO;
import br.csi.modelo.Aluno;
import br.csi.modelo.AlunoMedicamento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author adriano
 */
@Controller
public class MedicamentosController {

    @Autowired
    private AlunoMedicamentoDAO mdao;

    @RequestMapping(value = "medicamentos/{id}", method = RequestMethod.GET)
//    @ResponseBody
    public String index(@PathVariable("id") int id, Model model) {

        try {
            model.addAttribute("medicamentos", mdao.listar(id));
        } catch (Exception ex) {
            Logger.getLogger(MedicamentosController.class.getName()).log(Level.SEVERE, null, ex);

        }

        return "paginas/medicamentos/table";

    }

    @RequestMapping(value = "medicamentosStore", method = RequestMethod.POST)
    @ResponseBody
    public boolean store(@Valid AlunoMedicamento aluno, BindingResult result, Model model, HttpServletRequest request, @RequestParam("aluno_id") int aluno_id) {

        aluno.setAluno(new Aluno(aluno_id));
        if (result.hasErrors()) {
            return false;
        }

        try {
            mdao.inserir(aluno);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MedicamentosController.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }

    @RequestMapping(value = "medicamento/remove/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean destroy(@Valid AlunoMedicamento aluno, BindingResult result, Model model, HttpServletRequest request, @PathVariable("id") int id) {

        aluno.setId(id);
        try {
            mdao.deletar(aluno);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MedicamentosController.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }

}
