package Controllers;

import DTOs.BiasGeneratorRequestDTO;
import DTOs.BiasGeneratorResponseDTO;
import Utility.BiasGeneratorUtility;

import java.util.HashMap;
import java.util.Scanner;

public class BiasGeneratorClientController {
    private IGeneratorController controller;

    public BiasGeneratorClientController(){
        this.controller = new BiasGeneratorController();
    }

    public String getRandomEventByString(String input){
        /*

            Used to convert String map to DTO following MVC convention.

         */
        BiasGeneratorRequestDTO requestDTO = BiasGeneratorUtility.convertStringToRequestDTO(input);
        BiasGeneratorResponseDTO responseDTO = controller.getRandomEventFromString(requestDTO);
        return BiasGeneratorUtility.convertResponseDTOToString(responseDTO);
    }

    public String getRandomEventByMap(HashMap<String,Double> inputMap){
        /*

            Used to convert Hash map to DTO following MVC convention.

         */
        BiasGeneratorRequestDTO requestDTO = BiasGeneratorUtility.convertMapToRequestDTO(inputMap);
        BiasGeneratorResponseDTO responseDTO = controller.getRandomEventFromMap(requestDTO);
        return BiasGeneratorUtility.convertResponseDTOToString(responseDTO);
    }

}
