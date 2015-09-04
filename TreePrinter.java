package interviewprep;

import java.lang.StringBuffer;
import java.util.LinkedList;

import interviewprep.models.Node;

/* 

CareerCup - LinkedIn
http://www.careercup.com/question?id=5765154941698048

Tree: 
1 
/ \ 
3 5 
/ \ \ 
2 4 7 
/ \ \ 
9 6 8 

========== 
Expected Output: 
1 
35 
247 
968 


class TreePrinter { 

static class Node { 
int value; 
Node left; 
Node right; 
public Node(int value, Node left, Node right) { 
this.value = value; 
this.left = left; 
this.right = right; 
} 
} 

public void printTree(Node root) { 
// implementation here 
}

*/

public class TreePrinter {

	// public static class Node {
	// 	int value;
	// 	Node left;
	// 	Node right;

	// 	public Node(int value, Node left, Node right) {
	// 		this.value = value;
	// 		this.left = left;
	// 		this.right = right;
	// 	}
	// }

	public static class CustomTuple {

		Node node;
		int level;

		public CustomTuple(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public static void printTree(Node root) {
		if (root == null) return;
		// StringBuffer sb = new StringBuffer();
		LinkedList<CustomTuple> queue = new LinkedList<CustomTuple>();
		queue.add(new CustomTuple(root, 0));
		int prevLvl = 0;
		while (!queue.isEmpty()) {

			CustomTuple tup = queue.remove();
			Node n = tup.node;
			int lvl = tup.level;

			// reached first node in new level of tree, so print vals of prev lvl in StringBuffer sb
			if (lvl != prevLvl) {
				// System.out.println(sb.toString());
				// sb = new StringBuffer();
				// sb.append(n.value);
				System.out.println();
				System.out.print(n.value);
				prevLvl = lvl;
			} else {
				// sb.append(n.value);
				System.out.print(n.value);
			}

			if (n.left != null) {
				queue.add(new CustomTuple(n.left, lvl+1));
			}
			if (n.right != null) {
				queue.add(new CustomTuple(n.right, lvl+1));
			}

		}
		// System.out.println(sb.toString());
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Building tree");
		Node nine = new Node(9, null, null);
		Node six = new Node(6, null, null);
		Node eight = new Node(8, null, null);
		Node two = new Node(2, nine, six);
		Node four = new Node(4, null, eight);
		Node three = new Node(3, two, four);
		Node seven = new Node(7, null, null);
		Node five = new Node(5, null, seven);
		Node one = new Node(1, three, five);
		System.out.println("Trying print tree");
		printTree(one);
	}

}