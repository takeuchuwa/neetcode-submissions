class TimeMap {

    private Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if (!map.containsKey(key)) {
            return res;
        }
        List<Node> values = map.get(key);
        int left = 0;
        int right = values.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Node node = values.get(mid);
            if (node.timestamp <= timestamp) {
                left = mid + 1;
                res = node.value;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    private record Node(int timestamp, String value) {};
}
