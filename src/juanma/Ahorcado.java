/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juanma;

import java.util.Scanner;

/**
 *
 * @author calvoflores
 */
public class Ahorcado {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        Jugador p1 = new Jugador("Player 1");
        Jugador p2 = new Jugador("Player 2");

        int cont = 1;
        String palabra, letra;

        while (p1.getGanadas() < 3 && p2.getGanadas() < 3) {

            Jugador adivino;
            if (cont % 2 != 0) {
                System.out.println(p1.getNombre() + " introduzca palabra");
                adivino=p2;
                
            } else {
                System.out.println(p2.getNombre() + " introduzca palabra");
                adivino=p1;
            }

            palabra = input.next();

            Partida nueva = new Partida(palabra,adivino);

            boolean fin = false;

            while (nueva.getFallos() < 6 && !fin) {

                do {
                    

                    System.out.println(nueva.getAdivinar());

                    System.out.println(nueva.getAdivinar()+"\n");

                    System.out.println("Introduzca una letra no usada: ");
                    letra = input.next();
                } while (nueva.usada(letra.charAt(0)));

                if (!nueva.adivinar(letra.charAt(0))) {

                    nueva.fallo();
                } else if (nueva.termina()) {

                    fin = true;
                }
            }

            if (fin) {
                System.out.println("Enhorabuena, la palabra es: " + nueva.getOculta());
            }
            cont++;
            

        }
        
        p1.Ganador();
        p2.Ganador();
        

    }

}
