

package calculadora;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Calculadora {

    public static double acumulador = 0; // Acumulador de operaciones
    static int opcion = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            // Menu principal
            mostrarmenu(null);
            solicitar_opcion();
            casos_operaciones();

        } while (opcion != 5);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 
     * @param texto Imprimir texto en la consola
     */
    public static void impTxt(String texto) {
        System.out.println(texto);// Imprimir texto en la consola
    }// Fin de impTxt

    
    /**
     * 
     * @param texto Imprimir texto en la consola y No salta de linea
     */
    public static void impTxt2(String texto) {
        System.out.print(texto);// Imprimir texto en la consola y No salta de linea
    }// Fin de impTxt

    
    /**
     * 
     * @param texto imprimer el menu de la calculadora
     */
    public static void mostrarmenu(String texto) {
        impTxt("<========Menú========>");
        impTxt("1. Suma");
        impTxt("2. Resta");
        impTxt("3. Multiplicacion");
        impTxt("4. Division");
        impTxt("5. Salir");
        impTxt("================================");
        impTxt2("Ingrese la opcion: ");// Imprimir texto en la consola
    }// Fin de mostrarmenu

    
    /**
     * Solicita al usuario un valor
     */
    public static void solicitar_opcion() {
        boolean entradaValida = false;
        do {
            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                entradaValida = true; // Si la entrada es válida, se sale del bucle
            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número entero válido.");
                sc.nextLine(); // Limpiar el buffer para evitar bucle infinito
                impTxt2("Ingrese la opción nuevamente: "); // Pedir de nuevo la opción
            }
        } while (!entradaValida); // Repite hasta que el usuario ingrese una opción válida
    }

    
    /**
     * .equalsIgnoreCase ignora si es mayuscula o minuscula
     * El simbolo || funciona como operador logico: true o false
     * Suma se encarga de hacer la operacion de suma
     * Validaciones
     */
    public static void suma() {
        String salir; // Variable para que el usuario elija si seguir sumando o salir
        do {
            try {
                impTxt2("Ingrese el valor a sumar: ");
                double valor = sc.nextDouble(); // Obtener el valor a sumar
                acumulador += valor; // Acumular el valor en el acumulador
                impTxt("Valor agregado. El acumulado hasta ahora es: " + acumulador);

            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número entero válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }

            // Preguntar si desea continuar o salir de la suma
            while (true) {
                impTxt2("¿Desea seguir sumando? (s/n): ");
                salir = sc.next(); // Leer la respuesta del usuario
                if (salir.equalsIgnoreCase("s") || salir.equalsIgnoreCase("n")) {
                    break; // Salir del bucle si la entrada es válida ("s" o "n")
                } else {
                    impTxt("Error: Debes ingresar 's' para seguir o 'n' para salir.");
                }
            }

        } while (salir.equalsIgnoreCase("s")); // Sigue sumando mientras el usuario diga "s"

        // Imprimir resultado
        impTxt("<======================================================>");
        impTxt("El resultado de la suma es: " + acumulador);
    }

    
    /**
     * .equalsIgnoreCase ignora si es mayuscula o minuscula
     * El simbolo || funciona como operador logico: true o false
     * Resta se encarga de hacer la operacion de resta
     * Validaciones
     */
    public static void resta() {
        String salir; // Variable para que el usuario elija si seguir sumando o salir
        double valor;

        // Bucle para solicitar el valor inicial hasta que se ingrese un número válido
        while (true) {
            try {
                impTxt2("Ingrese el valor inicial para la resta: ");
                valor = sc.nextDouble(); // Asignar el valor inicial
                acumulador = valor; // Inicializamos el acumulador con el valor inicial
                break; // Salir del bucle si se ingresó un valor válido
            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }
        }

        do {
            try {
                impTxt2("Ingrese el valor a restar: ");
                valor = sc.nextDouble(); // Obtener el valor a sumar
                acumulador -= valor; // Acumular el valor en el acumulador
                impTxt("Valor agregado. El acumulado hasta ahora es: " + acumulador);

            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número entero válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }

            // Preguntar si desea continuar o salir de la suma
            while (true) {
                impTxt2("¿Desea seguir restar? (s/n): ");
                salir = sc.next(); // Leer la respuesta del usuario
                if (salir.equalsIgnoreCase("s") || salir.equalsIgnoreCase("n")) {
                    break; // Salir del bucle si la entrada es válida ("s" o "n")
                } else {
                    impTxt("Error: Debes ingresar 's' para seguir o 'n' para salir.");
                }
            }

        } while (salir.equalsIgnoreCase("s")); // Sigue sumando mientras el usuario diga "s"

        // Imprimir resultado
        impTxt("<======================================================>");
        impTxt("El resultado de la resta es: " + acumulador);
    }

    
    /**
     * .equalsIgnoreCase ignora si es mayuscula o minuscula
     * El simbolo || funciona como operador logico: true o false
     * multiplicacion se encarga de hacer la operacion de multi
     * Validaciones
     */
    public static void multiplicacion() {
        String salir; // Variable para que el usuario elija si seguir sumando o salir
        double valor;

        // Bucle para solicitar el valor inicial hasta que se ingrese un número válido
        while (true) {
            try {
                impTxt2("Ingrese el valor inicial para la multiplicacion: ");
                valor = sc.nextDouble(); // Asignar el valor inicial
                acumulador = valor; // Inicializamos el acumulador con el valor inicial
                break; // Salir del bucle si se ingresó un valor válido
            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }
        }

        do {

            try {
                impTxt2("Ingrese el valor a multiplicar: ");
                valor = sc.nextDouble(); // Obtener el valor a sumar
                acumulador *= valor; // Acumular el valor en el acumulador
                impTxt("Valor agregado. El acumulado hasta ahora es: " + acumulador);

            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número entero válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }

            // Preguntar si desea continuar o salir de la suma
            while (true) {
                impTxt2("¿Desea seguir multiplicando? (s/n): ");
                salir = sc.next(); // Leer la respuesta del usuario
                if (salir.equalsIgnoreCase("s") || salir.equalsIgnoreCase("n")) {
                    break; // Salir del bucle si la entrada es válida ("s" o "n")
                } else {
                    impTxt("Error: Debes ingresar 's' para seguir o 'n' para salir.");
                }
            }

        } while (salir.equalsIgnoreCase("s")); // Sigue sumando mientras el usuario diga "s"

        // Imprimir resultado
        impTxt("<======================================================>");
        impTxt("El resultado de la multiplicacion es: " + acumulador);
    }

    
    /**
     * .equalsIgnoreCase ignora si es mayuscula o minuscula
     * El simbolo || funciona como operador logico: true o false
     * Division se encarga de hacer la operacion de divisiones
     * Validaciones
     */
    public static void division() {
        String salir = ""; // Variable para que el usuario elija si seguir dividiendo o salir
        double valor;

    
        // Bucle para solicitar el valor inicial hasta que se ingrese un número válido
        while (true) {
            try {
                impTxt2("Ingrese el valor inicial para la division: ");
                valor = sc.nextDouble(); // Asignar el valor inicial
                acumulador = valor; // Inicializamos el acumulador con el valor inicial
                break;
            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número entero válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }

        }

        // Si el valor inicial es 0, se detiene la operación de inmediato
        if (acumulador == 0) {
            impTxt("El valor inicial no puede ser 0. No es posible dividir.");
            return; // Salir de la función
        }

        do {
            try {
                // Solicitar el valor para la división
                impTxt2("Ingrese el valor para dividir: ");
                valor = sc.nextDouble();

                // Verificar si el valor es 0, ya que no se puede dividir entre 0
                if (valor == 0) {
                    impTxt("Error: No puedes dividir entre 0. Intenta con otro número.");
                    continue; // Pedir otro número
                }

                // Realizar la división
                acumulador /= valor;
                impTxt("Resultado acumulado hasta ahora es: " + acumulador);

                // Si el acumulador llega a 0, se detiene el bucle
                if (acumulador == 0) {
                    impTxt("El resultado es 0. La operación de división se ha detenido.");
                    break; // Salir del bucle porque el resultado es 0
                }

            } catch (Exception e) {
                impTxt("Error: Debes ingresar un número válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }

            // Preguntar si desea continuar o salir de la división
            while (true) {
                impTxt2("¿Desea seguir dividiendo? (s/n): ");
                salir = sc.next(); // Leer la respuesta del usuario
                if (salir.equalsIgnoreCase("s") || salir.equalsIgnoreCase("n")) {
                    break; // Salir del bucle si la entrada es válida ("s" o "n")
                } else {
                    impTxt("Error: Debes ingresar 's' para seguir o 'n' para salir.");
                }
            }

        } while (salir.equalsIgnoreCase("s")); // Sigue dividiendo mientras el usuario diga "s"

        // Imprimir resultado final acumulado
        impTxt("<======================================================>");
        impTxt("El resultado de la division es: " + acumulador);
    }

    /**
     * Metodo para la seleccion de casos
     */
    public static void casos_operaciones() {

        switch (opcion) {

            case 1:
                impTxt("<========Suma========>");
                suma();
                break;
            case 2:
                impTxt("<========Resta========>");
                resta();
                break;

            case 3:
                impTxt("<========Multiplicacion========>");
                multiplicacion();
                break;

            case 4:
                impTxt("<========Division========>");
                division();
                break;

            default:
            impTxt("<======================================================>");
            impTxt("Saliendo de la Calculadora....");
            impTxt("<======================================================>");
                break;
        }

    }

}
