package br.csi.controller;

import br.csi.dao.ProfissionalDAO;
import br.csi.dao.ProfissionalTurmaDAO;
import br.csi.dao.TurmaDAO;
import br.csi.modelo.Profissional;
import br.csi.modelo.ProfissionalTurma;
import br.csi.modelo.Turma;
import java.util.ArrayList;
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

/**
 *
 * @author adriano
 */
@Controller
public class ProfissionalController {

    @Autowired
    private ProfissionalDAO dao;

    @RequestMapping("/profissionais")
    public String index(Model model) {
        try {
            model.addAttribute("profissionais", dao.listar());
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "profissionais/index");

        return "app";
    }

    @Autowired
    private TurmaDAO daoTurma;

    @RequestMapping(value = "/profissionais/criar", method = GET)
    public String create(Model model) {
        try {
            model.addAttribute("turmas", daoTurma.listar());
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "profissionais/create");

        return "app";
    }

    @Autowired
    private ProfissionalTurmaDAO daoProfTurma;

    @RequestMapping(value = "/profissionais/store", method = POST)
    public String store(@Valid Profissional profissional, BindingResult result, Model model, HttpServletRequest request, @RequestParam("turmas") ArrayList<Integer> turmas) {

//        aluno.setTurma(new Turma(turma_id));
        if (result.hasErrors()) {
            model.addAttribute("page", "profissionais/create");
            return "app";
        }

        try {
            Integer insert_id = dao.inserir(profissional);

            System.out.println("INSERT ID: " + insert_id);

            //INSERE AS TURMAS QUE O PROFISSIONAL É RESPONSAVEL
            for (Integer integer : turmas) {

                ProfissionalTurma pProfissionalTurma = new ProfissionalTurma();
                pProfissionalTurma.setProfissional(new Profissional(insert_id));
                pProfissionalTurma.setTurma(new Turma(integer));

                try {
                    daoProfTurma.inserir(pProfissionalTurma);
                } catch (Exception ex) {
                    Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/profissionais";
    }

    @RequestMapping(value = "/profissionais/editar/{id}", method = GET)
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("turmas", daoTurma.listar());
            model.addAttribute("profissional", dao.get(id));
            model.addAttribute("id", id);
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("page", "profissionais/edit");
        return "app";
    }

    @RequestMapping(value = "/profissionais/update/{id}", method = POST)
    public String update(@PathVariable("id") int id, Profissional profissional, @RequestParam("turmas") ArrayList<Integer> turmas) {

        profissional.setId(id);

        //REMOVE AS TURMAS DO PROFISSIONAL
        ProfissionalTurma profTurma = new ProfissionalTurma();
        profTurma.setProfissional(profissional);
        try {
            daoProfTurma.deletar(profTurma);
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //INSERE AS TURMAS QUE O PROFISSIONAL É RESPONSAVEL
        for (Integer integer : turmas) {

            ProfissionalTurma pProfissionalTurma = new ProfissionalTurma();
            pProfissionalTurma.setProfissional(new Profissional(id));
            pProfissionalTurma.setTurma(new Turma(integer));

            try {
                daoProfTurma.inserir(pProfissionalTurma);
            } catch (Exception ex) {
                Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            dao.atualizar(profissional);
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/profissionais";
    }

    /**
     * Deleta os registros de vinculo entre turma e profissional antes e depois
     * o profissional propriamente dito.
     *
     * @param id
     * @param profissional
     * @return
     */
    @RequestMapping(value = "/profissionais/remove/{id}", method = GET)
    public String remove(@PathVariable("id") int id, Profissional profissional) {

        profissional.setId(id);

        ProfissionalTurma profTurma = new ProfissionalTurma();
        profTurma.setProfissional(profissional);
        try {
            daoProfTurma.deletar(profTurma);
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            dao.deletar(profissional);
        } catch (Exception ex) {
            Logger.getLogger(ProfissionalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/profissionais";

    }

}
