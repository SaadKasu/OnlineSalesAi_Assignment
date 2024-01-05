package Client;

import Controllers.BiasGeneratorClientController;

import java.util.HashMap;
import java.util.Scanner;

public class BiasGeneratorClient {
    public static void main(String[] args) {
         /*

            Main method to run the code

         */
        BiasGeneratorClientController clientController = new BiasGeneratorClientController();
        Scanner takeInput = new Scanner(System.in);
        System.out.print("Do you want to give input as a string ? (Y/N) - ");
        String input = takeInput.nextLine();
        if (input.equals("Y")){
             /*

                Give input as String map

            */
            System.out.print("Input - ");
            String inputString = takeInput.nextLine();
            System.out.println(clientController.getRandomEventByString(inputString));
        }
        else if (input.equals("N")){
            /*

                Hardcode hashmap values.

            */
            HashMap<String,Double> map = new HashMap<>();
            map.put("1",10d);map.put("2",30d);map.put("3",15d);map.put("4",15d);map.put("5",30d);map.put("6",0d);
            System.out.println(clientController.getRandomEventByMap(map));
        }
        else{
            System.out.println("Please enter a valid input.");
        }
    }
}
