class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder st = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        for(List<String> ls : knowledge) {
            map.put(ls.get(0), ls.get(1));
        }

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int curr = i + 1;
                StringBuilder inner = new StringBuilder();
                while(curr < s.length() && s.charAt(curr) != ')') {
                    inner.append(s.charAt(curr));
                    curr++;
                }

                if (map.containsKey(inner.toString())) {
                    st.append(map.get(inner.toString()));
                } else {
                    st.append("?");
                }

                i = curr;
            } else {
                st.append(s.charAt(i));
            }
 
        }

        return st.toString();
    }
}