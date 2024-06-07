import java.util.Arrays;

public class CustomQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T item)
    {
        Node<T> newNode = new Node<>(item);
        if(tail == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public int size()
    {
        return size;
    }
    public T peek()
    {
        if(head != null)
        {
            return head.data;
        }
        else
        {
            return null;
        }
    }

    public T poll()
    {
        if(head == null)
        {
            return null;
        }
        T data = head.data;
        head = head.next;
        if(head == null)
        {
            tail= null;
        }
        size--;
        return data;
    }
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
     static class Node<T>
     {
         T data;
         Node<T> next;
         public Node(T data) {
             this.data = data;
         }
     }
     @Override
     public String toString()
     {
         String [] str = new String[size];
         Node<T> current = head;
         for(int i = 0; i<size; i++)
         {
             str[i] = current.data.toString();
             current = current.next;
         }
         return Arrays.toString(str);
     }

}
