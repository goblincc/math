package com.yy.unionFind;

/**
 * Created by cc on 2020/2/7.
 */
public class EquationsPossible {
    public static void main(String[] args) {
        String[] equations = new String[]{"a==b", "b==c", "a==c"};
        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations){
        UF uf = new UF(26);
        for(String eq: equations){
            if(eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for(String eq: equations){
            if(eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.connect(x - 'a', y - 'a')){
                    return false;
                }
            }
        }
        return true;
    }
}
