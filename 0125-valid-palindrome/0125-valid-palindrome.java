class Solution {
    public boolean isPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;

        while(left < right) {
            while (!Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left)) && left < right) {
                left++;
            }

            while (!Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right)) && left < right) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }

        return true;

        
    }
}