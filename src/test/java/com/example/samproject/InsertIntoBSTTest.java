package com.example.samproject;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Model.TreeNode;


public class InsertIntoBSTTest {

	@Test 
	public void testBST1() {
		
		
		InsertIntoBinaryTree insertIntoBinaryTree = new InsertIntoBinaryTree();
		
		TreeNode node = 
				new TreeNode(4, 
						new TreeNode(2, new TreeNode(1, null, null), null),
						new TreeNode(7, null, null));
		
		TreeNode expectedAns = 
				new TreeNode(4, 
						new TreeNode(2, new TreeNode(1, null, null), null),
						new TreeNode(7, new TreeNode(5, null, null), null));
		
		
			
		var ans = insertIntoBinaryTree.insertIntoBST(node, 5);
		
		assertEquals(expectedAns, ans);
	}
}
