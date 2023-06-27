package org.utn.Utilidades;

/**
 * Clase que contiene metodos de utilidad para la aplicacion
 *
 * @author Eliana Rojas
 */
public class Utilidades {

    /**
     * Imprime un rectangulo con el texto pasado por parametro
     *
     * @param texto Almacena el texto sobre el cual va a dibujar el rectangulo
     */
    public static void dibujarRectanguloTexto(String texto) {
        int longitudTexto = texto.length();

        // Dibujar el rectángulo
        dibujarRectangulo(longitudTexto);

        // Imprimir el texto en el rectángulo
        System.out.println("| " + texto + " |");

        // Dibujar el rectángulo nuevamente
        dibujarRectangulo(longitudTexto);
    }

    /**
     * Imprime las lineas horizontales del rectángulo en función a la longitud pasada por parámetro
     *
     * @param longitud
     */
    public static void dibujarRectangulo(int longitud) {
        for (int i = 0; i < longitud + 4; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Imprime línea de separacion
     *
     * @author Milagros Pecar
     */
    public static void imprimirLineas() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Imprime línea de separacion en función a la longitud del string pasado por parámetro
     *
     * @param texto String sobre el cual se va a calcular la longitud
     */
    public static void imprimirLineas(String texto) {
        int longitudMaxima = texto.length();
        String linea = generarLinea("-", longitudMaxima);
        System.out.println(linea);
    }

    /**
     * Genera una línea de caracteres en función a la longitud y el caracter pasados por parámetro
     *
     * @param caracter Caracter que se va a repetir, puede ser -, *, etc
     * @param longitud Longitud de la línea
     * @return String con la línea generada
     */
    private static String generarLinea(String caracter, int longitud) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append(caracter);
        }
        return sb.toString();
    }

}
