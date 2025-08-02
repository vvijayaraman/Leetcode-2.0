class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String st : strs) {
            int hashCode = buildHash(st);

            if (map.containsKey(hashCode)) {
                map.get(hashCode).add(st);
            } else {
                map.put(hashCode, new ArrayList<>());
                map.get(hashCode).add(st);

            }

        }

        return new ArrayList<>(map.values());
        
    }

    public int buildHash(String input) {
       int[] arr = new int[26];
       for(char ch : input.toCharArray()) {
        arr[ch - 'a']++;
       }

       return Arrays.hashCode(arr);
    }
}