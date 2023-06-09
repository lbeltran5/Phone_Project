/*
package com.solvd.laba.multiThreads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
    private static final int MAX_POOL_SIZE = 10;

    public final BlockingQueue<Connection> pool;
    public final ExecutorService threadPool;
    public final AtomicInteger count;

    private ConnectionPool(int poolSize) {
        pool = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
        threadPool = Executors.newFixedThreadPool(poolSize);
        count = new AtomicInteger(0);
        initializePool(poolSize);
    }

    private void initializePool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                pool.offer(createConnection());
                System.out.println("Connection added to the pool: " + Thread.currentThread().getName());
            }, threadPool);

            future.thenRunAsync(() -> count.incrementAndGet());
        }
    }

    public CompletableFuture<Connection> getConnection() {
        CompletableFuture<Connection> connectionFuture = new CompletableFuture<>();

        threadPool.execute(() -> {
            Connection connection = pool.poll();
            if (connection != null) {
                connectionFuture.complete(connection);
            } else {
                CompletableFuture<Connection> newConnectionFuture = CompletableFuture.supplyAsync(this::createConnection, threadPool);
                newConnectionFuture.thenAccept(connectionFuture::complete);
            }
        });

        return connectionFuture;
    }

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

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        // Task 2: Acquiring connections
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                Connection connection = connectionPool.getConnection().join();
                System.out.println("Connection acquired by Thread: " + Thread.currentThread().getName());

                connectionPool.releaseConnection(connection);
                System.out.println("Connection released by Thread: " + Thread.currentThread().getName());
            }).start();
        }

        // Task 3: Waiting for connections
        for (int i = 1; i <= 2; i++) {
            new Thread(() -> {
                Connection connection = connectionPool.getConnection().join();
                System.out.println("Connection acquired by Thread: " + Thread.currentThread().getName());

                connectionPool.releaseConnection(connection);
                System.out.println("Connection released by Thread: " + Thread.currentThread().getName());
            }).start();
        }
    }
}*/
