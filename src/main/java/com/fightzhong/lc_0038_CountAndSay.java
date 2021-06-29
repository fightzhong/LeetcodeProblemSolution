package com.fightzhong;

/**
 * 这道题。。。。特么leetcode最大数据量为30, 直接用枚举把30个以内的数据放数组, 然后O(1)时间复杂度能解出来,
 * 给我人看傻了。。。。。
 */
public class lc_0038_CountAndSay {
    public String countAndSay(int n) {
        String pre = "1";
        for ( int i = 2; i <= n; i ++ ) {
            System.out.println(pre);
            pre = getStr(pre);
        }

        return pre;
    }

    private String getStr(String pre){
        StringBuilder builder = new StringBuilder();
        int index = 1;
        int count = 1;
        char curChar = pre.charAt(0);
        while (index < pre.length()) {
            if ( pre.charAt(index) != pre.charAt(index - 1) ) {
                builder.append(count).append(curChar);
                count = 1;
                curChar = pre.charAt(index);
            } else {
                count ++;
            }

            index ++;
        }

        builder.append(count).append(curChar);
        return builder.toString();
    }
}
