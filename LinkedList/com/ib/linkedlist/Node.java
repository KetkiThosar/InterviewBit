package com.ib.linkedlist;


public class Node<E> {
	E data;
	Node<E> next;

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (this == obj)
			return true;

		@SuppressWarnings("unchecked")
		Node<E> other = (Node<E>) obj;
		if (this.data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!other.data.equals(this.data)) {
			return false;
		}
		if (this.next == null) {
			if (other.next != null) {
				return false;
			}
		} else if (!other.next.equals(this.next)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}
