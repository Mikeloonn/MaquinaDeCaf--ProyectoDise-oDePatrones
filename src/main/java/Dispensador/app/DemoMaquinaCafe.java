/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.app;

import Dispensador.modelo.Cafe;
import Dispensador.facade.MaquinaCafeFacade;

/**
 *
 * @author mmg_2
 */
public class DemoMaquinaCafe {
    public static void main(String[] args) {
        // El cliente solo conoce la Facade
        MaquinaCafeFacade miMaquina = new MaquinaCafeFacade();

        // Intento hacer café con la máquina apagada (Patrón State actuando)
        miMaquina.pedirCafe("Espresso", false, 0);

        // Encender (Facade delega a State)
        miMaquina.botonEncender();

        // Pedir un café complejo (Facade coordina a Builder y Subsistemas)
        Cafe cafe1 = miMaquina.pedirCafe("Cappuccino", true, 2);
        System.out.println("Entregado: " + cafe1);

        // Pedir otro café
        Cafe cafe2 = miMaquina.pedirCafe("Americano", false, 0);
        System.out.println("Entregado: " + cafe2);

        // Apagar
        miMaquina.botonApagar();
    }
}
