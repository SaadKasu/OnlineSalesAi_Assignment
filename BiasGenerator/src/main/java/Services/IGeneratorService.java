package Services;

import java.util.Date;
import java.util.HashMap;

public interface IGeneratorService {
    public String getRandomEventFromString(String mapInput);
    public String getRandomEventFromMap(HashMap<String, Double> probabilityMap);
}
