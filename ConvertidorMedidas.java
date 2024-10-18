package conversiones;

/**
 *
 * @author lalot
 */
import java.util.Scanner;

public class ConvertidorMedidas {

    /** 
     * Método para verificar si la entrada es un número válido
     * @param str Entrdad del string para validar
     * @return devuelve si el valor ingresa es número o no.
     */
    public boolean esNumero(String str) {
        try {
            Double.parseDouble(str);  // Intentar convertir la cadena a número
            return true;  // Si la conversión es exitosa, es un número
        } catch (NumberFormatException e) {
            return false;  // Si ocurre una excepción, no es un número válido
        }
    }

    /** Método para validar que la unidad ingresada es válida
     * 
     * @param unidad ingresa el valor de la unidad que va a validar
     * @return devuelve si la unidad esta en las opciones o no
     */
    public boolean esUnidadValida(String unidad) {
        String[] unidadesValidas = {"metros", "pulgadas", "pies", "centimetros", "kilometros", "millas"};
        // Validar si es un número
        try {
            int opcion = Integer.parseInt(unidad);
            return opcion >= 1 && opcion <= unidadesValidas.length;  // Número válido en el rango de opciones
        } catch (NumberFormatException e) {
            // Validar si es el nombre de la unidad
            for (String u : unidadesValidas) {
                if (u.equalsIgnoreCase(unidad)) {
                    return true;
                }
            }
        }
        return false;  // Si no es número válido ni nombre válido, retornar falso
    }

    /**
     * Método para imprimir las opciones de medidas
     * 
     */
    public void mostrarOpcionesUnidades() {
        String[] unidades = {"Metros", "Pulgadas", "Pies", "Centimetros", "Kilometros", "Millas"};
        System.out.println("Opciones de unidades:");
        for (int i = 0; i < unidades.length; i++) {
            System.out.println((i + 1) + ". " + unidades[i]);
        }
    }

    /** Método para convertir cualquier unidad a metros
     * 
     * @param valor Entrada del usuario para convertirla a metros
     * @param unidadOrigen Es la unidad de medida de la cual quiere convertir
     * @return devuelve la entrada del usuario convertida en metros
     */
    public double aMetros(double valor, String unidadOrigen) {
        if (valor > 0) {
            switch (unidadOrigen.toLowerCase()) {
                case "metros", "1" -> {
                    return valor; // Ya está en metros
                }
                case "pulgadas", "2" -> {
                    return valor * 0.0254;
                }
                case "pies", "3" -> {
                    return valor * 0.3048;
                }
                case "centimetros", "4" -> {
                    return valor * 0.01;
                }
                case "kilometros", "5" -> {
                    return valor * 1000;
                }
                case "millas", "6" -> {
                    return valor * 1609.34;
                }
                default -> {
                    System.out.println("Unidad de entrada no válida.");
                    return -1;
                }
            }
        } else {
            System.out.println("El valor debe ser mayor a 0. Recuerda que no existen medidas negativas.");
            return -1;
        }
    }

    /** Método para convertir de metros a otra unidad
     * 
     * @param valor toma el valor convertido en metros para convertilo en la unidad deseada
     * @param unidadDestino Es la unidad final a la cual se va a convertir 
     * @return devuelve el valor convertido a la unidad deseada
     */
    public double deMetros(double valor, String unidadDestino) {
        switch (unidadDestino.toLowerCase()) {
            case "metros", "1" -> {
                return valor; // Ya está en metros
            }
            case "pulgadas", "2" -> {
                return valor / 0.0254;
            }
            case "pies", "3" -> {
                return valor / 0.3048;
            }
            case "centimetros", "4" -> {
                return valor / 0.01;
            }
            case "kilometros", "5" -> {
                return valor / 1000;
            }
            case "millas", "6" -> {
                return valor / 1609.34;
            }
            default -> {
                System.out.println("Unidad de entrada no válida.");
                return -1;
            }
        }
    }

    /** Método principal que realiza la conversión con validación en bucles
     * 
     * @param scanner es la entrada de datos para despues validar si esta es un numero o no
     * @return devuelve el valor que se va a mostrar al usuario
     */
    public double convertir(Scanner scanner) {
        String valorStr;
        double valor = 0;

        // Entrada de valor numérico con validación en un bucle
        do {
            System.out.print("Ingrese el valor a convertir (debe ser un número positivo): ");
            valorStr = scanner.nextLine();
            if (!esNumero(valorStr)) {
                System.out.println("Error: El valor ingresado no es un número válido.");
            } else {
                valor = Double.parseDouble(valorStr);
                if (valor <= 0) {
                    System.out.println("Error: El valor debe ser mayor a 0.");
                }
            }
        } while (!esNumero(valorStr) || valor <= 0);  // Repetir hasta que el valor sea válido

        // Solicitar unidad de origen y destino
        mostrarOpcionesUnidades(); // Mostrar opciones de unidades

        String unidadOrigen, unidadDestino;
        do {
            System.out.print("Ingrese la unidad de origen (nombre o número): ");
            unidadOrigen = scanner.nextLine();
            if (!esUnidadValida(unidadOrigen)) {
                System.out.println("Error: La unidad de origen no es válida.");
            }
        } while (!esUnidadValida(unidadOrigen));  // Repetir hasta que la unidad de origen sea válida

        do {
            System.out.print("Ingrese la unidad de destino (nombre o número): ");
            unidadDestino = scanner.nextLine();
            if (!esUnidadValida(unidadDestino)) {
                System.out.println("Error: La unidad de destino no es válida.");
            }
        } while (!esUnidadValida(unidadDestino));  // Repetir hasta que la unidad de destino sea válida

        // Convertir a metros
        double valorEnMetros = aMetros(valor, unidadOrigen);
        if (valorEnMetros == -1) {
            return -1;
        }

        // Convertir de metros a la unidad destino
        double valorConvertido = deMetros(valorEnMetros, unidadDestino);
        return valorConvertido;
    }
}