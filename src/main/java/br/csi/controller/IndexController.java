/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author aluno
 */

@Controller
public class IndexController {
    
    //@RequestMapping(value = {"", "/"} )
    public String index(){        
        return "redirect:inicial";
    }
    
    @RequestMapping("home")
    public String home(){        
        return "index";
    }    
    
    @RequestMapping(value = {"", "/"} )
    public RedirectView home2(){        
        
        return new RedirectView("home", true);
    }
    
}
