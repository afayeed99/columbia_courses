/* ************************************************
* Abdul Fayeed Abdul Kadir
* aa5042
* March 1st, 2024 (Friday)
* 
* This program converts a zipcode to a barcode and
* vice versa.
*
* Zybook 6.18.22 - 6.18.23 (modified by cannon)
***************************************************/

public class Zipcode{

    private String barCode;
    private String zipCodeNum;
    private String binaryCode;

    public Zipcode(String bar){
        // constructor for converting barcode -> zipcode
        barCode = bar;
        zipCodeNum = "";
        binaryCode = "00000";
        // didn't use binaryCode..., won't affect anything
    }

    // overloading here ...
    public Zipcode(int number){
        // constructor for converting zipcode -> barcode
        // accepting zipcode in 5 digits, convert to barcode in string

        zipCodeNum = Integer.toString(number);
        // opposite of Integer.parseInt("string")
        if (zipCodeNum.length() != 5){ // if zipcode starts with 0
            int lenZipCode = zipCodeNum.length(); 
            // if length 3, need 5 - 3 = 2 leading 0
            zipCodeNum = "0".repeat(5 - lenZipCode) + zipCodeNum;
            // "string".repeat(x) is repeating the string "string" x times
        }
        binaryCode = "00000"; // just to start with
        barCode = "|"; // will always start and end with |
    }

    /*************************************************************************/
    /************ private methods below are for getZipCode method ************/
    private int barWeights(int position){
        // to access the weights to each bar position
        // for use of converting symbols : or | to digits
        // according to formula = sum[num (0 or 1) * weights]

        int weights = -1; // just to initialize, if not cause problems
        if (position == 0){weights = 7;}
        else if (position == 1){weights = 4;}
        else if (position == 2){weights = 2;}
        else if (position == 3){weights = 1;}
        else if (position == 4){weights = 0;}
        return weights;
    }

    private int symbolToBinary(String bar){
        // convert : or | to 0 or 1
        int binary = -1; // just to initialize, if not cause problems
        if (bar.equals(":")){binary = 0;}
        else if (bar.equals("|")){binary = 1;}
        return binary;
    }

    public String getZipcode(){
        barCode = barCode.substring(1, barCode.length() - 6);
        // remove frame and the last 5 symbols - not part of zipcode
        for (int i = 0; i < barCode.length(); i += 5){
            String strGroupOf5 = barCode.substring(i,i+5);
            // when i = 0, i+5 = 5;
            // thus, will pick the first 5 letters in barCode 
            // (for 1 digit in zipcode)
            // when i = 5; i+5 = 10; 
            // will pick the 5th letter up to 9th letter (5 letters), etc...
            int sumWeightFormula = 0; // for each group of 5
            for (int j = 0; j < strGroupOf5.length(); j++){
                int factor = barWeights(j); // to get the weights for zipcode
                String symbol = strGroupOf5.substring(j,j+1); // : or |
                int num01 = symbolToBinary(symbol); // return 0 or 1
                sumWeightFormula += num01 * factor; 
                // return the factor to multiply to 0 or 1 to return the digit
                // according to formula = sum[num (0 or 1) * weights]
            }
            if (sumWeightFormula == 11){zipCodeNum += "0";} // refer to 0
            else{zipCodeNum += Integer.toString(sumWeightFormula);}
        }
        return zipCodeNum;
    }
    /****************** end of methods for getZipcode method *****************/
    /*************************************************************************/

    /*************************************************************************/
    /************ private methods below are for getBarCode method ************/
    private void zipDigit(int digit){ 
        // convert one digit in zipcode to 5 binary digits
        if (digit == 1){binaryCode = "00011";}
        else if (digit == 2){binaryCode = "00101";}
        else if (digit == 3){binaryCode = "00110";}
        else if (digit == 4){binaryCode = "01001";}
        else if (digit == 5){binaryCode = "01010";}
        else if (digit == 6){binaryCode = "01100";}
        else if (digit == 7){binaryCode = "10001";}
        else if (digit == 8){binaryCode = "10010";}
        else if (digit == 9){binaryCode = "10100";}
        else if (digit == 0){binaryCode = "11000";}
    }

    private String binaryToSymbol(String binary){
        // convert 5 binary digits to 5 symbols
        String binString = ""; // String sym = "";
        for (int i = 0; i < binary.length(); i++){
            int binaryDig = Integer.parseInt(binary.substring(i,i+1));
            String sym = addChar(binaryDig); // will decide : or |
            binString += sym; // will have 5 symbols in one string
        }
        // if (binString.length() == 0){System.out.println(binString);}
        return binString;
    }

    private String addChar(int bar){
        // convert 0 or 1 of binary digit to : or |
        String symbol = "";
        if (bar == 0){symbol = ":";}
        else if (bar == 1){symbol = "|";}
        // if (symbol.length() == 0){System.out.println(symbol);}
        return symbol;
    }
        
    private String checkDigitBarCode(String zip){
        // the last 5 barcodes after the first 5 digits
        int sum = 0;
        for (int i = 0; i < zip.length(); i++){
            int oneDigit = Integer.parseInt(zip.substring(i,i+1));
            sum += oneDigit;
        }
        // if (sum == 0){System.out.println(sum);}

        int multiple10 = (int) Math.ceil(sum / 10.0) * 10; 
        // to get the sum to the next multiple of 10
        // if sum = 19, sum / 10.0 = 1.9, ceil(1.9) = 2.0
        // cast int 2.0 = 2, 2*10 = 20
        int checkDigit = multiple10 - sum; // the needed # to add to sum
        // System.out.println(multiple10);
        // System.out.println(checkDigit);
        zipDigit(checkDigit); // to obtain the binaryCode for the checkDigit
        return binaryToSymbol(binaryCode);// converted checkDigit to 5 symbols
    }

    public String getBarcode(){
        for (int i = 0; i < zipCodeNum.length(); i++){
            int oneDigit = Integer.parseInt(zipCodeNum.substring(i,i+1));
            zipDigit(oneDigit); // to have the correct binaryCode -> symbols
            barCode += binaryToSymbol(binaryCode); 
            // converted one digit to 5 symbols
        }
        barCode = barCode + checkDigitBarCode(zipCodeNum) + "|"; 
        // frst 5 digit + the checkdigit + | the last frame
        return barCode;
    }
    /****************** end of methods for getBarCode method *****************/
    /*************************************************************************/
} // end class