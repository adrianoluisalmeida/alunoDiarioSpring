/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

//import br.csi.dao.UsuarioDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.modelo.Usuario;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;
//import javax.servlet.http.HttpSession;
//import javax.enterprise.inject.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

//                session.setAttribute("page", "dashboard");
                session.setAttribute("usuarioLogado", usuario);
//                model.addAttribute("usuarioLogado", usuario);
                
                return "redirect:dashboard";
            } else {

                return "index";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

}
