/**
 * Clase para convertir números entre sistemas numéricos (binario, hexadecimal, octal y decimal).
 */
public class SisNumericos {
    private String number;
    private String entradaOne;
    private String salidaOne;

    /**
     * Obtiene el número a convertir.
     * @return el número como cadena.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Establece el número a convertir.
     * @param number el número como cadena.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Obtiene el tipo de entrada (sistema numérico del número original).
     * @return el tipo de entrada como cadena.
     */
    public String getPrimerD() {
        return entradaOne;
    }

    /**
     * Establece el tipo de entrada (sistema numérico del número original).
     * @param inputType el tipo de entrada como cadena.
     */
    public void setPrimerD(String inputType) {
        this.entradaOne = inputType;
    }

    /**
     * Obtiene el tipo de salida deseado (sistema numérico al que se va a convertir).
     * @return el tipo de salida como cadena.
     */
    public String getSalida() {
        return salidaOne;
    }

    /**
     * Establece el tipo de salida deseado (sistema numérico al que se va a convertir).
     * @param outputType el tipo de salida como cadena.
     */
    public void setSalida(String outputType) {
        this.salidaOne = outputType;
    }

    /**
     * Convierte un número de su sistema numérico original a decimal.
     * @param number el número como cadena.
     * @param inputType el tipo de entrada (binario, hexadecimal, octal, decimal).
     * @return el valor decimal del número.
     */
    public int convertidorDecimal(String number, String inputType) {
        switch (inputType.toLowerCase()) {
            case "binario":
                return binarioADecimal(number);
            case "hexadecimal":
                return hexADecimal(number);
            case "octal":
                return octalADecimal(number);
            case "decimal":
                return Integer.parseInt(number);
            default:
                throw new IllegalArgumentException("Tipo de número no soportado: " + inputType);
        }
    }

    /**
     * Convierte un número binario a decimal.
     * @param binary el número binario como cadena.
     * @return el valor decimal del número.
     */
    private int binarioADecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(binary.length() - 1 - i);
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }

    /**
     * Convierte un número hexadecimal a decimal.
     * @param hex el número hexadecimal como cadena.
     * @return el valor decimal del número.
     */
    private int hexADecimal(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexDigit = hex.charAt(hex.length() - 1 - i);
            if (Character.isDigit(hexDigit)) {
                decimal += Character.getNumericValue(hexDigit) * Math.pow(16, i);
            } else {
                decimal += (10 + hexDigit - 'A') * Math.pow(16, i);
            }
        }
        return decimal;
    }

    /**
     * Convierte un número octal a decimal.
     * @param octal el número octal como cadena.
     * @return el valor decimal del número.
     */
    private int octalADecimal(String octal) {
        int decimal = 0
                ;
        for (int i = 0; i < octal.length(); i++) {
            char octalDigit = octal.charAt(octal.length() - 1 - i);
            decimal += Character.getNumericValue(octalDigit) * Math.pow(8, i);
        }
        return decimal;
    }

    /**
     * Convierte un número decimal a otro sistema numérico.
     * @param decimal el valor decimal del número.
     * @param outputType el tipo de salida (binario, hexadecimal, octal, decimal).
     * @return el número convertido como cadena.
     */
    public String decimalANumeros(int decimal, String outputType) {
        switch (outputType.toLowerCase()) {
            case "binario":
                return decimalBinario(decimal);
            case "hexadecimal":
                return decimalToHex(decimal);
            case "octal":
                return decimalOctal(decimal);
            case "decimal":
                return Integer.toString(decimal);
            default:
                throw new IllegalArgumentException("Tipo de número no soportado: " + outputType);
        }
    }

    /**
     * Convierte un número decimal a binario.
     * @param decimal el valor decimal del número.
     * @return el número binario como cadena.
     */
    private String decimalBinario(int decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal /= 2;
        }
        return binary.toString();
    }

    /**
     * Convierte un número decimal a hexadecimal.
     * @param decimal el valor decimal del número.
     * @return el número hexadecimal como cadena.
     */
    private String decimalToHex(int decimal) {
        StringBuilder hex = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) {
                hex.insert(0, (char) (remainder + '0'));
            } else {
                hex.insert(0, (char) (remainder - 10 + 'A'));
            }
            decimal /= 16;
        }
        return hex.toString();
    }

    /**
     * Convierte un número decimal a octal.
     * @param decimal el valor decimal del número.
     * @return el número octal como cadena.
     */
    private String decimalOctal(int decimal) {
        StringBuilder octal = new StringBuilder();
        while (decimal > 0) {
            octal.insert(0, decimal % 8);
            decimal /= 8;
        }
        return octal.toString();
    }
}