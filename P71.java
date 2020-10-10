/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.栈;

import java.util.Stack;

public class P71 {
    public String simplifyPath(String path) {
        if ("".equals(path)){
            return "";
        }
        //To do 考虑匹配//
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++){
            if ("..".equals(strings[i])){
                if (stack.size() > 1){
                    stack.pop();
                }else {
                    return "/";
                }
            }else {
                stack.push(strings[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0){
            if (stack.size() != 1){
                sb.append("/");
            }
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
