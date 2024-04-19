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




    public String getHexadecimalString() {
        return hexadecimalString;
    }

    /**
     * One will do this
     * @author
     * @param hexadecimalString
     */
    public void setHexadecimalString(String hexadecimalString) {
        this.hexadecimalString = hexadecimalString;
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
        return 0;
    }

    @Override
    public String decimalToBinary(double decimal) {
        StringBuilder binary = new StringBuilder();
        int intPart = (int) decimal;
        double fracPart = decimal - intPart;

        if (intPart == 0) {
            binary.append(0);
        } else {
            while (intPart > 0) {
                binary.insert(0, intPart % 2);
                intPart /= 2;
            }
        }

        // Add decimal point
        if (fracPart > 0) {
            binary.append('.');
        }

        while (fracPart > 0) {
            fracPart *= 2;
            int bit = (int) fracPart;
            binary.append(bit);
            fracPart -= bit;
        }

        return binary.toString();
    }

    @Override
    public String decimalToOctal(double decimal) {
        if (octalString == null) {
            return Integer.toOctalString((int) decimal);
        } else {
            if (decimal != Integer.parseInt(octalString, 8)) {
                return Integer.toOctalString((int) decimal);
            } else {
                return octalString;
            }
        }
    }
    @Override
    public String decimalToHexadecimal(double decimal) {
        if (hexadecimalString == null) {
            return Integer.toHexString((int) decimal).toUpperCase();
        } else {
            if (decimal != Integer.parseInt(hexadecimalString, 16)) {
                return Integer.toHexString((int) decimal).toUpperCase();
            } else {
                return hexadecimalString;
            }
        }
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

