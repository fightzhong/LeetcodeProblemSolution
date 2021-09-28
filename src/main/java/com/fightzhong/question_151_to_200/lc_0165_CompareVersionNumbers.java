package com.fightzhong.question_151_to_200;

public class lc_0165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;

        while ( index1 < version1.length() || index2 < version2.length() ) {
            int v1 = 0;
            int v2 = 0;

            if ( index1 < version1.length() ) {
                int pointIndex = version1.indexOf( ".", index1 );
                String childVersion = pointIndex == -1 ? version1.substring( index1 ) : version1.substring( index1, pointIndex );
                v1 = Integer.parseInt( childVersion );
                index1 = pointIndex == -1 ? version1.length() : pointIndex + 1;
            }

            if ( index2 < version2.length() ) {
                int pointIndex = version2.indexOf( ".", index2 );
                String childVersion = pointIndex == -1 ? version2.substring( index2 ) : version2.substring( index2, pointIndex );
                v2 = Integer.parseInt( childVersion );
                index2 = pointIndex == -1 ? version2.length() : pointIndex + 1;
            }

            if ( v1 - v2 != 0 ) {
                return v1 < v2 ? -1 : 1;
            }
        }

        return 0;
    }
}
