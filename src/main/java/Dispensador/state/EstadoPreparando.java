/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.state;

/**
 *
 * @author mmg_2
 */
public class EstadoPreparando implements EstadoMaquina {

    ContextoMaquina contexto;

    public EstadoPreparando(ContextoMaquina contexto) {
        this.contexto = contexto;
    }

    @Override
    public void encender() {
        System.out.println("Máquina ocupada.");
    }

    @Override
    public void apagar() {
        System.out.println("Termine de preparar el café antes de apagar.");
    }

    public void prepararCafe() {
        System.out.println("Ya se está preparando un café. Espere.");
    }

    // Método auxiliar para simular que termina
    public void finalizarProceso() {
        System.out.println("✅ Café servido. Volviendo a estado listo.");
        contexto.setEstado(contexto.getEstadoSinMoneda());
    }

    @Override
    public void insertarMoneda() {
        System.out.println("Espere un momento, preparando café.");
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("Tarde, ya estamos procesando el café.");
    }

    @Override
    public void presionarBotonCafe() {
        System.out.println("Ya se está preparando uno.");
    }

    @Override
    public void dispensar() {
        // Lógica movida desde "prepararCafe"
        System.out.println("✅ Café servido. Volviendo a estado listo.");
        contexto.setEstado(contexto.getEstadoSinMoneda()); // Corregido a getEstadoSinMoneda
    }
}
