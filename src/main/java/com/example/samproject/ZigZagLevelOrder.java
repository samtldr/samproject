package com.example.samproject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Model.TreeNode;

public class ZigZagLevelOrder {
	
	public ZigZagLevelOrder() {
		
	}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        

        List<List<Integer>> ans = new LinkedList<>();

        if(root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        List<Integer> startList = new LinkedList<>();
        startList.add(root.val);
        ans.add(startList);

        Boolean isEven = true;

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();

            List<Integer> currList = new LinkedList<>();

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();


	            if (node.right != null) {
	                currList.add(node.right.val);
	                queue.add(node.right);
	            }
	            if (node.left != null) {
	                currList.add(node.left.val);
	                queue.add(node.left);
	            }

	            
            }
            
            if(!isEven) {
            	Collections.reverse(currList);
            }
            
            if(currList.size() > 0) {
                ans.add(currList);
            } 
            
            isEven = !isEven;
        }

        return ans;
    }
}


