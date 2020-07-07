package com.yy.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2020/6/14.
 */
public class BinaryTreePaths {
    LinkedList<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return null;
        LinkedList<String> track = new LinkedList<>();
        backTrack(root, track);
        return res;
    }

    public void backTrack(TreeNode root, LinkedList track){
        if(root != null){
            track.add(root.value);
            if(root.left == null && root.right == null){
                res.add(list2String(new LinkedList(track)));
            }else{
                backTrack(root.left, track);
                backTrack(root.right, track);
                track.removeLast();
            }
        }
    }

    public String list2String(LinkedList track){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < track.size(); i++) {
            sb.append(track.get(i));
            if(i < track.size() - 1){
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
