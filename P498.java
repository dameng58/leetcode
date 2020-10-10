/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

public class P498 {

    public static void main(String[] args) {
        int[] result = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int num : result){
            System.out.print(num + ",");
        }
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = 0;
        boolean isFlag = true;//判断右上还是左下，右上为true，左下为false

        int totalNum = rows * cols;
        int[] result = new int[totalNum];
        int index = 0;

        /*
            注意观察规律，方向只有右上和左下
            1、右上的方向分三种情况，右上-》右-》下
            2、同理，左下的方向分三种情况，左下-》下-》右
         */

        while (exitNum(row, col, rows, cols) && index < totalNum){
            result[index++] = matrix[row][col];
            // 右上
            if (isFlag){

                if (exitNum(row - 1, col + 1, rows, cols)){
                    row -= 1;
                    col += 1;
                }else if (exitNum(row, col + 1, rows, cols)){
                    col += 1;
                    isFlag = false;
                }else if (exitNum(row + 1, col, rows, cols)){
                    row += 1;
                    isFlag = false;
                }

                //转方向的条件为没有找到右上

            }else { // 左下

                if (exitNum(row + 1, col - 1, rows, cols)){
                    row += 1;
                    col -= 1;
                }else if (exitNum(row + 1, col, rows, cols)){
                    row += 1;
                    isFlag = true;
                }else if (exitNum(row, col + 1, rows, cols)){
                    col += 1;
                    isFlag = true;
                }

                //转方向的条件为没有找到左下

            }

        }
        return result;
    }

    public static boolean exitNum(int row, int col, int rows, int cols){
        return row >= 0 && row < rows && col >= 0 && col < cols ;
    }

}
