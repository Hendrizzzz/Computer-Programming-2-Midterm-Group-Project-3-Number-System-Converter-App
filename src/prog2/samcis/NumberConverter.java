package prog2.samcis;

public interface NumberConverter {
    int binaryToDecimal(String binary) throws Exception;
    int octalToDecimal(String octal);
    int hexadecimalToDecimal(String hexadecimal);

    String decimalToBinary(double decimal);
    String decimalToOctal(double decimal);
    String decimalToHexadecimal(double decimal);

}
