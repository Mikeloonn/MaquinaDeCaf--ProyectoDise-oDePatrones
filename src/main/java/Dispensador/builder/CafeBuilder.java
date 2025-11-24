/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.builder;

import Dispensador.modelo.Cafe;

/**
 *
 * @author mmg_2
 */
public interface CafeBuilder {
    void reset();
    void buildTipo(String tipo);
    void buildLeche(boolean leche);
    void buildAzucar(int azucar);
    Cafe getResultado();
}