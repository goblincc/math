package com.yy.java;

/**
 * Created by cc on 2019/7/16.
 */
public class HuiWen {
    public static void main(String[] args) {
        /*int s = 121;
        String str = String.valueOf(s);
        boolean flag = true;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length/2; i++){
            if(chars[i] == chars[chars.length-i-1]){
                continue;
            }else{
                flag = false;
                break;
            }
        }
        System.out.println(flag);*/
        System.out.println(isPalinder(1221));

    }

    public static boolean isPalinder(int x){
        if(x<0){
            return false;
        }
        if(x % 10 == 0 && x != 0){
            return false;
        }
        int y = 0;

        while(x>y){
            y = y * 10 + x % 10;
            x = x/10;
        }
        return x == y || x == y / 10;
    }
}
