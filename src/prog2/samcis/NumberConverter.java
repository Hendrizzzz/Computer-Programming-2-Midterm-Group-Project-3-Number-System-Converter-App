package prog2.samcis;

public interface NumberConverter {
    String binaryToDecimal(String binary);
    String binaryToOctal(String binary);
    String binaryToHexadecimal(String binary);

    String octalToBinary(String octal);
    String octalToDecimal(String octal);
    String octalToHexadecimal(String octal);

    String decimalToBinary(double decimal);
    String decimalToOctal(double decimal);
    String decimalToHexadecimal(double decimal);

    String hexadecimalToBinary(String hexadecimal);
    String hexadecimalToOctal(String hexadecimal);
    String hexadecimalToDecimal(String hexadecimal);
}
