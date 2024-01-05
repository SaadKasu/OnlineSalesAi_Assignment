package DTOs;

import java.util.HashMap;

public class BiasGeneratorRequestDTO {
    private String mapAsString;
    private HashMap<String, Double> map;
    public void setMapAsString(String mapAsString){
        this.mapAsString = mapAsString;
    }
    public String getMapAsString(){
        return this.mapAsString;
    }

    public void setMap(HashMap<String,Double> map){
        this.map = map;
    }
    public HashMap<String, Double> getMap(){
        return this.map;
    }
}
