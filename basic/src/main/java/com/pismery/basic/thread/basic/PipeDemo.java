package com.pismery.basic.thread.basic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipeDemo {

    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        String data = "Pipe send data.....";
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            try {
                writeBuffer.put(data.getBytes("utf-8"));
                writeBuffer.flip();

                Thread.sleep(1000L);

                while (writeBuffer.hasRemaining())
                    pipe.sink().write(writeBuffer);

                System.out.println("Write done");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            try {
                int total = 0;

                while (total < data.getBytes().length) {
                    total += pipe.source().read(readBuffer);
                }

                System.out.println("Read in pipe: "+new String(readBuffer.array()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

}
