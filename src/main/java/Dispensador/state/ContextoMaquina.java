/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispensador.state;

/**
 *
 * @author mmg_2
 */
public class ContextoMaquina {

    // 1. Declaramos variables para CADA estado posible
    //    (Se crean una sola vez y se reutilizan)
    private EstadoMaquina estadoApagado;
    private EstadoMaquina estadoSinMoneda; // Equivale a "Encendido esperando cliente"
    private EstadoMaquina estadoConMoneda; // Cliente insertó dinero
    private EstadoMaquina estadoPreparando;

    // 2. Variable para saber en qué estado estamos AHORA
    private EstadoMaquina estadoActual;

    // 3. Constructor
    public ContextoMaquina() {
        // Instanciamos los estados pasándoles 'this' (esta máquina) para que puedan hacer transiciones
        estadoApagado = new EstadoApagado(this);
        estadoSinMoneda = new EstadoSinMoneda(this);
        estadoConMoneda = new EstadoConMoneda(this);
        estadoPreparando = new EstadoPreparando(this);

        // Estado inicial: La máquina empieza Apagada
        // (Si prefieres que empiece encendida, usa estadoSinMoneda)
        this.estadoActual = estadoApagado;
    }

    // -----------------------------------------------------------
    // 4. Métodos de Acción (El cliente llama a estos)
    //    La máquina simplemente delega la acción al 'estadoActual'
    // -----------------------------------------------------------

    public void insertarMoneda() {
        estadoActual.insertarMoneda();
    }

    public void expulsarMoneda() {
        estadoActual.expulsarMoneda();
    }

    public void presionarBotonCafe() {
        estadoActual.presionarBotonCafe();
        // Nota: Es posible que el estado 'Preparando' llame internamente a 'dispensar'
        // después de la lógica de preparación.
    }

    public void dispensar() {
        estadoActual.dispensar();
    }

    // Métodos de control de energía (delegan al estado para validar si se puede apagar/encender)
    // Por ejemplo: No deberías poder apagar si está 'Preparando' un café.
    public void botonEncender() {
        // Si tu interfaz EstadoMaquina no tiene metodo 'encender', 
        // puedes manejarlo aquí con un if(estadoActual == estadoApagado)...
        // Pero lo ideal es delegar:
        estadoActual.encender(); 
    }

    public void botonApagar() {
        estadoActual.apagar();
    }

    // -----------------------------------------------------------
    // 5. Métodos de Gestión de Estado (Usados por las clases Estado)
    // -----------------------------------------------------------

    // Permite cambiar el estado actual
    public void setEstado(EstadoMaquina nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }
    
    // Getters para acceder a las instancias de los estados
    public EstadoMaquina getEstadoActual() { // <--- AGREGA ESTO
        return estadoActual;
    }
    
    public EstadoMaquina getEstadoApagado() {
        return estadoApagado;
    }

    public EstadoMaquina getEstadoSinMoneda() {
        return estadoSinMoneda;
    }

    public EstadoMaquina getEstadoConMoneda() {
        return estadoConMoneda;
    }

    public EstadoMaquina getEstadoPreparando() {
        return estadoPreparando;
    }

    // Opcional: Para ver en consola en qué estado estamos
    public String getNombreEstadoActual() {
        return estadoActual.getClass().getSimpleName();
    }
}