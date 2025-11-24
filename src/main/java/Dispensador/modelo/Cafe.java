/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.modelo;

/**
 *
 * @author mmg_2
 */
public class Cafe {

    private String tipo;
    private boolean conLeche;
    private int cucharadasAzucar;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setConLeche(boolean conLeche) {
        this.conLeche = conLeche;
    }

    public void setCucharadasAzucar(int cucharadasAzucar) {
        this.cucharadasAzucar = cucharadasAzucar;
    }

    @Override
    public String toString() {
        return "Café " + tipo + (conLeche ? " con leche" : " solo") + ", Azúcar: " + cucharadasAzucar;
    }
}
