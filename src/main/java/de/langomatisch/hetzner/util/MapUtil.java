package de.langomatisch.hetzner.util;

import java.util.*;

public class MapUtil {

    public static Map<String, String> asMap(String... input) {
        Map<String, String> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>(Arrays.asList(input));
        while(!queue.isEmpty()){
            String poll = queue.poll();
            if(queue.isEmpty()) {
                return map;
            }
            map.put(poll, queue.poll());
        }
        return map;
    }

}
