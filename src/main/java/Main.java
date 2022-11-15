public class Main {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Создаю потоки...");

        ThreadGroup myThreadsGroup = new ThreadGroup("My Threads Group");

        final MyThread thread1 = new MyThread(myThreadsGroup, "поток 1");
        final MyThread thread2 = new MyThread(myThreadsGroup, "поток 2");
        final MyThread thread3 = new MyThread(myThreadsGroup, "поток 3");
        final MyThread thread4 = new MyThread(myThreadsGroup, "поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);
        System.out.println("Завершаю все потоки.");

        myThreadsGroup.interrupt();

    }
}
