package prog2.samcis;

public class EquivalentNumbers implements NumberConverter{
    String decimalString;
    String binary;
    String octal;

    public String getDecimalString() {
        return decimalString;
    }

    /**
     * One will do this
     * @author....
     *
     * @param decimalString
     */
    public void setDecimalString(String decimalString) {
        this.decimalString = decimalString;
    }

    public String getBinary() {
        return binary;
    }

    /**
     * One will do thiss
     *
     * @author...
     * @param binary
     */
    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getOctal() {
        return octal;
    }

    /**
     * One will do this
     * @author...
     * @param octal
     */
    public void setOctal(String octal) {
        this.octal = octal;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    /**
     * One will do this
     * @author
     * @param hexadecimal
     */
    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    String hexadecimal;

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
    public String decimalToBinary(String decimal) {
        return null;
    }

    @Override
    public String decimalToOctal(String decimal) {
        return null;
    }

    @Override
    public String decimalToHexadecimal(String decimal) {
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
