package Services;

import java.util.HashMap;

public class BiasGeneratorService implements IGeneratorService{
    @Override
    public String getRandomEventFromString(String mapInput) {

        /*

            Converting the string format map to an actual map.

         */

        mapInput = mapInput.replaceAll(" ","");
        String probabilities = mapInput.substring(1,mapInput.length() - 1);
        HashMap<String,Double> probabilityMap = new HashMap<>();
        double totalProbability = 0;
        for (String probability : probabilities.split(",")){
            probability = probability.substring(1,probability.length() - 1);
            String [] keyValuePair = probability.split(":");
            double bias = Double.parseDouble(keyValuePair[1]);
            totalProbability += bias;
            probabilityMap.put(keyValuePair[0],bias);
        }
        if ((int)totalProbability == 100 || (int)totalProbability == 1)
            return getRandomEventFromMap(probabilityMap);
        return "Please enter a valid input. Probabilities don't add up to 100";
    }

    @Override
    public String getRandomEventFromMap(HashMap<String, Double> probabilityMap) {

        /*

            Setting the probability bias for different weightages and using random to get a random value.

         */

        String [] eventsBasedOnProbability = new String[100];
        int index = 0;
        for (String event : probabilityMap.keySet()){
            double probabilityValue = probabilityMap.get(event);
            int occurence = probabilityValue < 1 ? (int)(probabilityValue * 100) : (int)probabilityValue;
            for (int i =index;i< index + occurence;i++){
                eventsBasedOnProbability[i] = event;
            }
            index += occurence;
        }
        int randomNumber = (int)(Math.floor(Math.random()*100));
        randomNumber = randomNumber == 100 ? randomNumber - 1 : randomNumber;

        return eventsBasedOnProbability[randomNumber];
    }
}
