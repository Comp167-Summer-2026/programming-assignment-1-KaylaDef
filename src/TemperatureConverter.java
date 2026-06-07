import java.util.Scanner;

public class TemperatureConverter {

//Kayla Defibaugh COMP167-Summer2026 Due:06/07
    //This program is used to convert basic temperatures. Taking all values and recognizing which ones may be invalid and
    //forcing a reprompt instead of an error that exits the program. Basic conversions are Celsius to Fahrenheit and vice
    //versa. This program displays teh usage of loops with true or false (boolean) values, basics of method creation,
    //conditional statements, variable declarations, scanner usage, and proper,readable formatting.

    public static double convertTemperature(double temperature, String unit) {
        double convertedTemperature = 0.0;
        //C -> F
        unit = unit.toUpperCase();
        if(unit.equals("C")) {
            convertedTemperature = ((temperature * 9/5) + 32);
        }
        //F -> C
        else if(unit.equals("F")) {
            convertedTemperature = ((temperature - 32) * 5 / 9);
        }
        return convertedTemperature;
    }

    //Code for outputs to
    public static void main(String[] args) {
        // Declaring of variables and scanner to be used throughout main.
        Scanner scnr = new Scanner(System.in);
        String tempS;
        String unit;
        Double tempD;
        Double convertedTemp;
        char degreeSymbol = '\u00B0';

        //Initial prompting for temperature value and introduction.
        System.out.println("This is a temperature converter.");
        System.out.println("Please enter a temperature or type \"stop\" to quit.");
        tempS = scnr.nextLine();


        while (!(tempS.toLowerCase().equals("stop"))) {

            //If no value is entered reprompt
            while(tempS.isBlank() || tempS.isEmpty()) {
                System.out.println("Invalid temperature input! Please try again.");
                tempS = scnr.nextLine();
            }

            //
            for (int i = 0; i < tempS.length(); i++) {
                if (Character.isDigit(tempS.charAt(i))
                        || tempS.charAt(i) == '-'
                        || tempS.charAt(i) == '.') {
                    continue;
                } else {
                    System.out.println("Invalid temperature input! Please try again.");
                    tempS = scnr.nextLine();
                }
            }


            //Converting string to double for calculations
            tempD = Double.parseDouble(tempS);


            //Asking for unit
            System.out.println("Please enter a unit: ");
            unit = scnr.nextLine();

            //Loop for invalid unit inputs.
            while(!unit.toUpperCase().equals("C") && !unit.toUpperCase().equals("F")) {
                System.out.println("Invalid unit input! Please try again.");
                unit = scnr.nextLine();
            }

            //Converting temps and outputting properly.
            if (unit.toUpperCase().equals("C") || unit.toUpperCase().equals("F")) {
                convertedTemp = convertTemperature(tempD, unit);

                System.out.print(tempS);
                if(unit.toUpperCase().equals("C")) {
                    System.out.print(degreeSymbol);
                    System.out.printf("C is equal to %.2f", convertedTemp);
                    System.out.println(degreeSymbol + "F");
                }
                else{
                    System.out.print(degreeSymbol);
                    System.out.printf("°F is equal to %.2f", convertedTemp);
                    System.out.println(degreeSymbol + "C");
                }
                System.out.println("______________________");
            }

            //Used so value of temp reloops until stop is input.
            System.out.println();
            System.out.println("Please enter another temperature or type \"stop\" to quit.");
            tempS = scnr.nextLine();
        }

        //Quit message before end of code.
        System.out.println("You have quit, goodbye!");

    }



}



