package by.htp.linkedlist;

public class MyLinkedList<E> {

	Node first;
	Node last;
	int size = 0;

	public void add(E element) {
		Node node = new Node(element);

		if (first == null) {
			first = node;
			last = first;
		} else {
			last.next = node;
			node.prev = last;
			last = node;
		}
		size++;
	}

	public void add(int index, E element) {
		Node nodeAdd = new Node(element);

		if (index > 0 && index < size) {
			Node nodeNext = getNode(index);
			Node nodePrev = nodeNext.prev;
			nodePrev.next = nodeAdd;
			nodeAdd.prev = nodePrev;
			nodeAdd.next = nodeNext;
			nodeNext.prev = nodeAdd;
			size++;

		} else if (index == 0) {
			nodeAdd.next = first;
			first.prev = nodeAdd;
			first = nodeAdd;
			nodeAdd.prev = null;
			size++;

		} else if (index == size) {
			last.next = nodeAdd;
			nodeAdd.prev = last;
			last = nodeAdd;
			nodeAdd.next = null;
			size++;
		}
		index++;
		System.out.println("\nStudentsList after adding to the position: " + index + "\n");
	}

	public void addFirst(E element) {
		Node nodeAdd = new Node(element);
		nodeAdd.next = first;
		first.prev = nodeAdd;
		first = nodeAdd;
		nodeAdd.prev = null;
		size++;
		System.out.println("\nStudentsList after adding to the first position: " + "\n");
	}

	public void addLast(E element) {
		Node nodeAdd = new Node(element);
		last.next = nodeAdd;
		nodeAdd.prev = last;
		last = nodeAdd;
		nodeAdd.next = null;
		size++;
		System.out.println("\nStudentsList after adding to the last position: " + "\n");
	}

	public void remove(int index) {
		if (index > 0 && index < size - 1) {
			Node nodeRemove = getNode(index);
			Node nodePrev = nodeRemove.prev;
			Node nodeNext = nodeRemove.next;
			nodePrev.next = nodeNext;
			nodeNext.prev = nodePrev;
			size--;

		} else if (index == 0) {
			first = first.next;
			first.prev = null;
			size--;

		} else if (index + 1 == size) {
			last = last.prev;
			last.next = null;
			size--;
		}
		index++;
		System.out.println("\nStudentsList after removing the position: " + index + "\n");
	}

	public int indexOf(E element) {
		int index = 0;
		for (Node node = first; node != null; node = node.next) {
            if (element.equals(node.item))
                return index;
            index++;
        }
		return -1;
	}
		
	private Node getNode(int index) {
		Node node = first;

		if (index == 0) {
			return node;
		}

		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public void printList() {
		Node node = first;
		int i = 1;
		while (node != null) {
			System.out.println(i + "." + node);
			i++;
			System.out.println("Previous link: " + node.prev + "\nNext link: " + node.next + "\n");
			node = node.next;
		}
	}

	private class Node {
		E item;
		Node next;
		Node prev;

		public Node(E element) {
			item = element;
		}

		@Override
		public String toString() {
			return item.toString();
		}
	}
}