import java.util.Arrays;

public class CustomArrayList <E> {
 private Object [] data;
 private int size;

 public CustomArrayList() {
     data = new Object[10];
     size = 0;
 }

 public void add (E value)
 {
     if(size > data.length)
     {
         Object [] newData = new Object[data.length*2];
         System.arraycopy(data,0, newData , 0, data.length);
         data = newData;
     }
    data[size++] = value;
 }

 public void remove (int index)
 {
        if(index >= 0 && index < size)
        {
            System.arraycopy(data, index+1 , data, index, size - index - 1);
            data[--size] = null;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
 }

 public void clear()
 {
     for(int i = 0; i < size; i++)
     {
         data[i] = null;
     }
     size = 0;
 }

 public E get (int index)
 {
     if(index >= 0 && index < size)
     {
         return (E)data[index];
     }
     else
     {
         throw new IndexOutOfBoundsException();
     }
 }


 public int size ()
 {
     return size;
 }

 @Override
 public String toString()
 {
     String [] s = new String [size];
     for(int i = 0; i < size; i++)
     {
         s[i] = data[i].toString();
     }
     return Arrays.toString(s);
 }


}
