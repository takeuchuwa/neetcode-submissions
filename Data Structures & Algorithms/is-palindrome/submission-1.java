class Solution {
    public boolean isPalindrome(String s) {
        String altS = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(altS);
        int p1 = 0;
        int p2 = altS.length() - 1;
        while (p1 <= p2) {
            if (altS.charAt(p1) == altS.charAt(p2)) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }

        return true;
    }
}
