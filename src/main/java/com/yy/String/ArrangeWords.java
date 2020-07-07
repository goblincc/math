package com.yy.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cc on 2020/6/22.
 */
public class ArrangeWords {
    public static void main(String[] args) {
        String text = "Leetcode is cool";
        System.out.println(new ArrangeWords().arrangeWords(text));
        char i = (char)('L' + 32);
        System.out.println(i);
    }

    public String arrangeWords(String text) {
        String[] strs = text.toLowerCase().split(" ");
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        char first = strs[0].charAt(0);
        first=(char)(first-32);
        String temp= first +strs[0].substring(1);
        strs[0]=temp;
        String res="";
        res= String.join(" ", strs);

        return res;
    }



}
