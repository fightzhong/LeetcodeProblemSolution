package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc_0071_SimplifyPath {
    public static void main(String[] args) {
        new lc_0071_SimplifyPath().simplifyPath( "/a//b////c/d//././/.." );
    }

    public String simplifyPath(String path) {
        String[] pathArr = path.split( "/" );
        LinkedList<String> data = new LinkedList<>();
        for ( int i = 1; i < pathArr.length; i ++ ) {
            String singlePath = pathArr[i];
            if ( singlePath.equals( ".." ) ) {
                if ( data.size() > 0 ) {
                    data.removeLast();
                }
            } else if ( !singlePath.equals( "." ) && singlePath.length() > 0 ) {
                data.add(singlePath);
            }
        }

        StringBuilder result = new StringBuilder("/");
        boolean find = false;
        for ( String r: data ) {
            result.append(r).append("/");
            find = true;
        }

        if ( find ) {
            result.deleteCharAt( result.length() - 1 );
        }

        return result.toString();
    }
}
