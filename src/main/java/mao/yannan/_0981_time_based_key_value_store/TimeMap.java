package mao.yannan._0981_time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    private final Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        return binarySearch(map.get(key), timestamp);
    }

    private static String binarySearch(List<Data> list, int timestamp) {
        var left = 0;
        var right = list.size() - 1;
        while (left < right) {
            var mid = (left + right + 1) >> 1;
            if (timestamp < list.get(mid).timestamp()) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return list.get(left).timestamp() <= timestamp ? list.get(left).value : "";
    }

    private record Data(String value, int timestamp) {}
}
