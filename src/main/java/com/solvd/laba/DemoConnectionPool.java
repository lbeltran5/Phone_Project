package com.solvd.laba;

import com.solvd.laba.multiThreads.*;

import java.util.concurrent.*;

public class DemoConnectionPool {

        public static void main(String[] args) {
            ConnectionPool connectionPool = ConnectionPool.getInstance();

            // Task 2: Acquiring connections
            for (int i = 1; i <= 5; i++) {
                new Thread(() -> {
                    try {
                        Connection connection = connectionPool.getConnection().get(); // Get the connection from CompletableFuture
                        System.out.println("Connection acquired by Thread: " + Thread.currentThread().getName());
                        // Perform operations with the connection
                        // ...

                        Thread.sleep(2000); // Simulate some work being done with the connection

                        connectionPool.releaseConnection(connection);
                        System.out.println("Connection released by Thread: " + Thread.currentThread().getName());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            // Task 3: Waiting for connections
            for (int i = 1; i <= 2; i++) {
                new Thread(() -> {
                    try {
                        Connection connection = connectionPool.getConnection().get(); // Get the connection from CompletableFuture
                        System.out.println("Connection acquired by Thread: " + Thread.currentThread().getName());
                        // Perform operations with the connection
                        // ...

                        Thread.sleep(2000); // Simulate some work being done with the connection

                        connectionPool.releaseConnection(connection);
                        System.out.println("Connection released by Thread: " + Thread.currentThread().getName());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            // Delay the termination of the program to allow tasks to complete
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Shutdown the thread pool after tasks are completed
            connectionPool.threadPool.shutdown();
        }
}