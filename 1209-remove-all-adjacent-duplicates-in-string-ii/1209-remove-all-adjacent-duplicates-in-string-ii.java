class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Node> stack = new Stack<>();
        for(char ch : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(new Node(ch, 1));
                continue;
            }

            if (stack.peek().ch == ch) {
                stack.push(new Node(ch, stack.peek().count + 1));
            } else {
                stack.push(new Node(ch, 1));
            }

            if (stack.peek().count == k) {
                for(int i = 0; i < k; i++) {
                    stack.pop();
                }
            }

        }

        StringBuilder st = new StringBuilder();

        while(!stack.isEmpty()) {
            st.append(stack.pop().ch);
        }


        return st.reverse().toString();

        
        
    }

    public class Node {
        public char ch;
        public int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
        
    }
}