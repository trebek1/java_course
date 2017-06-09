package com.example.mypackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) {

        try(FileOutputStream binFile = new FileOutputStream("data.dat");FileChannel binChannel = binFile.getChannel(); ){

            // writing to the file

            ByteBuffer buffer = ByteBuffer.allocate(100);

//            byte[] outputBytes = "Hello world!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);

            // put methods return the byte buffer so you can chain them together
//
            byte[] outputBytes = "Hello world!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip(); // changing from writing to buffer to writing to channel

            //SIX METHODS FROM SEEKABLE BYTE CHANNEL --> NEEDED FOR NIO RANDOM ACCESS
//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource






            binChannel.write(buffer);

            // reading from the file

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            // channel is safe for access by multiple concurrent threads
//            // always blocking
//
//            channel.read(readBuffer); // read data from file channel into buffer
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString); // transfers data from buffer to inputString
//            System.out.println("input string " + new String(inputString));
//            System.out.println("int 1 " + readBuffer.getInt());
//            System.out.println("int 2 " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int 3 " + readBuffer.getInt());

            //read in reverse order

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos); // set position
            channel.read(readBuffer); // read channel into buffer
            readBuffer.flip(); // flip buffer

            System.out.println("int 3 = " + readBuffer.getInt()); // write out integer
            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("int 2 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("int 1 = " + readBuffer.getInt());



            // Copy file to another using a channel

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();

            // must set position to zero
            // is position relative or absolute?
            // need to know index relative to current position

            channel.position(0);
            //long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
                long numTransferred = channel.transferTo(0,channel.size(), copyChannel);
            System.out.println("num transfered = " + numTransferred);
            channel.close();
            ra.close();
            copyChannel.close();


            // lets look at pipes
            // pipes transfer data between threads
            // one way connection
            // sync channel and source channel
            // write to sync, read from source
            //

            try{
                Pipe pipe = Pipe.open();

                Runnable writer = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Pipe.SinkChannel sinkChannel = pipe.sink(); // get sinkChannel
                            ByteBuffer buffer = ByteBuffer.allocate(56);

                            for(int i = 0; i<10; i++){
                                String currentTime = "The time is: " + System.currentTimeMillis();
                                buffer.put(currentTime.getBytes());
                                buffer.flip();

                                while(buffer.hasRemaining()){
                                    sinkChannel.write(buffer); // write to sinkChannel
                                }
                                buffer.flip();
                                Thread.sleep(100);
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };

                Runnable reader = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Pipe.SourceChannel sourceChannel = pipe.source();
                            ByteBuffer buffer = ByteBuffer.allocate(56);

                            for(int i = 0; i<10; i++){
                                int bytesRead = sourceChannel.read(buffer);
                                byte[] timeString = new byte[bytesRead];
                                buffer.flip();
                                buffer.get(timeString);
                                System.out.println("Reader Thread " + new String(timeString));
                                buffer.flip();
                                Thread.sleep(100);
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };

                new Thread(writer).start();
                new Thread(reader).start();


            }catch(IOException e){
                e.printStackTrace();
            }





//
//
//            // new part
//
//            byte[] outputString = "hello, world".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(newInt1Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(intBuffer);
//
//            // write to file, always use channel to access file after setting file to channel file -> binfile -> channel
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));

            // flip buffer when switching from reading to writing











        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
