package com.yy.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2019/7/13.
 */
public class NoRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abaabcda"));
    }
    public static int lengthOfLongestSubstring(String s){
        char[] chars = s.toCharArray();
        int sum = 0;
        int curr = 0;
        List<Character> list = new LinkedList();
        for(int i = 0; i < chars.length; i++){
            if(!list.contains(chars[i])){
                list.add(chars[i]);
                curr = list.size();
                if(curr > sum){
                    sum = curr;
                }
            }else{
                list.add(chars[i]);
                int index = list.indexOf(chars[i]);
                for(int j = 0; j < index; j++){
                    ((LinkedList<Character>) list).remove();
                }
                ((LinkedList<Character>) list).remove();
            }
        }
        System.out.println(list);
        return sum;
    }
}
