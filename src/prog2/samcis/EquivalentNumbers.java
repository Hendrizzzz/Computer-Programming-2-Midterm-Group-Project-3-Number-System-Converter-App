package prog2.samcis;

public class EquivalentNumbers implements NumberConverter{
    double decimal;
    String binaryString;
    String octalString;
    String hexadecimalString;



    public String getBinaryString() {
        return binaryString;
    }

    /**
     * sets the binaryString to the given parameter.
     * binary will be used for the conversion to decimal.
     * decimal will be used for the conversion to octal and hexadecimal.
     *
     * @author Oliver Yu
     * @param binaryString - given input
     */
    public void setBinaryString(String binaryString) throws Exception {
        this.binaryString = binaryString;
        decimal = binaryToDecimal(binaryString);
        octalString = decimalToOctal(decimal);
        hexadecimalString = decimalToHexadecimal(decimal);
    }



    public String getOctalString() {
        return octalString;
    }

    /**
     * One will do this
     * @author...
     * @param octalString
     */
    public void setOctalString(String octalString) {
        this.octalString = octalString;
    }


    public double getDecimal() {
        return decimal;
    }

    /**
     * One will do this
     * @author....
     *
     * @param decimal
     */
    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }



    public String getHexadecimalString() {
        return hexadecimalString;
    }

    /**
     * Sets the hexadecimal string and calculates the decimal, octal, and binary representations.
     * The method updates the hexadecimal string field and calculates its equivalent decimal, octal, and binary representations.
     *
     * @author Archilles Kyle Sambot
     * @param hexadecimalString The hexadecimal string to be set.
     */

    public void setHexadecimalString(String hexadecimalString) throws Exception {
        this.hexadecimalString = hexadecimalString;
        decimal = hexadecimalToDecimal(hexadecimalString);
        octalString = decimalToOctal(decimal);
        binaryString = decimalToBinary(decimal);
    }

    /**
     * Converts a String representation of a binary number to an integer representation of a decimal number.
     * The binary string firstly undergoes to a method called isValidBinaryString() to identify if the binary string is valid.
     * If the binary string is not valid, an Exception will occur.
     * If the binary string is valid, the binary string will then be extracted character by character to be used in the conversion process.
     *
     * @author Oliver Yu
     *
     * @param binary String representation of the binary number.
     * @return decimal in Integer type.
     */
    @Override
    public double binaryToDecimal(String binary) throws Exception {
        double result = 0;
        boolean isNegative = false;
        String wholePart = "";
        String decimalPart = "";

        // Removes the negative sign if it is existent in the string.
        if (binary.charAt(0) == '-') {
            binary = binary.substring(1);
            isNegative = true;
        }

        // checks the validity of the string.
        if (!isValidBinaryString(binary))
            throw new Exception("Invalid Binary Number");

        // Splits the whole part and the fractional part of the string.
        if (binary.indexOf('.') > -1) {
            String[] split = binary.split("\\.");
            wholePart = split[0];
            decimalPart = split[1];
        } else {
            wholePart = binary;
        }

        // Converts the whole part to decimal.
        for (int i = 0; i < wholePart.length(); i++)
            result += (int) (Integer.parseInt("" + wholePart.charAt(i)) * Math.pow(2, (int) (wholePart.length() - 1 - i)));

        // Converts the fractional part (continues from whole part conversion)
        if (decimalPart != null)
            for (int i = 0; i < decimalPart.length(); i++)
                result += (Integer.parseInt("" + decimalPart.charAt(i)) * Math.pow(2, -i - 1));

        // returns a negative result if the number was a negative number.
        if (isNegative)
            return result * -1;

        return result;
    }

    @Override
    public int octalToDecimal(String octal) {
        return 0;
    }

    @Override
    public int hexadecimalToDecimal(String hexadecimal) {
        int decimalValue = 0;
        // Converting hexadecimal string to uppercase to handle lowercase input
        hexadecimal = hexadecimal.toUpperCase();

        // Iterate through each character of the hexadecimal string
        for (int i = 0; i < hexadecimal.length(); i++) {
            char digit = hexadecimal.charAt(i);
            // Convert hexadecimal digit to decimal value
            int digitValue;
            if (digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                digitValue = digit - 'A' + 10;
            } else {
                // Invalid hexadecimal character
                throw new IllegalArgumentException("Invalid hexadecimal character: " + digit);
            }
            // Update the decimal value with the converted digit
            decimalValue = 16 * decimalValue + digitValue;
        }

        return decimalValue;
    }

    @Override
    public String decimalToBinary(double decimal) {
        return null;
    }

    @Override
    public String decimalToOctal(double decimal) {
        return null;
    }

    @Override
    public String decimalToHexadecimal(double decimal) {
        return null;
    }

    /**
     * This method is to check the validity of the binary string.
     * The method first checks if the binary has a decimal point. If the decimal point is present, it will be removed.
     * Then, each character of the binary string will be checked.
     * If one of the character of the binary string is other than '0' or '1', the method will return false.
     *
     * @author Oliver Yu
     *
     * @param binaryString String representation of the binary number to be verified.
     * @return True if the binaryString is a valid binary number. Otherwise, returns false.
     */
    private boolean isValidBinaryString(String binaryString) {
        boolean result = true;

        // Removes only 1 decimal point.
        if (binaryString.indexOf('.') > -1)
            binaryString = binaryString.replaceFirst("\\.", "");

        for (int index = 0; index < binaryString.length(); index++) {
            if (binaryString.charAt(index) != '0' && binaryString.charAt(index) != '1') {
                result = false;
                break;
            }
        }
        return result;
    }
}

