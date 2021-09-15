package com.fightzhong.question_101_to_150;

import java.util.LinkedList;

public class lc_0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for ( String token: tokens ) {
            if ( token.equals( "+" ) || token.equals( "-" ) || token.equals( "*" ) || token.equals( "/" ) ) {
                int i1 = stack.removeLast();
                int i2 = stack.removeLast();
                if ( token.equals( "+" ) ) {
                    stack.addLast( i1 + i2 );
                } else if ( token.equals( "-" ) ) {
                    stack.addLast( i2 - i1  );
                } else if ( token.equals( "*" ) ) {
                    stack.addLast( i1 * i2 );
                } else {
                    stack.addLast( i2 / i1 );
                }
            } else {
                stack.addLast( Integer.parseInt( token ) );
            }
        }

        return stack.removeLast();
    }
}
