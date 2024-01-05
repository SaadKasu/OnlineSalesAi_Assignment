package Controllers;

import DTOs.BiasGeneratorRequestDTO;
import DTOs.BiasGeneratorResponseDTO;
import Services.BiasGeneratorService;
import Services.IGeneratorService;
import Utility.BiasGeneratorUtility;

import java.util.HashMap;

public class BiasGeneratorController implements IGeneratorController{
    private IGeneratorService generatorService;

    public BiasGeneratorController(){
        this.generatorService = new BiasGeneratorService();
    }

    public BiasGeneratorResponseDTO getRandomEventFromString(BiasGeneratorRequestDTO requestDTO){
         /*

            Converting DTO to String,sending it to service layer and wrapping the response String in DTO.

         */
        String mapAsString = BiasGeneratorUtility.convertRequestDTOToStringMap(requestDTO);
        String randomEventName = generatorService.getRandomEventFromString(mapAsString);
        return BiasGeneratorUtility.convertStringToResponseDTO(randomEventName);
    }
    public BiasGeneratorResponseDTO getRandomEventFromMap(BiasGeneratorRequestDTO requestDTO){
        /*

            Converting DTO to Map,sending it to service layer and wrapping the response String in DTO.

         */

        HashMap<String,Double> map = BiasGeneratorUtility.convertRequestDTOToMap(requestDTO);
        String randomEventName = generatorService.getRandomEventFromMap(map);
        return BiasGeneratorUtility.convertStringToResponseDTO(randomEventName);
    }

}
