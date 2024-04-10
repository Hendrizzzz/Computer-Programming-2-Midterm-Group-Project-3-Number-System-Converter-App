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
    public void setBinaryString(String binaryString) {
        this.binaryString = binaryString;
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




    @Override
    public String binaryToDecimal(String binary) {
        return null;
    }

    @Override
    public String binaryToOctal(String binary) {
        return null;
    }

    @Override
    public String binaryToHexadecimal(String binary) {
        return null;
    }

    @Override
    public String octalToBinary(String octal) {
        return null;
    }

    @Override
    public String octalToDecimal(String octal) {
        return null;
    }

    @Override
    public String octalToHexadecimal(String octal) {
        return null;
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

    @Override
    public String hexadecimalToBinary(String hexadecimal) {
        return null;
    }

    @Override
    public String hexadecimalToOctal(String hexadecimal) {
        return null;
    }

    @Override
    public String hexadecimalToDecimal(String hexadecimal) {
        return null;
    }
}
