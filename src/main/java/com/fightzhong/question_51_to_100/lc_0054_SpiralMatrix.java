package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.List;

public class lc_0054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] leftTop = {0, 0};
        int[] rightTop = {0, matrix[0].length - 1};
        int[] leftDown = {matrix.length - 1, 0};
        int[] rightDown = {matrix.length - 1, matrix[0].length - 1};

        List<Integer> result = new ArrayList<>();
        while ( leftTop[0] < rightDown[0] && leftTop[1] < rightDown[1] ) {
            // leftTop -> rightTop
            for (int i = leftTop[1]; i < rightTop[1]; i ++) {
                result.add(matrix[leftTop[0]][i]);
            }

            // rightTop -> rightDown
            for (int i = rightTop[0]; i < rightDown[0]; i ++) {
                result.add(matrix[i][rightTop[1]]);
            }

            // rightDown -> leftDown
            for (int i = rightDown[1]; i > leftDown[1]; i --) {
                result.add(matrix[leftDown[0]][i]);
            }

            // leftDown -> leftTop
            for (int i = leftDown[0]; i > leftTop[0]; i --) {
                result.add(matrix[i][leftDown[1]]);
            }

            leftTop = new int[]{leftTop[0] + 1, leftTop[1] + 1};
            rightTop = new int[]{rightTop[0] + 1, rightTop[1] - 1};
            leftDown = new int[]{leftDown[0] - 1, leftDown[1] + 1};
            rightDown = new int[]{rightDown[0] - 1, rightDown[1] - 1};
        }

        if ( leftTop[0] == rightDown[0] && leftTop[1] == rightDown[1] ) {
            result.add( matrix[leftTop[0]][leftTop[0]] );
        } else if ( leftTop[0] == rightDown[0] ) {
            for (int i = leftTop[1]; i <= rightTop[1]; i ++) {
                result.add(matrix[leftTop[0]][i]);
            }
        } else if(leftTop[1] == rightDown[1]) {
            for (int i = leftTop[0]; i <= rightDown[0]; i ++) {
                result.add(matrix[i][leftTop[1]]);
            }
        }

        return result;
    }
}
