class Solution {
    public int compress(char[] chars) {
        int lastIndex = -1;
        StringBuilder st = new StringBuilder();

        for(int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            int ptr = i;
            int occurences = 0;

            while(ptr < chars.length && curr == chars[ptr]) {
                ptr++;
                occurences++;
            }

            if (occurences > 1) {
                st.append(curr).append(occurences);
            } else {
                st.append(curr);
            }

             i = ptr - 1;
        
        }

        String output = st.toString();
        for(int i = 0; i < output.length(); i++) {
            chars[i] = output.charAt(i);
        }

        return output.length();
      
        
    }
}