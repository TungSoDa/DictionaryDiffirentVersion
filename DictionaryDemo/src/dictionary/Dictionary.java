package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    Map<String,String> map = new TreeMap<String, String>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
