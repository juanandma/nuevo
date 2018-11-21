/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juanma;

import java.util.List;

/**
 *
 * @author calvoflores
 */
public class Partida {

    private Jugador adivino;

    private String oculta;
    private String adivinar;
    private String letras_usadas;
    private int fallos;

    public Partida(String oculta, Jugador adivino) {

        this.adivino = adivino;
        this.oculta = oculta;
        oculta = oculta.trim();
        oculta = oculta.replaceAll(" ", "  ");
        oculta = oculta.toUpperCase();

        adivinar = oculta.replaceAll("[A-Z]", "_ ");
        letras_usadas = "";
        fallos = 0;
    }

    public String getOculta() {
        return oculta;
    }

    public int getFallos() {
        return fallos;
    }

    public String getAdivinar() {
        return adivinar;
    }

    private boolean buscaLetra(char letra) {
        return oculta.indexOf(letra) != -1;
    }

    public boolean termina() {
        adivino.Gano();
        return !adivinar.contains("_");
    }

    public boolean usada(char letra) {

        return letras_usadas.indexOf(letra) != -1;
    }

    public boolean adivinar(char letra) {

        boolean correcto = true;
        System.out.println(adivinar);
        letras_usadas += letra;

        if (buscaLetra(letra) == true) {

            System.out.println(letra + " esta en la palabra");
            System.out.print("\n");

            for (int position = 0; position < oculta.length(); position++) {
                if (oculta.charAt(position) == letra && adivinar.charAt(position) != letra) {
                    // inner if begins
                    adivinar = adivinar.replaceAll("_ ", "_");

                    String phrase2;
                    phrase2 = adivinar.substring(0, position) + letra + adivinar.substring(position + 1);
                    phrase2 = phrase2.replaceAll("_", "_ ");
                    adivinar = phrase2;
                }
            }

        } else {

            correcto = false;
            System.out.print("\n");
            System.out.println(letra + " no esta en la palabra");
            System.out.print("\n");
            fallos++;
        }
        return correcto;
    }

    public void fallo() {

        if (fallos == 1) {

            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      O     |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("       	|            |");
            System.out.println("         ____________");
            System.out.print("\n");
        }
        if (fallos == 2) {

            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      O     |");
            System.out.println("        |      |     |");
            System.out.println("        |            |");
            System.out.println("       	|            |");
            System.out.println("         ____________");
            System.out.print("\n");
        }
        if (fallos == 3) {

            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      O     |");
            System.out.println("        |     -|-    |");
            System.out.println("        |            |");
            System.out.println("       	|            |");
            System.out.println("         ____________");
            System.out.print("\n");
        }
        if (fallos == 4) {

            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      O     |");
            System.out.println("        |     -|-    |");
            System.out.println("        |      |     |");
            System.out.println("       	|            |");
            System.out.println("         ____________");
            System.out.print("\n");
        }
        if (fallos == 5) {

            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      O     |");
            System.out.println("        |     -|-    |");
            System.out.println("        |      |     |");
            System.out.println("       	|     / \\    |");
            System.out.println("         ____________");
            System.out.println("La palabra era: " + oculta);
            System.out.print("\n");
        }
    }
}
