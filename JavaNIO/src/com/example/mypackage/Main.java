package com.example.mypackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("input string " + new String(inputString));
            System.out.println("int 1 " + readBuffer.getInt());
            System.out.println("int 2 " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int 3 " + readBuffer.getInt());

        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
