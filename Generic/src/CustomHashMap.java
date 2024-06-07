public class CustomHashMap <K,V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size = 0;

    public void put(K key, V value) {
        int index = calculateIndex(key.hashCode());
        Entry<K, V> newHash = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newHash;
            size++;
        } else {
            Entry<K,V> current = table[index];
            Entry<K,V> prev = null;
            while (current != null) {
                if(current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = newHash;
            size++;
        }

    }

    public V get(K key) {
        int index = calculateIndex(key.hashCode());
        if(table[index].key.equals(key)) {
            return table[index].value;
        }
        else {
            Entry<K,V> current = table[index];
            while (current != null) {
                if(current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = calculateIndex(key.hashCode());
        if(table[index].key.equals(key)) {
            table[index] = table[index].next;
        }
        else {
            Entry<K,V> current = table[index];
            Entry<K,V> prev = null;
            while (current != null) {
                if(current.key.equals(key)) {
                    prev.next = current.next;
                }
                prev = current;
                current = current.next;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear()
    {
        Entry<K,V>[] temp;
        if((temp = table)!=null && size > 0)
        {
            for(int i = 0; i < temp.length; i++)
            {
                temp[i] = null;
            }
            size = 0;
        }
    }

    public int calculateIndex(int  hashcode) {
        return Math.abs(hashcode% table.length);
    }


    static class Entry <K,V>{
        K key;
        V value;
        Entry<K,V> next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
