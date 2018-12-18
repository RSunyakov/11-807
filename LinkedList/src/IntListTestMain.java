import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntListTestMain {
    public static void main(String[] args) {
        TLinkedList<Integer> k = new TLinkedList<>();
        k.add(123);
        TLinkedList<Integer> p = new TLinkedList<>();
        for (int i = 0; i < 10; i++) {
            p.add(i);
        }
        k.addAll(p);
        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i));
        }
    }
    }
