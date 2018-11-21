/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juanma;

/**
 *
 * @author calvoflores
 */
public class Jugador {
    
    private String nombre;
    private int ganadas;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        ganadas=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void Gano() {
        ganadas++;
    }


    public void Ganador(){
        if(ganadas==3){
            System.out.println(nombre+" es el ganador");
        }
    }

    
    
    
    
}
