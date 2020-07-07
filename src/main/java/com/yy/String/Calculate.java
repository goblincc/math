package com.yy.String;

import java.util.Stack;

/**
 * Created by cc on 2020/6/22.
 */
public class Calculate {
    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(new Calculate().calculate(s));
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10 * num + (c - '0');
            }

            if((!Character.isDigit(c) && c != ' ')|| i == s.length() - 1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
