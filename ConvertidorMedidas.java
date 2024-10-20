package conversiones;

/**
 *
 * @author eduardotec05
 */
public class ConversorMedidas {

    //atributos de la clase
    private double valor, valorConvertido;

    //constructor
    public ConversorMedidas() {
        this.valor = 0;
    }

    /**
     * Método para convertir el valor ingresado por el usuario a metros
     *
     * @param valor es el valor ingresado por el usuario
     * @param unidadOrigen es la unidad de origen que el usuario requiera
     */
    public void convertidorMedidas(double valor, String unidadOrigen) {

        switch (unidadOrigen.toLowerCase()) {
            case "metros", "1" -> {
                this.valor = valor; // Ya está en metros
            }
            case "pulgadas", "2" -> {
                this.valor = valor * 0.0254;
            }
            case "pies", "3" -> {
                this.valor = valor * 0.3048;
            }
            case "centimetros", "4" -> {
                this.valor = valor * 0.01;
            }
            case "kilometros", "5" -> {
                this.valor = valor * 1000;
            }
            case "millas", "6" -> {
                this.valor = valor * 1609.34;
            }
            default -> {
                this.valor = 0;
            }
        }

    }//fin de metodo para convertir cualquier valor a metros

    /**
     * Método que devuelve el valor que ya está convertido
     *
     * @return devuelve el valor ya convertido
     */
    public double getNum() {
        return valorConvertido;
    }

    /**
     * Método para convertir a metros
     */
    public void setMetros() {
        this.valorConvertido = this.valor;
    }

    /**
     * Método para convertir el valor en pulgadas
     */
    public void setPulgadas() {
        this.valorConvertido = this.valor / 0.0254;
    }

    /**
     * Método para convertir el valor en millas
     */
    public void setMillas() {
        this.valorConvertido = this.valor / 1609.34;
    }

    /**
     * Método para convertir el valor en pies
     */
    public void setPies() {
        this.valorConvertido = this.valor / 0.3048;
    }

    /**
     * Método para convertir el valor en centimetros
     */
    public void setCentimetros() {
        this.valorConvertido = this.valor / 0.01;
    }

    /**
     * Método para devolver el valor en kilometros
     */
    public void setKilometros() {
        this.valorConvertido = this.valor / 1000;
    }
}
