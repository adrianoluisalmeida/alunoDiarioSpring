/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author aluno
 */
@Controller
public class IndexController {

    public String index() {
        return "redirect:login";
    }

    @RequestMapping("login")
    public String home() {
        return "index";
    }

    @RequestMapping(value = {"", "/"})
    public String homeSite() {
        return "site";
    }

    @RequestMapping(value = {"/about"})
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

}
