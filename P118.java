/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (numRows <= 0){
            return resultList;
        }
        resultList.add(Arrays.asList(1));
        if (numRows == 1){
            return resultList;
        }
        resultList.add(Arrays.asList(1, 1));
        if (numRows == 2){
            return resultList;
        }
        for (int i = 3; i <= numRows; i++){
            List<Integer> preList = resultList.get(resultList.size() - 1);
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            int temp = preList.get(0);
            for (int j = 1; j < i - 1; j++){
                int sum = temp + preList.get(j);
                tempList.add(sum);
                temp = preList.get(j);
            }
            tempList.add(1);
            resultList.add(tempList);
        }
        return resultList;
    }
}
