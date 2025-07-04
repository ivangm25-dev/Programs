package core;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerciseThread {

    ArrayList<String> words = new ArrayList<>() {{
        add("En");
        add(" Banco");
        add(" Azteca");
        add(" Sueñas");
        add(" Decides");
        add(" Logras");
    }};

    /**
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void executePoolTread() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(6);
        int count = 0;
        for (String word: words) {
            count ++;
            String name = " Hilo " + count + "-> ";
            NewThread thread = new NewThread(word);
            service.submit(thread).get();
        }
        service.shutdown();
        await();
    }

    /**
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void executePoolTreadDetail() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(6);
        int count = 0;
        for (String word: words) {
            count ++;
            String name = " Hilo " + count + "-> ";
            NewThread thread = new NewThread(word, name);
            service.submit(thread).get();
        }
        service.shutdown();
        await();
    }

    /**
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void executeTreadSleep() throws ExecutionException, InterruptedException {
        int count = 0;
        for (String word: words) {
            count ++;
            NewThread thread = new NewThread(word, count*1000);
            thread.start();
        }
        await();
    }

    /**
     *
     */
    private void await(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
