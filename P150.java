/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.栈;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    该题目本身并没有说是否出现int溢出，所以自己想麻烦了点。
 */
public class P150 {

    private static final List<Character> list = new ArrayList<>();

    private void before(){
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null){
            return 0;
        }
        int len = tokens.length;
        if (len <= 0){
            return 0;
        }
        before();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            String nowNumber;
            //这里要注意负数的第一个字符也是-，所以要区别对待
            if (list.contains(tokens[i].charAt(0)) && tokens[i].length() == 1){
                cal(tokens[i].charAt(0), stack);
            }else {
                nowNumber = new BigInteger(tokens[i]).toString();
                stack.push(nowNumber);
            }
        }
        return new BigInteger(stack.pop()).intValue();
    }

    private void cal(char cha, Stack<String> stack){
        if (stack.size() >= 2){
            String str1 = stack.pop();
            String str2 = stack.pop();
            //这里要注意str1和str2的顺序
            BigInteger bigInteger1 = new BigInteger(str2);
            BigInteger bigInteger2 = new BigInteger(str1);
            if (list.indexOf(cha) == 0){
                stack.push(bigInteger1.add(bigInteger2).toString()); ;
            }else if (list.indexOf(cha) == 1){
                stack.push(bigInteger1.subtract(bigInteger2).toString()); ;
            }else if (list.indexOf(cha) == 2){
                stack.push(bigInteger1.multiply(bigInteger2).toString()); ;
            }else if (list.indexOf(cha) == 3){
                stack.push(bigInteger1.divide(bigInteger2).toString()); ;
            }else {
                //这里判断其他符号的
            }
        }
    }

    public static void main(String[] args) {
        P150 p150 = new P150();
        // String[] strings = {"4", "13", "5", "/", "+"};
        //["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        String[] strings = {"10", "6", "9", "3", "+", "-11","*","/","*","17","+","5","+"};
        p150.evalRPN(strings);
    }



}
