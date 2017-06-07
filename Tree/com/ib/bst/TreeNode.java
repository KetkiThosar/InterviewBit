package com.ib.bst;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	Integer data;

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [left=" + left + ", right=" + right + ", data=" + data
				+ "]";

	}

	void insertNode(Integer data) {
		TreeNode newNode = new TreeNode();
		newNode.setData(data);

		if (data <= this.data) {
			if (this.left == null) {

				this.setLeft(newNode);

			} else {
				this.left.insertNode(data);
			}// else
		}// end of if

		else if(data > this.data){
			if (this.right == null) {

				this.setRight(newNode);
			} else {
				this.right.insertNode(data);
			}

		}
	}
}
