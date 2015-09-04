package interviewprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

import interviewprep.models.Node;

/**
* CareerCup - LinkedIn
* http://www.careercup.com/question?id=5668114807128064
*/

public class RelationTree {

	public static class Relation {

		public Integer child;
		public Integer parent;
		public boolean isLeft;

		public Relation(Integer child, Integer parent, boolean isLeft) {
			this.child = child;
			this.parent = parent;
			this.isLeft = isLeft;
		}
	}

	public static Node buildTree(List<Relation> data) {
		// map of parent's id to a list of its children's relations
		HashMap<Integer, ArrayList<Relation>> map = new HashMap<Integer, ArrayList<Relation>>();
		Node root = null;
		// find tree's root
		for (Relation rel : data) {
			if (rel.parent == null) {
				root = new Node(rel.child, null, null);
			} else {
				if (map.containsKey(rel.parent)) {
					ArrayList<Relation> children = map.get(rel.parent);
					children.add(rel);
					// TODO try commenting this out later to test out Java references
					map.put(rel.parent, children);
				} else {
					ArrayList<Relation> children = new ArrayList<Relation>();
					children.add(rel);
					map.put(rel.parent, children);
				}
			}
		}
		if (root == null) return root;

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (map.containsKey(n.value)) {

				ArrayList<Relation> children = map.get(n.value);
				int numChildren = 0;
				for (Relation rel : children) {
					if (numChildren == 2) break;
					Node child = new Node(rel.child, null, null);
					if (rel.isLeft) {
						n.left = child;
					} else {
						n.right = child;
					}
					queue.add(child);
					numChildren++;
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		System.out.println("Building relations");
		Relation rel0 = new Relation(15, 20, true);
		Relation rel1 = new Relation(19, 80, true);
		Relation rel2 = new Relation(17, 20, false);
		Relation rel3 = new Relation(16, 80, false);
		Relation rel4 = new Relation(80, 50, false);
		Relation rel5 = new Relation(50, null, false);
		Relation rel6 = new Relation(20, 50, true);
		ArrayList<Relation> relations = new ArrayList<Relation>();
		relations.add(rel0);
		relations.add(rel1);
		relations.add(rel2);
		relations.add(rel3);
		relations.add(rel4);
		relations.add(rel5);
		relations.add(rel6);
		System.out.println("Building tree");
		Node root = buildTree(relations);
		System.out.println("Printing tree");
		TreePrinter.printTree(root);
	}

}