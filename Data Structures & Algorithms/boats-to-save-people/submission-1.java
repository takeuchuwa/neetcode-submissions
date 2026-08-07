class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            int target = limit - people[r];
            if (people[l] <= target) {
                l++;
            }
            result++;
            r--;
        }

        return result;
    }
}