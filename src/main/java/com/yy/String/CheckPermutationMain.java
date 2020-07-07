package com.yy.String;

import java.util.HashMap;

/**
 * Created by cc on 2020/6/20.
 */
public class CheckPermutationMain {
    public static void main(String[] args) {
        String s1 = "jzvthzihsvghjhbrpfhdwixmyaxjrdzfvnhpmyrbqjpdffykqgahgzpjwvouurr";
        String s2 = "hhqhxjyrghjjsmduaxppwrqkikqnfdrzjowapehtbyrgrfyprrfrebzduxvvhhu";
        CheckPermutationMain checkPermutationMain = new CheckPermutationMain();
        System.out.println(checkPermutationMain.CheckPermutation2(s1, s2));
    }
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        for(int i = 0; i < ss1.length; i++){
            map.put(ss1[i], map.getOrDefault(ss1[i], 0) + 1);
        }
        for (int i = 0; i < ss2.length; i++) {
            if(map.containsKey(ss2[i]) && map.get(ss2[i]) > 1){
                map.put(ss2[i], map.getOrDefault(ss2[i], 0) - 1);
            }else if(map.containsKey(ss2[i]) && map.get(ss2[i]) == 1){
                map.remove(ss2[i]);
            }
        }
        if(map.size() == 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean CheckPermutation2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m != n){
            return false;
        }
        int[] index = new int[128];
        for(int i = 0; i < m; i++){
            index[s1.charAt(i)]++;
            index[s2.charAt(i)]--;
        }
        for(int i = 0 ; i < index.length; i++){
            if(index[i] != 0){
                return false;
            }
        }
        return true;
    }
}
