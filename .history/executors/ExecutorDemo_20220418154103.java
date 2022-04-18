package executors;

import java.nio.file.Path;
import java.util.Scanner;

/**
 * 演示如何使用callable 和 执行器
 */
public class ExecutorDemo {
    /**
     *
     * @param word
     * @param path
     * @return
     */
    public static long occurrences(String word, Path path) {
        try (var in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext()) {
                if (in.next().equals(word))
                    count++;
            }
            return count;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }

    }
}
