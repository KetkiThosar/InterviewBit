package com.ib.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class BinarySearchTree {
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	TreeNode findNextGreaterNumber(TreeNode node, int data) {
		Deque<TreeNode> pq = new java.util.LinkedList<TreeNode>();
		Stack<TreeNode> successor = new Stack<TreeNode>();
		int minDiff = Integer.MAX_VALUE;
		if (node == null)
			return null;
		pq.add(node);
		while (!pq.isEmpty()) {
			TreeNode temp = pq.poll();
			if (temp.getData() > data && (temp.getData() - data) < minDiff) {
				minDiff = temp.getData() - data;
				successor.add(temp);
			}
			if (((TreeNode) temp).getLeft() != null) {
				pq.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				pq.add(temp.getRight());
			}
		}
		return !successor.isEmpty() ? successor.pop() : null;
	}

	void insertNode(Integer data) {
		if (root == null) {
			TreeNode newNode = new TreeNode();
			newNode.setData(data);
			setRoot(newNode);
		} else {
			this.root.insertNode(data);
		}
	}

	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print("  " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder(TreeNode root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print("  " + root.data);
	}

	public boolean isTreeValid(TreeNode node) {

		return true;

	}

	public void inorderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		while (temp != null) {
			stack.push(temp);
			temp = temp.getLeft();
		}
		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.println(" " + temp.data);
			if (temp.getRight() != null) {
				temp = temp.getRight();
				while (temp != null) {
					stack.push(temp);
					temp = temp.getLeft();
				}
			}
		}
	}

	public void postorderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode temp = root;
		stack1.push(temp);
		while (!stack1.isEmpty()) {
			TreeNode t = stack1.pop();
			stack2.push(t);
			if (t.left != null) {
				stack1.push(t.left);
			}
			if (t.right != null) {
				stack1.push(t.right);
			}
		}// stack1.isEmpty()
		while (!stack2.isEmpty()) {
			result.add(stack2.pop().data);

		}
		System.out.print("  " + result.toString());

	}

	public ArrayList<Integer> preorderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		while (temp != null) {
			stack.push(temp);
			System.out.print("  " + temp.data);
			result.add(temp.getData());
			temp = temp.getLeft();
		}
		while (!stack.isEmpty()) {
			temp = stack.pop();
			if (temp.getRight() != null) {
				temp = temp.getRight();
				while (temp != null) {
					stack.push(temp);
					System.out.print("  " + temp.data);
					result.add(temp.data);
					temp = temp.getLeft();
				}// end of while loop
			}
		}
		return result;
	}

	public Integer lowestCommonAncestor(TreeNode root, int num1, int num2) {
		if (root == null) {
			return -1;
		}
		if (num1 < root.data && num2 < root.data) {
			return lowestCommonAncestor(root.left, num1, num2);
		} else if (num1 > root.data && num2 > root.data) {
			return lowestCommonAncestor(root.right, num1, num2);
		} else {
			return root.data;
		}

	}

	public TreeNode findElement(TreeNode root, int data) {
		if (null == root) {
			return null;
		}
		if (data == root.data) {
			return root;
		}
		if (root.data < data) {
			return findElement(root.right, data);
		}
		return findElement(root.left, data);
	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNode(8);
		bst.insertNode(5);
		bst.insertNode(3);
		bst.insertNode(2);
		bst.insertNode(4);
		bst.insertNode(1);
		bst.insertNode(6);
		bst.insertNode(7);
		bst.insertNode(10);
		bst.insertNode(9);
		bst.insertNode(12);
		bst.insertNode(11);
		bst.insertNode(14);
		bst.insertNode(13);
		bst.insertNode(17);
		bst.postorder(bst.root);
		System.out.println("*************************************************");
		/* ArrayList<Integer>a= */bst.postorderWithoutRecursion(bst.root);
		System.out.println();
		/* System.out.println(a.toString()); */
		System.out.println();
		System.out.println("successor : "
				+ bst.findNextGreaterNumber(bst.root, 8).getData());
		System.out
				.println("find element " + bst.findElement(bst.root, 11).data);
	}

}
