package com.test1;

public class LinkedList {
	
	private static class Node {
		int value;
		Node next;
		
		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}				
	}
	
	Node start;
	Node current;
	
	public void addNexNode(Node node) {
		if(start == null) {
			start = node;
			current = node;
		} else {
			current.next = node;
			current = node;
		}
	}
	
	public void printList() {
		Node temp = this.start;
		while(temp.next != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.print(temp.value);
	}

	public static void main(String[] args) {		
		LinkedList list = new LinkedList();
		Node n1 = new Node();
		n1.value = 10;
		n1.next = null;
		list.addNexNode(n1);
		Node n2 = new Node();
		n2.value = 20;
		n2.next = null;
		list.addNexNode(n2);
		list.printList();
	}

}
