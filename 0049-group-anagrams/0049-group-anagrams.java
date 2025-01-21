class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        if (strs.length == 1) {
            List<String> iList = new ArrayList<>();
            iList.add(strs[0]);

            list.add(iList);
            return list;
        }


        for(String st : strs) {
            int[] arr = new int[26];
            for (char ch : st.toCharArray()) {
                arr[ch - 'a']++;
            }

            int hash = buildHash(arr);
            if (map.containsKey(hash)) {
                map.get(hash).add(st);
            } else {
                List<String> iList = new ArrayList<>();
                iList.add(st);

                map.put(hash, iList);
            }
            
        }

        for (int key : map.keySet()) {
            List<String> iList = map.get(key);
            list.add(iList);
        }
        
        return list;
        
    }

    public int buildHash(int[] arr) {
        return Arrays.hashCode(arr);


    }
}