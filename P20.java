/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.栈;

import java.util.Stack;

public class P20 {
    public boolean isValid(String s) {
        if ("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char cha = s.charAt(i);
            if (cha == '(' || cha == '{' || cha == '['){
                stack.push(cha);
            }else if (cha == ')' || cha == '}' || cha == ']'){
                if (!stack.empty()){
                    char tempChar = stack.peek();
                    if (tempChar == '(' && cha == ')' || tempChar == '{' && cha == '}'
                    || tempChar == '[' && cha == ']'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                continue;
            }
        }
        return stack.empty();
    }
}
