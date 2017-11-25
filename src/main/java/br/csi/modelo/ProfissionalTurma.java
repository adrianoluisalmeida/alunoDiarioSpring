/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.modelo;

import java.io.Serializable;

/**
 *
 * @author adriano
 */
public class ProfissionalTurma implements Serializable {

    private Turma turma;
    private Profissional profissional;

    
    public ProfissionalTurma() {
        
    }
    
    public ProfissionalTurma(Profissional profissional, Turma turma) {
        this.profissional = profissional;
        this.turma = turma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}
