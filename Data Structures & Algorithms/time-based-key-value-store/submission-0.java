class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.computeIfAbsent(key, k -> new TreeMap<>());
        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values = map.get(key);
        if (values == null) {
            return "";
        }

        Integer valueKey = values.floorKey(timestamp);
        return valueKey != null ? values.get(valueKey) : "";
    }

     
}
