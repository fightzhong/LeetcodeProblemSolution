package com.fightzhong.question_1_to_50;

import java.util.Stack;

public class lc_0020_ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for ( int i = 0; i < s.length(); i ++ ) {
            char curChar = s.charAt( i );
            if ( curChar == '(' || curChar == '{' || curChar == '[' ) {
                stack.push( curChar );
            } else if ( stack.size() == 0 ||
                    (curChar == ')' && stack.peek() != '(') ||
                    (curChar == '}' && stack.peek() != '{') ||
                    (curChar == ']' && stack.peek() != '[') ) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
