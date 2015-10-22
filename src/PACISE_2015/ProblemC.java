package PACISE_2015;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Problem C from PACISE 2015
 * Binary Search Tree Problem
 * 
 * Not actually searching.
 * 
 * Calculate Mean Depth from root
 * Output Mean depth rounded 4 decimal spaces
 *
 * @author Brian Fekete
 */

/** Inputs:
Mark
Manni
Sue
Chris
Bev
Karen
Steve
x
 */
public class ProblemC {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.####");
		
		Scanner sc = new Scanner(System.in);
		Node node = new Node(sc.next());
		while (sc.hasNext()) {
			String name = sc.next();
			
			if(name.equals("x")) break;
			node.insertNode(node, name);
		}
		// System.out.println("Number of Nodes: " + countNode(node));
		// System.out.println("Sum of Depth: " + sumDepth(node, 1));
		System.out.println(df.format((double) sumDepth(node, 1) / countNode(node)));
		sc.close(); // Eclipse gives warnings
	}
	
	
	public static class Node { 
		protected Node left;
		protected Node right;
		protected String name;
		
		public Node(String name){
			this.name = name;
		}
		
		public void insertNode(Node n, String name){
			if(name.compareTo(n.name) <= 0){ 
				if(n.left != null){
					insertNode(n.left, name);
				} else {
					n.left = new Node(name);
				}
			} 
			if (name.compareTo(n.name) > 0){
				if(n.right != null ){
					insertNode(n.right, name);
				} else {
					n.right = new Node(name);
				}
			}
		}

	}
	
	// Oh shit, recursion
	// Counts total number of nodes inside the node
	// Counts children inside root node
	private static  int countNode(Node n){
		if(n == null) return 0;
		return 1 + countNode(n.left) + countNode(n.right);
	}
	
	// Oh shit, more recursion
	private static int sumDepth(Node n, int depth){
		if(n == null) return 0;
		return depth + sumDepth(n.left, depth+1) + sumDepth(n.right, depth+1);
	}
	
}
