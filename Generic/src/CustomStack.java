public class CustomStack <T>
{
    Node<T> top;
    int size;

    public void push(T data)
    {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek()
    {
        if(top == null)
        {
            return null;
        }
        return top.data;
    }
    public T pop()
    {
        if(top == null)
        {
            return null;
        }
        T currentData = top.data;
        top = top.next;
        size --;
        return currentData;
    }

    public void clear()
    {
        top = null;
        size = 0;
    }

    public void remove(int index)
    {

        if(index >= 0 && index < size)
        {
            if(index == 0)
            {
                top = top.next;
            }
            else
            {
                Node<T> temp = top.next;
                for(int i = 0; i < index-1; i++)
                {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size()
    {
        return size;
    }


    static class Node<T>
    {
        T data;
        Node<T> next;
        public Node(T data)
        {
            this.data = data;
        }
    }

}
