class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char a : s.toCharArray()) {
            if (a == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (a == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();

            } else if (a == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();

            } else {
                stack.push(a);
            }   
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
        
        
    }
}