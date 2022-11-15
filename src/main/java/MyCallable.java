import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public static int count = 0;

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1500);
        count++;
        System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
        System.out.println("Count is - " + count + " from " + Thread.currentThread().getName());
        return count;
    }

}
