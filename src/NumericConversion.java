
import java.util.Scanner;

public class NumericConversion {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        boolean runProgram = true; //Boolean to create a while loop that keeps looping till exited by user.

        while(runProgram){ //Start of loop

        //Start of menu//

        System.out.println("Decoding Menu ");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal ");
        System.out.println("4. Quit " + "\n");

            System.out.print("Please enter an option: "); //User will input values at this point
            int menuOption = scnr.nextInt();

            switch(menuOption){  //Switch statement to give an output depending on the option selected by user

                case 1: //converting hexadecimal to binary.

                    System.out.print("Please enter the numeric string to convert: "); //user prompted for numerical string
                    String hexaDec = scnr.next();


                    System.out.println("Result: " + hexStringDecode(hexaDec) + "\n"); //Prints the decimal value obtained from the method call


                    break;

                case 2: // converting binary to decimal

                    System.out.print("Please enter the numeric string to convert: "); //user prompted for numerical string
                    String binaryNum = scnr.next();


                    System.out.println("Result: " + binaryStringDecode(binaryNum) + "\n"); //Prints the decimal value obtained from the method call

                    break;

                case 3: //converting binary to hexadecimal

                    System.out.print("Please enter the numeric string to convert: ");
                    String binaryToHexNum = scnr.next();

                    System.out.println("Result: " + binaryToHex(binaryToHexNum) + "\n"); //Prints the hexadecimal value obtained from the method call

                    break;

                case 4: //quit menu option

                    System.out.println("Goodbye!");
                    runProgram = false; //makes runProgram false which in return causes the program to quit.
                    break;

                default: //If user inputs a value other than 1,2,3,4 then the default output is to ask for a numeric string

                    System.out.println("Please enter the numeric string to convert: " + "\n");
                    break;

            }


        }
    }

    public static  long hexStringDecode(String hex) { //Method 1: This will decode Hexadecimal numbers, convert them to decimal, and return a decimal number

        long deciNum = 0; //declared and initialize deciNum which will be returned by the method
        int i;


            if(hex.startsWith("0x")) { //If input starts with 0x then we will need to create a new substring without it.

                String newHexa = hex.substring(2); //This creates the new substring
                newHexa = newHexa.toUpperCase(); //converts all lower case alphabets to upper case

                for (i = 0; i < newHexa.length(); i++) {

                    char specificVal = newHexa.charAt(i); //getting the charachter at the specified index
                    int charPosition = Character.getNumericValue(specificVal); //getting the position of the first found occurrence of specified characters in a string

                    deciNum = 16 * deciNum + charPosition; //We multiply 16 to deciNum and then add charPosition to get the decimal number
                }
            }

            else {
                hex = hex.toUpperCase();

                for (i = 0; i < hex.length(); i++) { //Similar loop as the one above except hex.length is used as the parameter
                    char specificVal = hex.charAt(i);
                    int charPosition = Character.getNumericValue(specificVal);

                    deciNum = 16 * deciNum + charPosition;

                }
            }


        return deciNum; //returning decimal number.

    }

    public static short binaryStringDecode(String binary) { //Method 2: This will decode binary numbers, convert them to decimal, and return a decimal number

        short deciNum = 0; //declared and initialize deciNum which will be returned by the method
        int i;

        if(binary.startsWith("0b")) {

            String newBinary = binary.substring(2);

            for ( i = 0; i < newBinary.length(); i++) { //for loop to convert binary

                char specificVal = newBinary.charAt(newBinary.length() - 1 - i);  //getting the charachter at the specified index
                int charPosition = Character.getNumericValue(specificVal); //getting the position of the first found occurrence of specified characters in a string

                deciNum += (charPosition * Math.pow(2, i)); //This will calculate the specific value of the decimal number
            }

            }
            else{

            for (i = 0; i < binary.length(); i++) {

                char specificVal = binary.charAt(binary.length() - 1 - i);
                int charPosition = Character.getNumericValue(specificVal);

                deciNum += (charPosition * Math.pow(2, i));
            }
        }

        return deciNum; //return decimal number
    }

    public static String binaryToHex (String binary){ //Method 3: This will decode binary numbers, convert them to hexadecimal, and return a hexadecimal number

        //To make it easy will break this into two steps. First convert binary to decimal and then convert decimal to hexadecimal//

        //used https://introcs.cs.princeton.edu/java/31datatype/Hex2Decimal.java.html for reference//

        StringBuilder hexNum = new StringBuilder();
        String hexChars = "0123456789ABCDEF";
        int hexVal;
        int deciNum = 0;
        int i;

        // Step 1: binary to decimal. We already did this in method 2.

        for (i =0 ; i < binary.length(); i++) {

            char specificValue = binary.charAt(binary.length() - 1 - i);
            int getValue = Character.getNumericValue(specificValue);

            deciNum += (getValue * Math.pow(2, i));
        }

        //Step 2:  decimal to  hex

        for (i = 0; i < deciNum; ++i ){

            hexVal = deciNum % 16;
            hexNum.insert(0, hexChars.charAt(hexVal)); //IntelliJ magically did this when I tried to do hexNum = hexChars.charAt(hexVal) + hexNum; I was getting the same answer regardless
            deciNum /= 16;
        }


        return hexNum.toString();  //converting it to a string and returning value

    }

    public static short hexCharDecode(char digit) {

        short deciNum; //declared and initialize deciNum which will be returned by the method

        digit = Character.toUpperCase(digit);//converts all lower case alphabets to upper case

        if (digit == '0') {
            deciNum = 0;
        } else if (digit == '1') {
            deciNum = 1;
        } else if (digit == '2') {
            deciNum = 2;
        } else if (digit == '3') {
            deciNum = 3;
        } else if (digit == '4') {
            deciNum = 4;
        } else if (digit == '5') {
            deciNum = 5;
        } else if (digit == '6') {
            deciNum = 6;
        } else if (digit == '7') {
            deciNum = 7;
        } else if (digit == '8') {
            deciNum = 8;
        } else if (digit == '9') {
            deciNum = 9;
        } else if (digit == 'A') {
            deciNum = 10;
        } else if (digit == 'B'){
            deciNum = 11;
        } else if (digit == 'C'){
            deciNum = 12;
        } else if (digit == 'D'){
            deciNum = 13;
        }else if (digit == 'E'){
            deciNum = 14;
        }else if (digit == 'F'){
            deciNum = 15;
        }else {
            deciNum = 16;
        }

        return deciNum;
    }

        }








