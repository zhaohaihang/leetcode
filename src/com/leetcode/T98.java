package com.leetcode;

import java.util.Stack;

public class T98 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
//    public boolean isValidBST(TreeNode root) {
////        return helper(root, null, null);
//    }
//
//    public boolean helper(TreeNode root, Integer low ,Integer up){
//         if(root==null) return true;
//        if(low!=null&&root.val<=low) return false;
//        if(up!=null&&root.val>=up) return  false;
//        if(!helper(root.left, low, root.val)) return false;
//        if(!helper(root.right, root.val,up)) return false;
//        return true;
//    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double minnum = - Double.MAX_VALUE;
        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(root.val<=minnum) return false;
            minnum=root.val;
            root=root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }
}
