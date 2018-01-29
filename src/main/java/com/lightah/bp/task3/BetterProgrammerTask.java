package com.lightah.bp.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Lightah
 */
public class BetterProgrammerTask {

	// Please do not change this interface
	public static interface Node {
		int getValue();

		List<Node> getChildren();
	}

	/**
	 * Calculates the average value for all {@link Node} values in the tree.
	 * 
	 * @param root
	 *            The root {@link Node}
	 * @return a double indicating the average value of all {@link Node} values.
	 */
	public static double getAverage(Node root) {
		List<Node> nodeList;
		double total;

		if (root == null) {
			return 0;
		}

		nodeList = new ArrayList<Node>();
		addNodes(root, nodeList);

		total = 0;
		for (Node node : nodeList) {
			total += node.getValue();
		}

		return total / nodeList.size();
	}

	/**
	 * 
	 * @param rootNode
	 *            root {@link Node} optionally having children
	 * @param nodeList
	 *            {@link List} to add all {@link Nodes} to
	 */
	private static void addNodes(Node rootNode, List<Node> nodeList) {
		if (rootNode == null) {
			return;
		}

		nodeList.add(rootNode);

		// TODO: is getChildren guaranteed non-null?
		for (Node node : rootNode.getChildren()) {
			addNodes(node, nodeList);
		}
	}

	public static void main(String[] args) {
		// TODO
	}
}
