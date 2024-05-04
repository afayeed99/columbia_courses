/*
*  This program will indicate if a card number is valid or not.
*  
*  name: Abdul Fayeed Abdul Kadir
*  uni: aa5042
*  date: Feb 16th, 2024 (Friday)
* 
*  credit card number to check each checki()
*  Valid: 4094-3460-2754 or 4807-6052-1766 
*  Violates Rule 1: 5807-6052-1766
*  Violates Rule 2: 4151-6052-1766
*  Violates Rule 3 :4917-6052-2776  
*  Violates Rule 4: 4807-6052-1764
*  Violates Rule 5: 4843-2444-3215
*  Violates Rule 6: 4603-2012-3083
*/

public class CreditCard{

    private String cardNumber;
    private boolean validCard;
    private int errorCode;

    public CreditCard(String num){
        cardNumber = num;
        validCard = true; // beginning
        errorCode = 0; // at beginning
    }

    private void check1(){
        // The first digit must be a 4.
        int firstDigit = Integer.parseInt(cardNumber.substring(0,1));

        if (firstDigit != 4){
            validCard = false;
            errorCode = 1;
        }
    }

    private void check2(){
        // The fourth digit must be one greater than the fifth digit
        int fourthDigit = Integer.parseInt(cardNumber.substring(3,4));
        int fifthDigit = Integer.parseInt(cardNumber.substring(5,6));

        if (fourthDigit != fifthDigit + 1){
            validCard = false;
            errorCode = 2;
        }
    }

    private void check3(){
        // The product of the first, fifth, and ninth digits must be 24
        int firstDigit = Integer.parseInt(cardNumber.substring(0,1));
        int fifthDigit = Integer.parseInt(cardNumber.substring(5,6)); // no -
        int ninthDigit = Integer.parseInt(cardNumber.substring(10,11)); // no -

        if (firstDigit * fifthDigit * ninthDigit != 24){
            validCard = false;
            errorCode = 3;
        }
    }

    private void check4(){ //sum of all digits must be evenly divisible by 4
        int numLen = cardNumber.length(); int idxStr; int sum = 0;
        for (idxStr = 0; idxStr < numLen; idxStr++){
            if (!((cardNumber.substring(idxStr,idxStr+1)).equals("-"))){
                int digit = Integer.parseInt
                            (cardNumber.substring(idxStr,idxStr+1));
                sum += digit;
            }
        }
        if (sum % 4 != 0){ // if not divisible by 4
            validCard = false;
            errorCode = 4;
        }
    }

    private void check5(){ // sum first4 digits = sum last4 digits - 1
        int numLen = cardNumber.length(); int idxStr; 
        int sumFirst4 = 0; int sumLast4 = 0;
        String first4 = cardNumber.substring(0,4);
        String last4 = cardNumber.substring(numLen - 4, numLen); // last 4
        for (idxStr = 0; idxStr < first4.length(); idxStr++){
            int digFirst = Integer.parseInt(first4.substring(idxStr,idxStr+1));
            int digLast = Integer.parseInt(last4.substring(idxStr,idxStr+1));
            sumFirst4 += digFirst; sumLast4 += digLast;
        }
        if (sumFirst4 != sumLast4 - 1){
            validCard = false; errorCode = 5;
        }
    }

    private void check6(){// 1st 2 digit + (7th and 8th digit) == 100
        int firstNum = Integer.parseInt(cardNumber.substring(0,2));
        int secNum = Integer.parseInt(cardNumber.substring(7,9));// no -

        if (firstNum + secNum != 100){
            validCard = false;
            errorCode = 6;
        }
    }

    public void check(){
        check1();
        // if check1 is valid, errorCode still 0
        if (errorCode == 0){check2();}
        // if check2 still valid, and so on...
        if (errorCode == 0){check3();}
        if (errorCode == 0){check4();}
        if (errorCode == 0){check5();}
        if (errorCode == 0){check6();}         
    }
         
    public boolean isValid(){
        return validCard;
    }

    public int getErrorCode(){
        return errorCode;
    }
}