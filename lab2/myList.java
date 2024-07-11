/**
	Лабораторная работа №2
	Семин Владислав
	ККСО-01-20
*/
package lab2;
import javax.security.auth.DestroyFailedException;

public class myList<T> {
	
	
	private class Node
	{
	
		private T data;
		private Node next;
	
		public Node (T data)
		{
			this.data = data;
			next = null;
		}
	
		public T getData ()
		{
			return data;
		}
	
		public Node getNext ()
		{
			return next;
		}
	
		public void setNext(Node next)
		{
			this.next = next;
		}
		
		public void Del ()
		{
			data = null;
			next = null;
		}
	}

	
	private Node head;
	private Node tail;
	private int quan;
	
	public int getQuan ()
	{
		return quan;
	}
	
	public myList ()
	{
		head = null;
		tail = null;
		quan = 0;
	}
	
	public void AddLast (T new_element)
	{	
		Node new_node = new Node(new_element);
		if (head == null)
			head = new_node;
		else if (tail == null)
		{
			head.setNext(new_node);
			tail = new_node;
		}
		else
		{
			tail.setNext(new_node);
			tail = new_node;
		}
		quan++;
	}
	
	public myList (myList<T> orig)
	{
		this();
		Node cur_node = orig.head; 
		while (cur_node != null)
		{
			AddLast(cur_node.getData());
			cur_node = cur_node.getNext();
		}
		quan = orig.quan;
	}
	
	public void AddFirst (T new_element)
	{
		Node new_node = new Node(new_element);
		new_node.setNext(head);
		if (tail == null)
			tail = head;
		head = new_node;
		quan++;
	}
	
	public void DelFirst () throws DestroyFailedException
	{
		if (head == null)
			throw new DestroyFailedException("Невозможно удалить первый элемент, так как список уже пуст");
		Node new_head = head.getNext();
		head.Del();
		head = new_head;
		if (head == tail)
			tail = null;
		quan --;
	}
	
	public void DelLast () throws DestroyFailedException
	{
		if (head == null)
			throw new DestroyFailedException("Невозможно удалить последний элемент, так как список уже пуст");
		if (tail == null)
		{
			head.Del();
			head = null;
			quan --;
			return;
		}
		Node cur_node = head;
		Node next_node = cur_node.getNext();
		while (next_node != tail)
		{
			cur_node = next_node;
			next_node = cur_node.getNext();
		}
		cur_node.setNext(null);
		tail.Del();
		if (cur_node == head)
			tail = null;
		else
			tail = cur_node;
		quan --;
	}
	
	public void DelData (T data) throws DestroyFailedException
	{
		if (head == null)
			throw new DestroyFailedException("Невозможно удалить элемент, так как список уже пуст");
		if (head.getData() == data)
		{
			DelFirst();
			return;
		}
		if (tail == null)
			throw new DestroyFailedException("Узла с таким значением не существует");
		if (tail.getData() == data)
		{
			DelLast();
			return;
		}
		Node cur_node = head;
		Node next_node = cur_node.getNext();
		while (next_node != null)
		{
			if (next_node.getData() == data)
				break;
			cur_node = next_node;
			next_node = cur_node.getNext();
		}
		if (next_node != null)
		{
			cur_node.setNext(next_node.getNext());
			next_node.Del();
			quan--;
		}
		else
			throw new DestroyFailedException("Узла с таким значением не существует");
	}
	
	public void Del ()
	{
		Node cur_node = head;
		while (cur_node != null)
		{
			Node next_node = cur_node.getNext();
			cur_node.Del();
			cur_node = next_node;
		}
		head = null;
		tail = null;
		quan = 0;
	}
	
	public String toString()
	{
		if (head == null)
			return "Нет элеметов";
		String list_string = new String();
		Node cur_node = head;
		while (cur_node != null)
		{
			list_string += cur_node.getData().toString() + " ";
			cur_node = cur_node.getNext();
		}
		return list_string;
	}
	
}