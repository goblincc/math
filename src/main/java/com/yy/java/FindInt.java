package com.yy.java;

/**
 * Created by cc on 2019/7/16.
 */
public class FindInt {
    public static void main(String[] args) {
        int i = find(-2147483648);
        System.out.println(i);
    }

    /**
     * 注意int类型的大小，反转可能溢出
     * @param x
     * @return
     */
    public static int find(int x){
        if(x > -2147483648||x<2147483647){
            String str = String.valueOf(Math.abs(x));
            char[] chars = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i = chars.length-1; i >= 0; i--){
                sb.append(chars[i]);
            }
            try {
                int res = Integer.valueOf(sb.toString());
                if(x < 0){
                    res = -res;
                }
                return res;
            }catch (Exception e){
                System.out.println(e);
                return 0;
            }

        }else{
            return 0;
        }

    }
}
