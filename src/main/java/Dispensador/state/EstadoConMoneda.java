/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.state;

/**
 *
 * @author mmg_2
 */
public class EstadoConMoneda implements EstadoMaquina {
    ContextoMaquina maquina;

    public EstadoConMoneda(ContextoMaquina maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("Ya hay una moneda dentro. No puedes insertar otra.");
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("Moneda devuelta.");
        // TRANSICIÓN: Volvemos al estado SinMoneda
        maquina.setEstado(maquina.getEstadoSinMoneda());
    }

    @Override
    public void presionarBotonCafe() {
        System.out.println("Procesando tu pedido...");
        // TRANSICIÓN: Avanzamos a Preparando (o Vendido)
        maquina.setEstado(maquina.getEstadoPreparando()); 
    }

    @Override
    public void dispensar() {
        System.out.println("Presiona el boton para obtener tu cafe.");
    }
    
    @Override
    public void encender() {
        System.out.println("La maquina ya está encendida.");
    }

    @Override
    public void apagar() {
        System.out.println(" Error: Tienes una moneda dentro. Expulsala antes de apagar.");
        // Lógica alternativa si prefieres que devuelva la moneda y se apague:
        // System.out.println("Devolviendo moneda y apagando...");
        // maquina.setEstado(maquina.getEstadoApagado());
    }
}