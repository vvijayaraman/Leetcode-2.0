class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();

        int maxDepth = 0;

        for(char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (ch == ')') {
                stack.pop();
            }

        }

        return maxDepth;

        
    }
}