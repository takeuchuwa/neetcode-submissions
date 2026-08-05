class Solution {
    public boolean confusingNumber(int n) {
        int[] map = new int[10];
        Arrays.fill(map, -1);
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[8] = 8;
        map[9] = 6;
        int result = 0;
        int curr = n;
        while (curr > 0) {
            int number = curr % 10;
            int reverse = map[number];
            if (reverse == -1) {
                return false;
            }

            result *= 10;
            result += reverse;
            curr /= 10;
        }
        System.out.println(result);

        return result != n;
    }
}
