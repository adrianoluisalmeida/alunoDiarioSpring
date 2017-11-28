/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.util.Registro;
import java.util.ArrayList;

/**
 *
 * @author adriano
 * @param <T>
 */
interface DAO <T extends Registro>{
    abstract boolean atualizar(T t)  throws Exception;
    abstract T get(Integer id)  throws Exception;
    abstract boolean deletar(T t)  throws Exception;
    abstract public Integer inserir(T t) throws Exception;
    abstract ArrayList<T> listar()  throws Exception;
}
