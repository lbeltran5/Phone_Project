package com.solvd.laba.multiThreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
    private static final int MAX_POOL_SIZE = 10;

    private BlockingQueue<Connection> pool;
    private ExecutorService threadPool;

    private ConnectionPool(int poolSize) {
        pool = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
        threadPool = Executors.newFixedThreadPool(poolSize);
        initializePool(poolSize);
    }

    private void initializePool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            // use to load connections asynchronous
            threadPool.execute(() -> {
                pool.offer(createConnection());
                System.out.println("Connection added to the pool: " + Thread.currentThread().getName());
            });
        }

        threadPool.shutdown();
    }

    // This method will try to retrieve connection from pool using poll method
    // it has a timeout of 5 sec, which meand that if a connection is not available within the time it creates a new one
    public Connection getConnection() throws InterruptedException {
        Connection connection = pool.poll(5, TimeUnit.SECONDS);

        if (connection == null) {
            connection = createConnection();
            System.out.println("New connection created: " + Thread.currentThread().getName());
        }

        return connection;
    }

    // this method allows us to release connections to be back into the pool using offer method
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    private Connection createConnection() {
        // Mocked implementation for simplicity
        return new Connection();
    }

    // Singleton pattern to ensure a single instance of the pool
    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool(5);
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }
}
