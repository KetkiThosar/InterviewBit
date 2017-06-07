package com.ib.linkedlist;

import java.util.HashMap;

public class MyLinkedList<E> {

	private Node<E> head = null;
	private int size = 0;

	/**
	 * 
	 * @param data
	 */
	public void add(E data) {
		if (this.head == null) {
			Node<E> node = createNode(data);
			this.head = node;
		} else {
			addNode(head, data);
		}
	}

	// TODO
	/**
	 *
	 * @param x
	 *            key1
	 * @param y
	 *            key2
	 * 
	 *            Given a linked list and two keys in it, swap nodes for two
	 *            given keys. Nodes should be swapped by changing links.
	 *            Swapping data of nodes may be expensive in many situations
	 *            when data contains many fields. It is assumed that values in
	 *            linked list are distinct
	 */
	public void swapNode(E x, E y) {
		Node<E> node1 = null, node2 = null;
		if ((node1 = searchNode(x, head)) == null
				|| (node2 = searchNode(y, head)) == null || node1.equals(node2)) {
			return;
		}
		int index1 = getIndex(node1);
		int index2 = getIndex(node2);
		Node<E> temp1 = null, temp2 = null, tempNext1 = null, tempNext2 = null;

		if (index1 == 0) {
			temp1 = head;
		} else if (index1 > 0) {
			temp1 = getNthNode(index1 - 1);
		}
		if (index2 == 0) {
			temp2 = head;
		} else if (index2 > 0) {
			temp2 = getNthNode(index2 - 1);
		}
		if (temp1.equals(node1) || temp1.equals(node2) || temp2.equals(node1)
				|| temp2.equals(node2)) {

		}

		// tempPrev1=temp1.next;tempPrev2=temp2.next;

		tempNext1 = node1.next;
		tempNext2 = node2.next;

		temp1.next = node2;
		node2.next = tempNext1;

		temp2.next = node1;
		node1.next = tempNext2;

	}

	public int getIndex(Node<E> n1) {
		int count = 0;
		Node<E> temp = head;
		while (temp != null) {
			if (n1.equals(temp))
				return count;

			temp = temp.next;
			count++;
		}
		return temp == null ? -1 : count;

	}

	public void addNode(Node<E> head, E data) {
		if (head.next == null) {
			Node<E> node = new Node<E>();
			node.setData(data);
			head.next = node;
		} else if (head.next != null) {
			addNode(head.next, data);
		}

	}

	public int size() {
		return size;
	}

	public void addAtFront(E data) {
		Node<E> newNode = createNode(data);

		if (this.head == null) {
			this.head = newNode;
		} else {
			Node<E> temp = head;
			head = newNode;
			newNode.next = temp;
		}

	}

	public boolean isPalindrome(Node<E> head) {
		Node<E> temp = head;
		Node<E> sp = temp;
		Node<E> fp = temp;
		Node<E> middle = null;
		Node<E> current = middle, prev = null, next = null, midNode = null, secondHalf = null;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			// System.out.println(fp.data);
			fp = fp.next.next;
			// System.out.println(sp.data);
		}

		if (fp != null) {
			midNode = sp;
			sp = sp.next;
		}
		secondHalf = sp;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		sp.next = null;
		sp.next = prev;

		return true;

	}

	public void getElements(Node <E>head) {
		Node<E> temp = head;
		while (temp != null) {
			System.out.println((temp.getData()));
			temp = temp.next;
		}
	}

	public Node<E> pairWiseSwap(Node<E> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<E> prev = head;
		Node<E> current = head.next;
		// update head
		head = current;
		while (true) {
			Node<E> next = current.next;
			current.next = prev;
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev = next;
			current = prev.next;

		}// end of while loop
		return head;

	}

	/**
	 * 
	 * @param index
	 *            1 based
	 * @param data
	 */
	public void insertAt(int index, E data) {
		int k = 1;
		Node<E> temp = head;
		while (k < index - 1 && temp != null) {
			temp = temp.next;
			k++;
		}
		Node<E> prevNext = temp.next;
		Node<E> node = createNode(data);
		temp.next = node;
		node.next = prevNext;

	}

	public void deleteAt(int index) {
		int k = 1;
		Node<E> temp = head;
		while (k < index - 1) {
			temp = temp.next;
			k++;
		}
		temp.next = temp.next.next;
		size--;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			System.out.println((head.getData()));
			head = head.next;
		}
		return sb.toString();
	}

	public void addAtEnd(E data) {
		Node<E> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = createNode(data);

	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	private Node<E> createNode(E data) {
		Node<E> node = new Node<E>();
		node.setData(data);
		size++;
		return node;

	}

	public Node<E> searchNode(E data, Node<E> node) {
		if (node == null) {
			return null;
		}
		if (node.data == data) {
			return node;
		}
		return searchNode(data, node.next);

	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public int findSize(Node<E> node) {
		if (node == null) {
			return 0;
		}
		return findSize(node.next) + 1;
	}

	/**
	 * 
	 * @param data
	 * @param head
	 * @return
	 */
	public boolean contains(E data, Node<E> head) {
		if (head == null)
			return false;
		if (head.data == data)
			return true;

		return contains(data, head.next);
	}

	/**
	 * 
	 * @param index
	 *            0 based
	 * @returns node present on given index
	 */
	public Node<E> getNthNode(int index) {
		Node<E> temp = head;
		int i = 0;
		while (i < index && temp != null) {
			temp = temp.next;
			i++;
		}
		return temp;
	}

	public int countOccurrences(E x, Node<E> node) {
		if (node == null) {
			return 0;
		}
		if (node.data == x) {
			return countOccurrences(x, node.next) + 1;
		}

		return countOccurrences(x, node.next);
	}

	public E findTheMiddle(Node<E> head) {
		Node<E> temp = head;
		Node<E> sp = temp;
		Node<E> fp = temp;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			// System.out.println(fp.data);
			fp = fp.next.next;
			// System.out.println(sp.data);
		}
		return sp.data;
	}

	void removeDuplicates(Node<E> head) {
		if (null == head || null == head.next) {
			return;
		}
		Node<E> current = head, nextTonext = head;
		while (current.next != null) {
			if (current.data == current.next.data) {
				nextTonext = current.next.next;
				current.next = null;
				current.next = nextTonext;
			} else {
				current = current.next;
			}
		}

	}

	Node<Integer> deleteDuplicates(Node<Integer> head) {
		if (null == head || null == head.next) {
			return head;
		}
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		Node<Integer> temp = head;
		int count = 1;
		while (temp != null) {
			if (countMap.containsKey(temp.data)) {
				count = countMap.get(temp.data) + 1;
			} else {
				count = 1;
			}
			countMap.put(temp.data, count);
			temp = temp.next;
		}
		Node<Integer> a = null;
		temp = head;
		while (temp != null) {
			if (countMap.get(temp.data) == 1) {
				if (a == null) {
					a = temp;
					a.next = null;
				} else {
					a.next = temp;
				}
			}

		}
		return a;

	}

	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		ll.add(10);
		ll.add(10);
		ll.add(11);
		ll.add(11);
		ll.add(11);
		ll.add(11);
		ll.add(12);
		ll.add(13);
		ll.add(13);
		ll.add(14);
		ll.add(15);
		ll.add(16);
		ll.add(16);
		ll.add(18);
		ll.add(18);
		ll.getElements(ll.head);
		System.out.println();
		ll.removeDuplicates(ll.head);
		System.out.println("******removed dupilcates********");
		ll.getElements(ll.head);
		System.out.println();
		System.out.println("inserted at index=3");
		ll.insertAt(3, 90);
		ll.getElements(ll.head);
		System.out.println();
		ll.deleteAt(3);
		ll.getElements(ll.head);
		System.out.println();
		System.out.println(ll.size());
		System.out.println();
		ll.addAtFront(190);
		ll.getElements(ll.head);
		System.out.println();
		ll.addAtEnd(200);
		ll.getElements(ll.head);
		System.out.println();
		System.out.println(ll.findSize(ll.head));
		System.out.println();
		System.out.println(ll.contains(21, ll.head));
		System.out.println();
		System.out.println("nth node:" + ll.getNthNode(3).data);
		System.out.println();
		Node<Integer> result = ll.searchNode(14, ll.head);
		System.out.println(result.data);
		System.out.println();
		System.out.println();
		ll.swapNode(190, 200);
		ll.getElements(ll.head);
		System.out.println("count occurrences: "
				+ ll.countOccurrences(15, ll.head));
		System.out.println();
		ll.deleteAt(2);
		ll.getElements(ll.head);
		System.out.println("find the middle: " + ll.findTheMiddle(ll.head));

		// ll.deleteDuplicates(ll.head);
		// ll.getElements();
		System.out.println("*******************************************");
		MyLinkedList<Integer> ll2 = new MyLinkedList<Integer>();
		ll2.add(1);
		ll2.add(2);
		ll2.add(3);
		ll2.add(4);
		ll2.add(5);
		ll2.add(6);
		System.out.println("is palindrome:  " + ll2.isPalindrome(ll2.head));
		Node<Integer>ans=ll2.pairWiseSwap(ll2.head);
		ll2.getElements(ans);
		
		
		
	}

}
