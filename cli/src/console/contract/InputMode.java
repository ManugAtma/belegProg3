package console.contract;

import console.Command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface InputMode {

    Command parseCommand(String input);

    static Map<String, Integer> getKuchenTypes(){
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Kremkuchen", 7);
        map.put("Obstkuchen", 7);
        map.put("Obsttorte", 8);
        return map;
    }
}
