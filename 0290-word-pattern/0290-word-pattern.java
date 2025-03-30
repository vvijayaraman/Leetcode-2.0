class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");

        if (split.length != pattern.length()) {
            return false;
        }

        int index = 0;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();


        for(char ch : pattern.toCharArray()) {
            if (!map.containsKey(ch) && !reverseMap.containsKey(split[index])) {
                map.put(ch, split[index]);
                reverseMap.put(split[index], ch);
                index++;
            } else {
                if (!map.containsKey(ch) || !map.get(ch).equals(split[index]) || !reverseMap.containsKey(split[index]) || reverseMap.get(split[index]) != ch) {
                    return false;
                }

                index++;
            }
         
            
        }

        return true;

        
    }
}