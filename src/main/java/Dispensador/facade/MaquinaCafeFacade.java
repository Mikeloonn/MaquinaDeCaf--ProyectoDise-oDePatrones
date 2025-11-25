/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.facade;

import Dispensador.modelo.Cafe;
import Dispensador.state.ContextoMaquina;
import Dispensador.state.EstadoSinMoneda;
import Dispensador.componentes.Molinillo;
import Dispensador.componentes.BombaAgua;
import Dispensador.builder.MiCafeBuilder;
import Dispensador.builder.CafeBuilder;

/**
 *
 * @author mmg_2
 */
public class MaquinaCafeFacade {
    private ContextoMaquina controladorEstado;
    private CafeBuilder builder;
    private Molinillo molinillo;
    private BombaAgua bomba;

    public MaquinaCafeFacade() {
        this.controladorEstado = new ContextoMaquina();
        this.builder = new MiCafeBuilder();
        this.molinillo = new Molinillo();
        this.bomba = new BombaAgua();
    }

    public void botonEncender() {
        controladorEstado.botonEncender();
    }

    public void botonApagar() {
        controladorEstado.botonApagar();
    }

    public Cafe pedirCafe(String tipo, boolean leche, int azucar) {
        // 1. Validar si la máquina está en estado correcto (SinMoneda = Lista)
        if (!(controladorEstado.getEstadoActual() instanceof EstadoSinMoneda)) {
             System.out.println(" La maquina no esta lista (Esta apagada, ocupada o ya tiene moneda).");
             return null;
        }

        System.out.println("\n---  Iniciando proceso de Cafe: " + tipo + " ---");
        
        // 2. Simular flujo del usuario usando el Patrón State
        controladorEstado.insertarMoneda();      // Pasa a ConMoneda
        controladorEstado.presionarBotonCafe();  // Pasa a Preparando
        
        // 3. Orquestar subsistemas (Patrón Facade puro)
        molinillo.molerGranos();
        bomba.calentarAgua();
        
        // 4. Construir el producto (Patrón Builder)
        builder.buildTipo(tipo);
        builder.buildLeche(leche);
        builder.buildAzucar(azucar);
        bomba.bombear();
        
        Cafe miCafe = builder.getResultado();

        // 5. Finalizar ciclo
        controladorEstado.dispensar(); // Esto devuelve la máquina al estado SinMoneda
        
        return miCafe;
    }
}