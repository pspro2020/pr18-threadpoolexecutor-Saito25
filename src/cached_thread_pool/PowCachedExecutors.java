package cached_thread_pool;

import utils.MyThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PowCachedExecutors {
    private final ThreadPoolExecutor threadPoolExecutor;

    public PowCachedExecutors() {
        threadPoolExecutor =
                (ThreadPoolExecutor) Executors.newCachedThreadPool(new MyThreadFactory("Hilo"));
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
