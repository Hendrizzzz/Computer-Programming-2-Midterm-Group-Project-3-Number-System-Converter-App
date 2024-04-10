package prog2.samcis;

public class NumberConverterBoard {
















  // nasa loob to ng NumberConverterBoard, lagay mo nalang sa pinakahuli
      /**
     * ActionListener for handling button clicks in the Number Converter application.
     *
     * @author Bag-eo, Jim Hendrix
     */
    private class ButtonsHandler implements ActionListener {

        /**
         * Handles button clicks.
         *
         * @param e The ActionEvent triggered by button click.
         */
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exitButton){
                System.exit(0); // Exit the application if the exitButton is clicked
            }
            if (e.getSource()== clearButton){
                // Clear text fields if the clearButton is clicked
                decimalTF.setText("");
                binaryTF.setText("");
                octalTF.setText("");
                hexadecimalTF.setText("");
                problemDisplayer.setText("");
            }
            if (e.getSource()== convertButton)
                try{
                    number = new EquivalentNumbers(); // Create an instance of EquivalentNumbers

                    // Check which conversion is requested and perform the conversion accordingly
                    if (!decimalTF.getText().isEmpty() && binaryTF.getText().isEmpty() && octalTF.getText().isEmpty() && hexadecimalTF.getText().isEmpty()){
                        convertDecimal(number); // Convert decimal number to other number systems
                    } else if (decimalTF.getText().isEmpty() && !binaryTF.getText().isEmpty() && octalTF.getText().isEmpty() && hexadecimalTF.getText().isEmpty()){
                        convertBinary(number); // Convert binary number to other number systems
                    } else if (decimalTF.getText().isEmpty() && binaryTF.getText().isEmpty() && !octalTF.getText().isEmpty() && hexadecimalTF.getText().isEmpty()){
                        convertOctal(number); // Convert octal number to other number systems
                    } else if (decimalTF.getText().isEmpty() && binaryTF.getText().isEmpty() && octalTF.getText().isEmpty() && !hexadecimalTF.getText().isEmpty()){
                        convertHexadecimal(number); // Convert hexadecimal number to other number systems
                    }else {
                        // Display an error message if more than one number system is entered or none is entered
                        problemDisplayer.setText("Please enter a value on exactly one number system to convert.");
                        return;
                    }

                    // Clear any previous error messages
                    problemDisplayer.setText("");
                } catch (NumberFormatException x ){
                    problemDisplayer.setText("One of the numbers does not follow the format of a number.");
                } catch (Exception e2){
                    problemDisplayer.setText("The input does not follow the format of the Number System");
                }
        }


        /**
         * Converts a decimal number to binary, octal, and hexadecimal.
         *
         * @param number The EquivalentNumbers object to perform the conversion.
         */
        private void convertDecimal(EquivalentNumbers number) {
            number.setDecimalNumber(Float.parseFloat(decimalTF.getText()));
            binaryTF.setText(number.getBinaryString());
            octalTF.setText(number.getOctalString());
            hexadecimalTF.setText(NumberConverterBoard.this.number.getHexadecimalString());
        }


        /**
         * Converts a binary number to decimal, octal, and hexadecimal.
         *
         * @param number The EquivalentNumbers object to perform the conversion.
         * @throws Exception if the binary number is invalid.
         */
        private void convertBinary(EquivalentNumbers number) throws Exception {
            number.setBinaryNumber(binaryTF.getText());
            decimalTF.setText(String.valueOf(number.getDecimalNumber()));
            octalTF.setText(number.getOctalString());
            hexadecimalTF.setText(number.getHexadecimalString());
        }

        /**
         * Converts an octal number to decimal, binary, and hexadecimal.
         *
         * @param number The EquivalentNumbers object to perform the conversion.
         * @throws Exception if the octal number is invalid.
         */
        private void convertOctal(EquivalentNumbers number) throws Exception {
            number.setOctalNumber(octalTF.getText());
            binaryTF.setText(number.getBinaryString());
            decimalTF.setText(String.valueOf(number.getDecimalNumber()));
            hexadecimalTF.setText(number.getHexadecimalString());
        }

        /**
         * Converts a hexadecimal number to decimal, binary, and octal.
         *
         * @param number The EquivalentNumbers object to perform the conversion.
         * @throws Exception if the hexadecimal number is invalid.
         */
        private void convertHexadecimal(EquivalentNumbers number) throws Exception {
            number.setHexadecimalString(hexadecimalTF.getText());
            binaryTF.setText(number.getBinaryString());
            octalTF.setText(number.getOctalString());
            decimalTF.setText(String.valueOf(number.getDecimalNumber()));
        }

    } // end of the inner class -> ButtonsHandler
  
} // end of the outer class -> NumberConverterBoard
