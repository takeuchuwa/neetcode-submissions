class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums2[i], k -> new ArrayList<>()).add(i);
        }
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> indexes = map.get(nums1[i]);
            output[i] = indexes.getLast();
            indexes.removeLast();
        }

        return output;
    }
}
