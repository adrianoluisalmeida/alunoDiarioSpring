/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

//import br.csi.dao.UsuarioDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
//import javax.websocket.Session;
//import javax.servlet.http.HttpSession;
//import javax.enterprise.inject.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author aluno
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDAO dao;

    @RequestMapping("usuarioLogar")
    public String autenticar(Usuario usuario, Model model, HttpSession session) {

        try {
            if (dao.autenticado(usuario)) {

                session.setAttribute("usuarioLogado", usuario);

                return "redirect:dashboard";
            } else {
                model.addAttribute("msg", "Verifique os dados informados.");
                return "index";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("msg", "Verifique os dados informados.");

        return "index";
    }

    @RequestMapping(value = "usuarioCadastrar", method = POST)
    public String usuarioCadastrar(@Valid Usuario usuario, BindingResult result, Model model, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "cadastrar";
        }

        try {
            dao.inserir(usuario);
            return "redirect:/login";
        } catch (Exception ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "cadastrar";
    }

}
