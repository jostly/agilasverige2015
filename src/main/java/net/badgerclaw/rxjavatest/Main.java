package net.badgerclaw.rxjavatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.util.async.Async;

import java.util.Random;

public class Main {

    public static Logger LOG = LoggerFactory.getLogger(Main.class);

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        new Main().runAsyncStream(new String[]{"alice", "bob", "charlie"});
    }

    public static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void simulateDelay() {
        sleep(random.nextInt(1000) + 5);
    }

    private void runSequential(String[] names) {

        LOG.info("Starting sequential dispatch");
        new IterativeDispatcher().dispatch(names);

    }

    private void runStream(String[] names) {

        LOG.info("Starting stream dispatch");
        new StreamDispatcher().dispatch(names);

    }

    private void runAsyncStream(String[] names) {

        LOG.info("Starting async stream dispatch");
        new AsyncStreamDispatcher().dispatch(names);
        sleep(10000);
    }

    // Helper function to avoid a cast when using Async.toAsync, and defaults to using Schedulers.io
    public static <T1, R> Func1<T1, Observable<R>> toAsync(final Func1<? super T1, ? extends R> func) {
        return Async.toAsync(func, Schedulers.io());
    }
}
