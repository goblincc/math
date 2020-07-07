package com.yy.String;

/**
 * Created by cc on 2020/6/20.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new ReverseWords().reverseWords3(s));
//        int[] a = new int[10];
//        for (int i = 0; i < 10; i++) {
//            a[i++] = i;
//        }

    }
    public String reverseWords(String s){
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(String word:words){
            res.append(new StringBuilder(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int left = 0;
        int right = 0;
        char temp;
        for (int i = 0; i < n; i++) {
            if (a[i] == ' ') {
                right = i - 1;
                while (left < right) {
                    temp = a[left];
                    a[left++] = a[right];
                    a[right--] = temp;
                }
                left = i + 1;
            }
        }
        right = n - 1;
        while (left < right) {
            temp= a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
        return new String(a);
    }

    public String reverseWords3(String s) {
        char[] ss = s.toCharArray();
        int left = 0;
        int right = 0;
        char temp;
        for(int i = 0; i < ss.length; i++){
            if(ss[i] == ' '){
                right = i - 1;
                while(left < right){
                    temp = ss[left];
                    ss[left++] = ss[right];
                    ss[right--] = temp;
                }
                left = i + 1;
            }

        }
        right = ss.length - 1;
        while(left < right){
            temp = ss[left];
            ss[left++] = ss[right];
            ss[right--] = temp;

        }
        return new String(ss);

    }
}
