package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.List;

public class lc_0093_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = restoreIpAddresses( s, 0, 4 );

        return result == null ? new ArrayList<>() : result;
    }

    private List<String> restoreIpAddresses(String s, int curIndex, int count) {
        if ( count == 0 ) {
            return curIndex < s.length() ? null : new ArrayList<>();
        } else if ( curIndex >= s.length() ) {
            return null;
        }

        List<String> result = new ArrayList<>();

        // 结果1
        char c = s.charAt( curIndex );
        List<String> r1 = restoreIpAddresses( s, curIndex + 1, count - 1 );
        mergeResult( r1, String.valueOf( c ), result );

        if ( c != '0' ) {
            if ( curIndex + 1 < s.length() ) {
                // 结果2
                List<String> r2 = restoreIpAddresses( s, curIndex + 2, count - 1 );
                mergeResult( r2, s.substring( curIndex, curIndex + 2 ), result );
            }

            // 结果3
            if ( curIndex + 2 < s.length() ) {
                int v = Integer.parseInt( s.substring( curIndex, curIndex + 3 ) );
                if ( v <= 255 ) {
                    List<String> r3 = restoreIpAddresses( s, curIndex + 3, count - 1 );
                    mergeResult( r3, s.substring( curIndex, curIndex + 3 ), result );
                }
            }
        }

        return result.size() == 0 ? null : result;
    }

    private void mergeResult(List<String> data, String curStr, List<String> result) {
        if ( data == null ) {
            return;
        } else if ( data.size() == 0 ) {
            result.add( curStr );
        } else {
            for ( String s: data ) {
                result.add( curStr + "." + s );
            }
        }
    }
}
