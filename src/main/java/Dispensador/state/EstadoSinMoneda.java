/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.state;

/**
 *
 * @author mmg_2
 */
public class EstadoSinMoneda implements EstadoMaquina {
    ContextoMaquina maquina;

    public EstadoSinMoneda(ContextoMaquina maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("Moneda insertada.");
        // TRANSICIÓN: Cambiamos al estado ConMoneda
        maquina.setEstado(maquina.getEstadoConMoneda());
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("No has insertado moneda, no se puede expulsar nada.");
    }

    @Override
    public void presionarBotonCafe() {
        System.out.println("Primero inserta una moneda para pedir café.");
    }

    @Override
    public void dispensar() {
        System.out.println("Debes pagar primero.");
    }
    @Override
    public void encender() {
        System.out.println("La máquina ya está encendida.");
    }

    @Override
    public void apagar() {
        System.out.println("Apagando máquina...");
        maquina.setEstado(maquina.getEstadoApagado());
    }
    
}