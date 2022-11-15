import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // Creating pull of threads
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Creating tasks. Number of tasks you need to create as a parameter
        List<MyCallable> taskList = createTasks(5);

        // Run 1 of these 2 methods
        runInvokeAny(taskList, threadPool);
        //runInvokeAll(taskList, threadPool);

    }

    // Method to create tasks
    public static List<MyCallable> createTasks(int number) {

        List<MyCallable> taskList = new ArrayList<>();

        System.out.println("Создаю потоки...");

        for (int i = 0; i < number; i++) {
            MyCallable task = new MyCallable();
            taskList.add(task);
        }
        return taskList;
    }

    // Method to call invokeAny and get first fastest result
    public static void runInvokeAny(List<MyCallable> taskList, ExecutorService threadPool) {

        Integer result;

        try {
            result = threadPool.invokeAny(taskList);
            System.out.println("Завершаю все потоки.");
            threadPool.shutdown();
            System.out.println();
            System.out.println("Результат - " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Method to call invokeAll and get all results
    public static void runInvokeAll(List<MyCallable> taskList, ExecutorService threadPool) {

        Integer result;
        List<Future<Integer>> resultList = null;

        // Getting results
        try {
            resultList = threadPool.invokeAll(taskList);
            System.out.println("Завершаю все потоки.");
            threadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        // Printing results
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> future = resultList.get(i);
            try {
                result = future.get();
                System.out.println("Результат - " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
