package Utility;

import DTOs.BiasGeneratorRequestDTO;
import DTOs.BiasGeneratorResponseDTO;

import java.util.HashMap;

public class BiasGeneratorUtility {
    public static String convertRequestDTOToStringMap(BiasGeneratorRequestDTO requestDTO){
        return requestDTO.getMapAsString();
    }

    public static HashMap<String,Double> convertRequestDTOToMap(BiasGeneratorRequestDTO requestDTO){
        return requestDTO.getMap();
    }
    public static BiasGeneratorResponseDTO convertStringToResponseDTO(String randomEventName){
        BiasGeneratorResponseDTO responseDTO = new BiasGeneratorResponseDTO();
        responseDTO.setRandomEventName(randomEventName);
        return responseDTO;
    }

    public static BiasGeneratorRequestDTO convertStringToRequestDTO(String stringMap){
        BiasGeneratorRequestDTO requestDTO = new BiasGeneratorRequestDTO();
        requestDTO.setMapAsString(stringMap);
        return requestDTO;
    }

    public static String convertResponseDTOToString(BiasGeneratorResponseDTO responseDTO){
        return responseDTO.getRandomEventName();
    }

    public static BiasGeneratorRequestDTO convertMapToRequestDTO(HashMap<String,Double> inputMap){
        BiasGeneratorRequestDTO requestDTO = new BiasGeneratorRequestDTO();
        requestDTO.setMap(inputMap);
        return requestDTO;
    }
}
