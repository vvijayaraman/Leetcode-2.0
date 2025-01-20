class Solution {
    public int maxPower(String s) {
        char currChar = s.charAt(0);
        int max = 1;

        int left = 0;
        int right = 1;

        while(right < s.length()) {
            if (currChar == s.charAt(right)) {
                right++;
            } else {
                currChar = s.charAt(right);
                left = right;
            }

            max = Math.max(max, right - left);
        }

        return max;
        
    }
}