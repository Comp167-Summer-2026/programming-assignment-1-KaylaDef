import java.util.Scanner;

public class TemperatureConverter {


    public static double convertTemperature(double temperature, String unit) {
        double convertedTemperature = 0.0;
        //C -> F
        unit = unit.toUpperCase();
        if(unit.equals("C")) {
            convertedTemperature = ((temperature * 5/9) + 32);
        }
        //F -> C
        else if(unit.equals("F")) {
            convertedTemperature = ((temperature - 32) * 5 / 9);
        }
        return convertedTemperature;
    }

    public static void main(String[] args) {
        Scanner scnr = new  Scanner(System.in);
        String tempS;
        String unit;
        Double tempD;
        Double convertedTemp;

        System.out.println("This is a temperature converter.");
        System.out.println("Please enter a temperature or type \"stop\" to quit.");
        tempS = scnr.nextLine();

        if(tempS.toLowerCase().equals("stop")){
            System.out.println("You have quit, goodbye!");
        }
        else {
            for(int i = 0; i < tempS.length(); i++){
                if(Character.isDigit(tempS.charAt(i))
                        || tempS.charAt(i) == '-'
                        || tempS.charAt(i) == '.'){
                    continue;
                }
                else{
                    System.out.println("Invalid temperature input! Please try again.");
                    tempS = scnr.nextLine();
                }
            }

            tempD = Double.parseDouble(tempS);
            System.out.println("Please enter a unit: ");
            unit = scnr.nextLine();

            //check again after fix
            if(unit.toUpperCase().equals("C") || unit.toUpperCase().equals("F")){
                System.out.println("Conversion beginning");
                System.out.printf("%.2f%n",tempD);
                convertedTemp = convertTemperature(tempD, unit);
                System.out.printf("%.2f%n", convertedTemp);
            }
            else{
                System.out.println("Invalid unit input! Please try again.");
                unit = scnr.nextLine();
                //FIXME - doesnt get new value and loop
            }

        }
        System.out.println("done");


    }


}
