package fixed_thread_pool;

import utils.PowPrinter;

public class FixedMain {

    private final PowFixedExecutors powCachedExecutors = new PowFixedExecutors();

    public FixedMain() throws InterruptedException {
        Runnable task;
        for (int i = 1; i <= 10; i++) {
            task = new PowPrinter(i);
            powCachedExecutors.execute(task);
            Thread.sleep(200);
        }

        powCachedExecutors.shutDown();
        waitForExecutorsFinish();
        System.out.printf("El número máximos de hilo usados ha sido: " + powCachedExecutors.getLargestPoolSize());
    }

    private void waitForExecutorsFinish() {
        while (!powCachedExecutors.isTerminated()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("La cosa terminó mal");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new FixedMain();
    }
}
