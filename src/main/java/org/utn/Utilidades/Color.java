package org.utn.Utilidades;

/**
 * Esta clase se encarga de darle color a los textos que se muestran por pantalla
 * @autor Eliana Rojas
 */
public class Color {

    /**
     * Atributos estaticos que contienen un Color de texto
     * Ejmeplo de uso
     * System.out.println( Color.amarillo + "Hola mundo!");
     */

    public static final String negro = "\033[30m";
    public static final String rojo = "\033[31m";
    public static final String verde = "\033[32m";
    public static final String amarillo = "\033[33m";
    public static final String azul = "\033[34m";
    public static final  String magenta = "\033[35m";
    public static final String celeste = "\033[36m";
    public static final  String blanco = "\033[37m";

    /**
     * Atributo estatico que borra un color para que lo que siga a continuacion no se pinte del color anterior
     * Borra un color
     */
    public static final String  b = "\u001B[0m";

    /**
     * Pinta el fondo String del color indicado - Resaltado
     * Fondos
     */
    public static final String fRojo = "\033[41m";
    public static final String fVerde = "\033[42m";
    public static final String fAmarillo = "\033[43m";
    public static final  String fAzul = "\033[44m";
    public static final  String fMagenta = "\033[45m";
    public static final  String fCeleste = "\033[46m";
    public static final  String fGris = "\033[47m";


}