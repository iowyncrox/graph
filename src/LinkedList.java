import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

	private int numberOfElements;
	private Node<T> head;

	public LinkedList() {
		numberOfElements = 0;
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return numberOfElements;
	}

	public void insertFirst(T data) {
		head = new Node<T>(data, head);
		numberOfElements++;
	}

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {

		private Node<T> currentNode;

		public LinkedListIterator() {
			currentNode = head;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();

			T temp = currentNode.data;
			currentNode = currentNode.next;
			return temp;
		}

	}
}
