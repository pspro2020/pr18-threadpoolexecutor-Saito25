package fixed_thread_pool;

import utils.MyThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PowFixedExecutors {
    private final ThreadPoolExecutor threadPoolExecutor;
    private final int numberOfProccessor = Runtime.getRuntime().availableProcessors();

    public PowFixedExecutors() {
        threadPoolExecutor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfProccessor, new MyThreadFactory("Hilo"));
    }

    public void execute(Runnable executable) {
        threadPoolExecutor.execute(executable);
    }

    public void shutDown() {
        threadPoolExecutor.shutdown();
    }

    public boolean isTerminated() {
        return threadPoolExecutor.isTerminated();
    }

    public int getLargestPoolSize() {
        return threadPoolExecutor.getLargestPoolSize();
    }
}
