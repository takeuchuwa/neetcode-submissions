class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false);
    }

    private boolean validPalindrome(String s, boolean skipped) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (skipped) {
                    return false;
                }
                return validPalindrome(s.substring(left + 1, right + 1), true) ||
                        validPalindrome(s.substring(left, right), true);

            }
            left++;
            right--;
        }

        return true;
    }
}