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
     * One will do thiss
     *
     * @author...
     * @param binaryString
     */
    public void setBinaryString(String binaryString) throws Exception {
        this.binaryString = binaryString;
        decimal = binaryToDecimal(binaryString);
        //octalString = Integer.toOctalString(decimal);
        //hexadecimalString = Integer.toHexString(decimal);
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
     * @param binary number in String
     * @return decimal in Integer type.
     */
    @Override
    public int binaryToDecimal(String binary) throws Exception {
        int result = 0;
        if (!isValidBinaryString(binary))
            throw new Exception("Invalid Binary Number");
        for (int i = 0; i < binary.length(); i++) {
            result += (int) (Integer.parseInt("" + binary.charAt(i)) * Math.pow(2, (int) (binary.length() - 1 - i)));
        }
        return 0;
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
     * The method uses a for-loop to check each character of the binary string.
     * If one of the character of the binary string is other than '1' or '2', the method will return false.
     *
     * @author Oliver Yu
     * @param binaryString to be verified.
     * @return true if the binaryString is a valid binary number. Otherwise, false.
     */
    private boolean isValidBinaryString(String binaryString) {
        boolean result = true;
        for (int index = 0; index < binaryString.length(); index++) {
            if (binaryString.charAt(index) != '0' && binaryString.charAt(index) != '1') {
                result = false;
                break;
            }
        }
        return result;
    }
}
