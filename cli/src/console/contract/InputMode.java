package console.contract;

import console.Operator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface InputMode {

    Operator parse(String input);

    // TODO: return copy?
    static Map<String, Integer> getKuchenTypes(){
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Kremkuchen", 7);
        map.put("Obstkuchen", 7);
        map.put("Obsttorte", 8);
        return map;
    }
}
