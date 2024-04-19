package prog2.samcis;

public class EquivalentNumbers implements NumberConverter{
    double decimal;
    String binaryString;
    String octalString;
    String hexadecimalString;




    /**
     * Gets the binary string representation of the number.
     *
     * @return the binary string representation
     */
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





    /**
     * Gets the octal string representation of the number.
     *
     * @return the octal string representation
     */
    public String getOctalString() {
        return octalString;
    }


    /**
     * Sets the octal string representation and calculates the decimal, binary, and hexadecimal equivalents.
     *
     * @param octalString the string representing the octal number to be set
     * @throws NumberFormatException if the input string is not a valid octal number
     * @throws Exception             if an error occurs during the conversion process
     * @author Paul Pajara
     */
    public void setOctalString(String octalString) throws Exception {
        this.octalString = octalString;
        decimal = octalToDecimal(octalString);
        binaryString = decimalToBinary(decimal);
        hexadecimalString = decimalToHexadecimal(decimal);
    }





    /**
     * Gets the decimal value represented by the object.
     *
     * @return the decimal value
     */
    public double getDecimal() {
        return decimal;
    }


    /**
     * Sets the decimal number and updates binary, octal, and hexadecimal representations accordingly.
     * @author Martin, Michael John
     *
     * @param decimal - Decimal number to set.
     */
    public void setDecimal(double decimal) {
        this.decimal = decimal;
        binaryString = decimalToBinary(decimal);
        octalString = decimalToOctal(decimal);
        hexadecimalString = decimalToHexadecimal(decimal);
    }



    /**
     * Gets the hexadecimal string representation of the number.
     *
     * @return the hexadecimal string representation
     */
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





    /**
     * Converts an octal string to a decimal number.
     *
     * @param octal the octal string to convert
     * @return the decimal representation of the octal string
     * @throws NumberFormatException if the input string is not a valid octal number
     * @author Pajara, Paul Jabez
     */
    @Override
    public double octalToDecimal(String octal) {
        // Remove any leading whitespace
        octal = octal.trim();

        // Check for negative octal
        boolean isNegative = false;
        if (octal.startsWith("-")) {
            isNegative = true;
            octal = octal.substring(1); // Remove the negative sign
        }

        // Check for fractional octal
        String[] parts = octal.split("\\.");
        String wholePart = parts[0];
        String fractionalPart = "";
        if (parts.length > 1) {
            fractionalPart = parts[1];
        }

        // Convert whole part from octal to decimal
        double decimal = 0;
        for (int i = 0; i < wholePart.length(); i++) {
            char digit = wholePart.charAt(i);
            int value = Character.digit(digit, 8);
            if (value == -1) {
                throw new NumberFormatException("Invalid octal digit: " + digit);
            }
            decimal = decimal * 8 + value;
        }

        // Convert fractional part from octal to decimal
        double fractionalDecimal = 0;
        double fractionalBase = 1.0 / 8.0;
        for (int i = 0; i < fractionalPart.length(); i++) {
            char digit = fractionalPart.charAt(i);
            int value = Character.digit(digit, 8);
            if (value == -1) {
                throw new NumberFormatException("Invalid octal digit: " + digit);
            }
            fractionalDecimal += value * fractionalBase;
            fractionalBase /= 8.0;
        }

        decimal += fractionalDecimal;

        // Apply negative sign if necessary
        if (isNegative) {
            decimal = -decimal;
        }

        return decimal;
    }








    /**
     * Converts a hexadecimal string to a decimal number.
     *
     * @param hexadecimal the hexadecimal string to convert
     * @return the decimal representation of the hexadecimal string
     * @throws NumberFormatException if the input string is not a valid hexadecimal number
     * @author Sambot, Archilles Kyle
     */
    @Override
    public double hexadecimalToDecimal(String hexadecimal) {
        // Remove any leading whitespace and convert to uppercase for consistency
        hexadecimal = hexadecimal.trim().toUpperCase();

        // Check for negative hexadecimal
        boolean isNegative = false;
        if (hexadecimal.startsWith("-")) {
            isNegative = true;
            hexadecimal = hexadecimal.substring(1); // Remove the negative sign
        }

        // Check for fractional hexadecimal
        String[] parts = hexadecimal.split("\\.");
        String wholePart = parts[0];
        String fractionalPart = "";
        if (parts.length > 1) {
            fractionalPart = parts[1];
        }

        // Convert whole part from hexadecimal to decimal
        double decimal = 0;
        for (int i = 0; i < wholePart.length(); i++) {
            char digit = wholePart.charAt(i);
            int value = Character.digit(digit, 16);
            if (value == -1) {
                throw new NumberFormatException("Invalid hexadecimal digit: " + digit);
            }
            decimal = decimal * 16 + value;
        }

        // Convert fractional part from hexadecimal to decimal
        double fractionalDecimal = 0;
        double fractionalBase = 1.0 / 16.0;
        for (int i = 0; i < fractionalPart.length(); i++) {
            char digit = fractionalPart.charAt(i);
            int value = Character.digit(digit, 16);
            if (value == -1) {
                throw new NumberFormatException("Invalid hexadecimal digit: " + digit);
            }
            fractionalDecimal += value * fractionalBase;
            fractionalBase /= 16.0;
        }

        decimal += fractionalDecimal;

        // Apply negative sign if necessary
        if (isNegative) {
            decimal = -decimal;
        }

        return decimal;
    }







    /**
     * Converts a decimal number to a binary string.
     *
     * @param decimal the decimal number to convert
     * @return the binary representation of the decimal number
     * @author Martin, Michael John
     */
    @Override
    public String decimalToBinary(double decimal) {
        // Handle negative decimals
        boolean isNegative = false;
        if (decimal < 0) {
            isNegative = true;
            decimal = -(decimal); // Convert to positive for conversion
        }

        // Split decimal into whole and fractional parts
        int wholePart = (int) decimal;
        double fractionalPart = decimal - wholePart;

        // Convert whole part to binary
        StringBuilder binaryWhole = new StringBuilder();
        if (wholePart == 0) {
            binaryWhole.append(0);
        } else {
            while (wholePart > 0) {
                binaryWhole.insert(0, wholePart % 2);
                wholePart /= 2;
            }
        }

        // Convert fractional part to binary
        StringBuilder binaryFractional = new StringBuilder();
        int MAX_PRECISION = 20; // Maximum precision for fractional part
        while (fractionalPart > 0) {
            // Set maximum precision to avoid infinite loop for repeating fractions
            if (binaryFractional.length() >= MAX_PRECISION) {
                break;
            }
            fractionalPart *= 2;
            int bit = (int) fractionalPart;
            binaryFractional.append(bit);
            fractionalPart -= bit;
        }

        // Combine whole and fractional parts
        StringBuilder binary = new StringBuilder();
        binary.append(binaryWhole);
        if (!binaryFractional.isEmpty()) {
            binary.append('.');
            binary.append(binaryFractional);
        }

        // Add negative sign if necessary
        if (isNegative) {
            binary.insert(0, '-');
        }

        return binary.toString();
    }








    /**
     * Converts a decimal number to an octal string.
     *
     * @param decimal the decimal number to convert
     * @return the octal representation of the decimal number
     * @author Martin, Michael
     */
    @Override
    public String decimalToOctal(double decimal) {
        // Handle negative decimals
        boolean isNegative = false;
        if (decimal < 0) {
            isNegative = true;
            decimal = -(decimal); // Convert to positive for conversion
        }

        // Split decimal into whole and fractional parts
        int wholePart = (int) decimal;
        double fractionalPart = decimal - wholePart;

        // Convert whole part to octal
        String octalWhole = Integer.toOctalString(wholePart);

        // Convert fractional part to octal
        StringBuilder octalFractional = new StringBuilder();
        int MAX_PRECISION = 20; // Maximum precision for fractional part
        for (int i = 0; i < MAX_PRECISION; i++) {
            fractionalPart *= 8;
            int digit = (int) fractionalPart;
            octalFractional.append(digit);
            fractionalPart -= digit;
            if (fractionalPart == 0) {
                break;
            }
        }

        // Combine whole and fractional parts
        StringBuilder octal = new StringBuilder();
        octal.append(octalWhole);
        if (!octalFractional.isEmpty()) {
            octal.append('.');
            octal.append(octalFractional);
        }

        // Add negative sign if necessary
        if (isNegative) {
            octal.insert(0, '-');
        }

        return octal.toString();
    }







    /**
     * Converts a decimal number to a hexadecimal string.
     *
     * @param decimal the decimal number to convert
     * @return the hexadecimal representation of the decimal number
     *
     * @author Martin, Michael John
     */
    @Override
    public String decimalToHexadecimal(double decimal) {
        // Handle negative decimals
        boolean isNegative = false;
        if (decimal < 0) {
            isNegative = true;
            decimal = -(decimal); // Convert to positive for conversion
        }

        // Split decimal into whole and fractional parts
        int wholePart = (int) decimal;
        double fractionalPart = decimal - wholePart;

        // Convert whole part to hexadecimal
        String hexadecimalWhole = Integer.toHexString(wholePart).toUpperCase();

        // Convert fractional part to hexadecimal
        StringBuilder hexadecimalFractional = new StringBuilder();
        int MAX_PRECISION = 20; // Maximum precision for fractional part
        for (int i = 0; i < MAX_PRECISION; i++) {
            fractionalPart *= 16;
            int digit = (int) fractionalPart;
            hexadecimalFractional.append(Integer.toHexString(digit).toUpperCase());
            fractionalPart -= digit;
            if (fractionalPart == 0) {
                break;
            }
        }

        // Combine whole and fractional parts
        StringBuilder hexadecimal = new StringBuilder();
        hexadecimal.append(hexadecimalWhole);
        if (!hexadecimalFractional.isEmpty()) {
            hexadecimal.append('.');
            hexadecimal.append(hexadecimalFractional);
        }

        // Add negative sign if necessary
        if (isNegative) {
            hexadecimal.insert(0, '-');
        }

        return hexadecimal.toString();
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

} // end of the class
