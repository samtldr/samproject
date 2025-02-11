package com.example.samproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Model.TreeNode;

public class ZigZagLevelOrderTest {

	@Test 
	public void testZigZag() {
		
		
		ZigZagLevelOrder zigZagLevelOrder = new ZigZagLevelOrder();
		
		TreeNode node = 
				new TreeNode(1, 
						new TreeNode(2, new TreeNode(4, null, null), null),
						new TreeNode(3, null, new TreeNode(5, null, null)));
		
		List<List<Integer>> expectedAns = new LinkedList<>();
		
		expectedAns.add(List.of(1));
		expectedAns.add(List.of(3, 2));
		expectedAns.add(List.of(4, 5));
		
		var ans = zigZagLevelOrder.zigzagLevelOrder(node);
		
		assertEquals(expectedAns, ans);
	}
}
