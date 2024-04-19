package prog2.samcis;

public interface NumberConverter {
    double binaryToDecimal(String binary) throws Exception;
    double octalToDecimal(String octal);
    double hexadecimalToDecimal(String hexadecimal);

    String decimalToBinary(double decimal);
    String decimalToOctal(double decimal);
    String decimalToHexadecimal(double decimal);
}
