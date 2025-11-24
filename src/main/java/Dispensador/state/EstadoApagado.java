/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.state;

/**
 *
 * @author mmg_2
 */
public class EstadoApagado implements EstadoMaquina {

    ContextoMaquina contexto;

    public EstadoApagado(ContextoMaquina contexto) {
        this.contexto = contexto;
    }

    @Override
    public void encender() {
        System.out.println("Iniciando sistema... Pantalla lista.");
        // CORRECCIÓN CLAVE: Ahora pasamos al estado SinMoneda
        contexto.setEstado(contexto.getEstadoSinMoneda());
    }

    @Override
    public void apagar() {
        System.out.println("La máquina ya está apagada.");
    }

    // --- MÉTODOS OBLIGATORIOS (porque están en la Interfaz) ---
    // Como la máquina está apagada, en todos respondemos con error.

    @Override
    public void insertarMoneda() {
        System.out.println("ERROR: La máquina está apagada. No entra la moneda.");
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("ERROR: La máquina está apagada.");
    }

    @Override
    public void presionarBotonCafe() {
        System.out.println("ERROR: La máquina está apagada. Enciéndela primero.");
    }

    @Override
    public void dispensar() {
        // No hace nada
    }
}