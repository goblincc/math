package com.yy.java;

/**
 * Created by cc on 2019/7/13.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbba"));
        System.out.println(longestPalindrome2("abba"));
    }
    public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }else{
                return  s.substring(0, 1);
            }
        }
        String result = "";
        for(int i = 1; i < s.length(); i++){
            String odd = maxPalindrome(s, i-1, i+1);
            String even1 = maxPalindrome(s, i-1, i);
            String even2 = maxPalindrome(s, i, i+1);
            if(odd.length() > even1.length()){
                if(even2.length() > odd.length() && even2.length() > result.length()){
                    result = even2;
                }else if(odd.length() > result.length()){
                    result = odd;
                }
            }else{
                if(even2.length() > even1.length() && even2.length() > result.length()){
                    result = even2;
                }else if(even1.length() > result.length()){
                    result = even1;
                }
            }
        }
        return result;
    }

    public static String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = maxPalindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = maxPalindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private static String maxPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
