import java.util.Arrays;

public class CustomLinkedList <E>{
    private Node<E>head;
    private Node<E>tail;
    private int size;

    public void add(E value)
    {
        Node<E> newNode = new Node<>(value);
        if(head == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public void remove(int index) {
        Node<E> temp = getNode(index);
        Node<E> prev = temp.prev;
        Node<E> next = temp.next;
        if(prev == null)
        {
            head = next;
            temp.next = null;
        }
        else if(next == null)
        {
            tail = prev;
            temp.prev = null;
        }
        else
        {
            next.prev = prev;
            prev.next = next;
        }
        temp.data = null;
        size--;
    }
    public E get (int index)
    {
        Node<E> node = getNode(index);
        return node.data;
    }

    private Node getNode(int index)
    {
        Node<E> temp = null;
        if(index >=0 && index < size)
        {
            if(index == 0)
            {
                temp = head;
            }
            else if(index < (size >> 1))
            {
                temp = head;
                for(int i = 0; i < index; i++)
                {
                    temp = temp.next;
                }
            }
            else if(index == size -1)
            {
                temp = tail;
            }
            else if(index < size - 1)
            {
                temp = tail;
                for(int i = size- 1; i > index; i--)
                {
                    temp  = temp.prev;
                }
            }
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
        return temp;
    }
    public void clear()
    {
        Node<E> temp = head;
        for(int i = 0; i < size; i++)
        {
            Node<E> nextTemp = temp.next;
            temp.data = null;
            temp.next = null;
            temp.prev = null;
            temp = nextTemp;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    static class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;
        public Node(E data){
            this.data = data;
        }
    }

@Override
    public String toString()
    {
        E [] value = (E[]) new Object[size];
        Node<E> temp = head;
        for(int i = 0; i < size; i++)
        {
            value[i] = temp.data;
            temp = temp.next;
        }
        return Arrays.toString(value);
    }

}
