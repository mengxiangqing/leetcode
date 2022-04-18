package executors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
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

    /**
     * 返回给定目录的所有后代
     *
     * @param rootDir
     * @return
     * @throws IOException
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.filter(Files::isRegularFile).collect(Collectors.toSet());

        }
    }
    /**
     * 生成一个在文件中搜索单词的任务
     * @param word
     * @param path
     * @return
     */
    public static Callable<Path> searchForTask(String word, Path path) {
        return () -> {
            try (var in = new Scanner(path)) {
                while (in.hasNext()) {
                    if (in.next().equals(word))
                        return path;
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Search in " + path + " canceled.");
                        return null;
                    }
                }
            }
            throw new NoSuchElementException();
        };
    }

    public static void main(String[] args) {
        try(var in = new Scanner(System.in))
        {

        }
    }
}
