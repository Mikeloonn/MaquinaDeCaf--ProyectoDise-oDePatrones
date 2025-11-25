/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.builder;

import Dispensador.modelo.Cafe;
import Dispensador.builder.CafeBuilder;

/**
 *
 * @author mmg_2
 */
public class MiCafeBuilder implements CafeBuilder {

    private Cafe cafe;

    public MiCafeBuilder() {
        this.reset();
    }

    public void reset() {
        this.cafe = new Cafe();
    }

    public void buildTipo(String tipo) {
        cafe.setTipo(tipo);
    }

    public void buildLeche(boolean leche) {
        cafe.setConLeche(leche);
    }

    public void buildAzucar(int azucar) {
        cafe.setCucharadasAzucar(azucar);
    }

    public Cafe getResultado() {
        Cafe producto = this.cafe;
        this.reset();
        return producto;
    }
}
