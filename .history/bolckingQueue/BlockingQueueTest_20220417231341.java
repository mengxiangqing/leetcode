package bolckingQueue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Path.of("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /opt/jdk): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();
            Runnable enumerator = ()->{
                try{
                    enumerate(Path.of(directory));
                    queue.put(DUMMY);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private static void enumerate(Path directory) {
        try (Stream<Path> children = Files.list(directory)) {
            for (Path child : children.collect(Collectors.toList())) {
                if (Files.isDirectory(child))
                    enumerate(child);
                else {
                    queue.put(child);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
