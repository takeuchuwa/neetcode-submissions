class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> treeMap = map.computeIfAbsent(key, k -> new ArrayList<>());
        treeMap.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer, String>> values = map.get(key);
        int left = 0;
        int right = values.size() - 1;
        Pair<Integer, String> res = null;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair<Integer, String> pair = values.get(mid);
            if (pair.getKey() <= timestamp) {
                left = mid + 1;
                res = pair;
            } else {
                right = mid - 1;
            }
        }

        return res != null ? res.getValue() : "";
    }

     
}
