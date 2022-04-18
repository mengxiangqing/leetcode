package executors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
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
     *
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

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /opt/jdk): ");
            String start = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String word = in.nextLine();
            //获得目录下所有的后代
            Set<Path> files = descendants(Path.of(start));

            // 添加任务列表
            var tasks = new ArrayList<Callable<Long>>();
            for (Path file : files) {
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            ExecutorService executor = Executors.newCachedThreadPool();

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for (Future<Long> result : results) {
                total += result.get();
            }
            Instant endTime = Instant.now();
            System.out.println("Occurrences of " + word + ": " + total);
            System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + " ms");

            var searchTasks = new ArrayList<Callable<Path>>();
            for (Path file : files) {
                searchTasks.add(searchForTask(word, file));
            }
            Path found = executor.invokeAny(searchTasks);
            System.out.println(word + " occurs in: " + found);

            if (executor instanceof ThreadPoolExecutor)
                System.out.println("Largest pool size: " + ((ThreadPoolExecutor) executor).getLargestPoolSize());
            executor.shutdown();
        }
    }
}
