/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.state;

/**
 *
 * @author mmg_2
 */
public interface EstadoMaquina {
    void insertarMoneda();
    void expulsarMoneda();
    void presionarBotonCafe();
    void dispensar();
    void encender(); // Necesario para salir de Apagado
    void apagar();   // Necesario para volver a Apagado
}