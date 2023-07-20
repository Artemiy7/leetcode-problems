package easy;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String input) {
        if (input == null || input.length() == 1 || input.isEmpty())
            return false;

        char [] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                stack.push(arr[i]);
            } else if (stack.isEmpty()) {
                return false;
            } else if (arr[i] == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (arr[i] == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (arr[i] == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
