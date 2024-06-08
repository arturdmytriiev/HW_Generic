import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /////////////////////////////ArrayList//////////////
        CustomArrayList <String> list = new CustomArrayList<>();
        list.add("Array");
        list.add("List");
        System.out.println(list);
        list.clear();
        System.out.println(list);
        list.add("Clear");
        list.add("new");
        System.out.println("list.get(0) = " + list.get(0));
        list.remove(0);
        System.out.println("list.get(0) = " + list.get(0));

        /////LinkedList//////////////////////
        CustomLinkedList <String> list2 = new CustomLinkedList<>();
        list2.add("Array");
        list2.add("List");
        list2.add("New");
        list2.add("clear");
        list2.add("new");
        System.out.println("list2.get(0) = " + list2.get(0));
        list2.remove(2);
        System.out.println("list2.get(2) = " + list2.get(2));
        System.out.println("list2 = " + list2);
        list2.clear();
        System.out.println("list2.clear() = " + list2);

        /////////Queue///////////
        CustomQueue<String> queue = new CustomQueue<>();
        queue.add("Add");
        queue.add("Custom");
        queue.add("Queue");
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        queue.clear();
        System.out.println("queue = " + queue);
        queue.add("Add");
        queue.add("Custom");
        int size = queue.size();
        for(int i = 0; i<size; i++) {
            System.out.println("queue.poll() = " + queue.poll());
        }
        System.out.println("queue = " + queue);
        //////Stack//////////////
        CustomStack<String> stack = new CustomStack<>();
        stack.push("Add");
        stack.push("Custom");
        stack.push("Stack");
        stack.push("Stack");

        /////HashMap/////
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key1", "value4");
        map.put(null, "value5");
        map.remove("key1");
        System.out.println(map.get("key5"));
        System.out.println("map.get(null) = " + map.get(null));
    }
}
