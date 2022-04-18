package executors;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 演示如何使用callable 和 执行器
 */
public class ExecutorDemo {
    /**
     * 统计给定单词在文件中出现的次数
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

    public static Set<Path> descendants(Path rootDir) {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.filter(Files::isRegularFile).collect(Collectors.toSet());

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
