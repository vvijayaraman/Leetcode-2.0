class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        for char in s:
            if len(stack) == 0:
                stack.append(char)
                continue
                
            if char is ']':
                if stack[-1] != '[':
                    return False
                stack.pop()    
            elif char is '}':
                if stack[-1] != '{':
                    return False
                stack.pop()
            elif char is ')':
                if stack[-1] != '(':
                    return False        
                stack.pop()
            else:
                stack.append(char)    

        return len(stack) == 0        

