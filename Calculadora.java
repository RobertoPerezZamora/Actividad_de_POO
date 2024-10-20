

package conversoresfront;

/**
 *
 * @author angel
 */
public class Calculadora {

    //Atributos principales
    public double acumulado;

    //Constructor principal
    public Calculadora() {
        this.acumulado = 0;
    }

    public void numInicial(double valor) {
        this.acumulado = valor;
    }

    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    // Metodos 
    
/**
 * se hace una operación matemática sobre el valor acumulado.
 * 
 *método que acumula un valor en función de la operación seleccionada
 * que se determina mediante el parámetro opcion2.
 * 
 * @param num     el número que se utilizará en la operación.
 * @param opcion2 el tipo de operación a realizar:
 *                1 - Suma
 *                2 - Resta
 *                3 - Multiplicación
 *                4 - División
 * 
 * 
 */
    public void operaciones(double num, int opcion2) {
        switch (opcion2) {
            case 1:

                this.acumulado += num;
                break;

            case 2:

                this.acumulado -= num;
                break;

            case 3:

                this.acumulado *= num;
                break;

            case 4:

                this.acumulado /= num;
                
                

        }
    }

    /**
     * Metodo para que develva el resultado al usuario.
     *
     * @return Regresa el resultado a la consola
     */
    public double getResultado() {
        return acumulado;
    }

    /** Metodo para borrar el valor actual guardado
     * 
     * @return regresa el valor a 0
     */
    public double vaciarResultado() {
        this.acumulado = 0;
        return acumulado;
    }

}
