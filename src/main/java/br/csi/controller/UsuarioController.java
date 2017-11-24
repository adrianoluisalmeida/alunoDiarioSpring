/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

//import br.csi.dao.UsuarioDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author aluno
 */

@Controller
public class UsuarioController {
    
    @RequestMapping("usuarioLogar")
    public String autenticar(Usuario usuario){
        
                
        UsuarioDAO dao = new UsuarioDAO();
        
        try{
            if(dao.autenticado(usuario)){
                
                return "dashboard";
            }else{
                
                return "index";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }      
        
        return "index";
    }
    
}
