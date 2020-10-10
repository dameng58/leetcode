/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

import java.util.ArrayList;
import java.util.List;

public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return resultList;
        }

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int eleNumbers = (right + 1) * (bottom + 1);
        //模拟转圈圈解法，最重要的是结束的判断条件
        while (eleNumbers >= 1){
            for (int i = left; i <= right && eleNumbers >= 1; i++){
                resultList.add(matrix[top][i]);
                eleNumbers--;
            }
            top++;
            for (int i = top; i <= bottom && eleNumbers >= 1; i++){
                resultList.add(matrix[i][right]);
                eleNumbers--;
            }
            right--;
            for (int i = right; i >= left && eleNumbers >= 1; i--){
                resultList.add(matrix[bottom][i]);
                eleNumbers--;
            }
            bottom--;
            for (int i = bottom; i >= top && eleNumbers >= 1; i--){
                resultList.add(matrix[i][left]);
                eleNumbers--;
            }
            left++;
        }
        return resultList;
    }

}
