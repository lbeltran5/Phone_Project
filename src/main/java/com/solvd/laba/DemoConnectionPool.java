package com.solvd.laba;

import com.solvd.laba.multiThreads.*;

public class DemoConnectionPool {

        public static void main(String[] args) {
            ConnectionPool connectionPool = ConnectionPool.getInstance();

            for (int i = 0; i < 7; i++) {
                Runnable task = () -> {
                    try {
                        Connection connection = connectionPool.getConnection();
                        Thread.sleep(3000); // 3k milliseconds to simulate work
                        connectionPool.releaseConnection(connection);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(task).start();
            }
        }
}