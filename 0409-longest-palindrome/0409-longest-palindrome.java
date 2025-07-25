class Solution {
    public int longestPalindrome(String s) {
        // all evens + one odd)
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        boolean hasOdd = false;

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : map.keySet()) {
            if (map.get(ch) % 2 == 0) { // if even, blindly add
                answer += map.get(ch);
            } else { // if odd I can use -1 to just use even part
                answer += map.get(ch) - 1;
                hasOdd = true;
            }

        }

        if (hasOdd) {
            answer += 1;
        }

        return answer;
        
    }
}