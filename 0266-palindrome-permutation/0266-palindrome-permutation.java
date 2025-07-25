class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean hasOddUsed = false;

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch: map.keySet()) {
            if (map.get(ch) % 2 == 0) {
                continue;
            } else {
                if (hasOddUsed) {
                    return false;
                } else {
                    hasOddUsed = true;
                }
            }
        }

        return true;




        
    }
}