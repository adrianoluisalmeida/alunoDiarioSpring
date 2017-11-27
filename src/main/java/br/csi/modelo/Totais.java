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
public class Totais implements Serializable {

    private Integer ok;
    private Integer medicamentos;

    public Totais() {
    }

    public Totais(Integer ok, Integer medicamentos) {
        this.ok = ok;
        this.medicamentos = medicamentos;
    }

    public Integer getOk() {
        return ok;
    }

    public void setOk(Integer ok) {
        this.ok = ok;
    }

    public Integer getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Integer medicamentos) {
        this.medicamentos = medicamentos;
    }

}
