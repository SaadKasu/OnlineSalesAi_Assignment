package Controllers;

import DTOs.BiasGeneratorRequestDTO;
import DTOs.BiasGeneratorResponseDTO;

public interface IGeneratorController {
    public BiasGeneratorResponseDTO getRandomEventFromString(BiasGeneratorRequestDTO requestDTO);
    public BiasGeneratorResponseDTO getRandomEventFromMap(BiasGeneratorRequestDTO requestDTO);
}
