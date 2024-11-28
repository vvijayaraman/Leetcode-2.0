class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if (stack.peek() == ch) {
                while(!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }

        }

        StringBuilder st = new StringBuilder();

        while(!stack.isEmpty()) {
            st.append(stack.pop());
        }

        return st.reverse().toString();

        
    }
} 