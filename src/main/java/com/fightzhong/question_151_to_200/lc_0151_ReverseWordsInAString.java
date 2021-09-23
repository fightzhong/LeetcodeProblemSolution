package com.fightzhong.question_151_to_200;

public class lc_0151_ReverseWordsInAString {
    public String reverseWords(String s) {
        int headBlankCount = 0;
        int tailBlankCount = 0;
        int left = 0;
        int right = s.length() - 1;

        // 计算头部和尾部有多少个空格
        while ( left < right ) {
            if ( s.charAt(left) != ' ' && s.charAt(right) != ' ' ) {
                break;
            }

            if ( s.charAt(left) == ' ' ) {
                headBlankCount ++;
                left ++;
            }

            if ( s.charAt(right) == ' ' ) {
                tailBlankCount ++;
                right --;
            }
        }

        char[] newData = new char[s.length() - headBlankCount - tailBlankCount];
        int dataIndex = newData.length - 1;
        int sIndex = headBlankCount;
        int sEndIndex = s.length() - tailBlankCount - 1;

        while ( sIndex <= sEndIndex ) {
            char c = s.charAt( sIndex );
            // 空格则直接复制
            if ( c == ' ' ) {
                while ( s.charAt( sIndex ) == ' ' ) {
                    sIndex ++;
                }

                newData[dataIndex] = ' ';
                dataIndex --;
            } else {
                // 非空格则计算有几个字符
                int count = 0;
                while ( sIndex <= sEndIndex && s.charAt( sIndex ) != ' ' ) {
                    count ++;
                    sIndex ++;
                }

                dataIndex = dataIndex - count + 1;
                copy( s, sIndex - count, sIndex - 1, newData, dataIndex );
                dataIndex --;
            }
        }

        dataIndex ++;
        return String.valueOf( newData, dataIndex, newData.length - dataIndex );
    }

    private void copy(String s, int left, int right, char[] newData, int index) {
        while ( left <= right ) {
            newData[index ++] = s.charAt( left ++ );
        }
    }
}
