package com.yy.java;

/**
 * Created by cc on 2020/2/6.
 */
public class Water {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(water(height));
        System.out.println(water2(height));
    }

    public static int water(int[] height){
        if(height.length == 0) return 0;
        int ans = 0;
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n-1] = height[n - 1];
        for (int i = 1; i < n - 1; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(r_max[i], l_max[i]) - height[i];
        }
        return ans;
    }

    public static int water2(int[] height){
        int left = 0;
        int right = height.length - 1;
        int l_max = height[0];
        int r_max = height[height.length - 1];
        int ans = 0;
        while (left < right){
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if(l_max < r_max){
                ans += l_max - height[left];
                left ++;
            }else {
                ans += r_max - height[right];
                right --;
            }
        }
        return ans;
    }
}
