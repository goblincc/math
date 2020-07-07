package com.yy.mine;

/**
 * Created by cc on 2020/3/23.
 */
public class LongPard {
    public static void main(String[] args) {
        String s = "adccbad";
        Node[][] n = longPard(s);
        System.out.println(n[0][s.length() - 1].value);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(n[0][i].choice == 1){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static Node[][] longPard(String s){
        Node[][] dp1 = new Node[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() ; j++) {
                if(i == j){
                    dp1[i][j] = new Node(1, 0);
                }else{
                    dp1[i][j] = new Node(0, 0);
                }
            }
        }

        for (int i = s.length() - 1; i >= 0 ; i--) {
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp1[i][j].value = dp1[i + 1][j - 1].value + 2;
                    dp1[0][j].choice = 1;
                    dp1[0][i].choice = 1;
                }else{
                    dp1[i][j].value = Math.max(dp1[i + 1][j].value, dp1[i][j - 1].value);
                }
            }
        }
        return dp1;
    }
}
