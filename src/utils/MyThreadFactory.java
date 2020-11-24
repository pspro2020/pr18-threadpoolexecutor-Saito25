package utils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private int count = 0;
    private final String baseName;

    public MyThreadFactory(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, baseName + "-" + count++);
    }

}