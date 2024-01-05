package TestClasses;

import Controllers.BiasGeneratorController;
import Controllers.IGeneratorController;
import DTOs.BiasGeneratorRequestDTO;
import DTOs.BiasGeneratorResponseDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class TestClass_BiasGeneratorController {
    private IGeneratorController generatorController;

    @Before
    public void setUp(){
        this.generatorController = new BiasGeneratorController();
    }
    @Test
    public void Test_RandomEventFromString(){
        BiasGeneratorRequestDTO requestDTO = new BiasGeneratorRequestDTO();
        String map = "[ {Head: 35}, {Tail: 65} ]";
        requestDTO.setMapAsString(map);
        int headCount = 0;
        for (int i =0;i<1000;i++) {
            BiasGeneratorResponseDTO responseDTO = generatorController.getRandomEventFromString(requestDTO);
            if (responseDTO.getRandomEventName().equals("Head"))
                headCount++;
        }
        //System.out.println(headCount);
        if (headCount >400 || headCount <300)
            Assert.assertEquals(false,true);
        else
            Assert.assertEquals(true,true);
    }
@Test
    public void Test_RandomEventFromMap(){
        BiasGeneratorRequestDTO requestDTO = new BiasGeneratorRequestDTO();
        HashMap<String,Double> map = new HashMap<>();
        map.put("1",10d);map.put("2",30d);map.put("3",15d);map.put("4",15d);map.put("5",30d);map.put("6",0d);
        requestDTO.setMap(map);
        int twoCount = 0, sixCount = 0;
        for (int i =0;i<1000;i++) {
            BiasGeneratorResponseDTO responseDTO = generatorController.getRandomEventFromMap(requestDTO);
            if (responseDTO.getRandomEventName().equals("2"))
                twoCount++;
            else if (responseDTO.getRandomEventName().equals("6"))
                sixCount++;
        }
    System.out.println(sixCount);
        if ((twoCount >350 || twoCount < 250) || sixCount != 0)
            Assert.assertEquals(false,true);
        else
            Assert.assertEquals(true,true);
    }
}
