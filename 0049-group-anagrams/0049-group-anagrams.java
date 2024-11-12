class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        Map<Integer, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            Integer hash = buildHash(strs[i]);

            if (map.containsKey(hash)) {
                map.get(hash).add(strs[i]);
            } else {
                List<String> lt = new ArrayList<>();
                lt.add(strs[i]);
                map.put(hash, lt);
            }
            
            
        }

        list.addAll(map.values());

        return list;
    }

    public Integer buildHash(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray()) {
            int ascii = ch - 'a';
            arr[ascii]++;
        }

        return Arrays.hashCode(arr);
    }
}