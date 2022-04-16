package priorityQueue;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iteraing over elements");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements");
        while(!pq.isEmpty())
        {
            System.out.println(pq.remove());
        }
        var staff = new LinkedList<String>(List.of("string1","string2","string3"));
        lookAt(Collections.unmodifiableList(staff));
        staff.set(1, "element");
        lookAt(Collections.unmodifiableList(staff));

    }

    private static void lookAt(List<String> unmodifiableList) {
        Iterator<String> iterator = unmodifiableList.iterator();
        while (iterator.hasNext()) {
           System.out.println(iterator.next());
        }
    }
}
