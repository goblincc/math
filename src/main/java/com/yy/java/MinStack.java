package com.yy.java;

import scala.tools.nsc.Global;

import java.util.Stack;

/**
 * Created by cc on 2019/12/30.
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(1);
        System.out.println(minStack.data);
        System.out.println(minStack.getMin());
    }

    private Stack<Integer> data;
    private Stack<Integer> help;

    public MinStack(){
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(int x){
        data.add(x);
        if(help.isEmpty() || help.peek() >= x){
            help.add(x);
        }else{
            help.add(help.peek());
        }
    }

    public void pop(){
        if(!data.isEmpty()){
            data.pop();
            help.pop();
        }
    }

    public int top(){
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("元素为空");
    }

    public int getMin(){
        if(!help.isEmpty()){
            return help.peek();
        }
        throw new RuntimeException("元素为空");
    }

}
