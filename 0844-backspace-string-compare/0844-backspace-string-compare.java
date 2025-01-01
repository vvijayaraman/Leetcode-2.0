class Solution {
    public boolean backspaceCompare(String s, String t) {
        String first = buildString(s);
        String second = buildString(t);

        return first.equals(second);
        
    }

    private String buildString(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if (ch != '#') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
        
    }
    
}