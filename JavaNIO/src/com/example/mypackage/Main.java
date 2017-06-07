package com.example.mypackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
	// create channel to read and write from file
        // create channel from open file
        try(FileOutputStream binFile = new FileOutputStream("data.dat");FileChannel binChannel = binFile.getChannel(); ){
//            FileInputStream file = new FileInputStream("data.txt");
            //FileChannel channel = file.getChannel();
            // only open to reading
            // creating with FileInputStream or FileOutputStream is only one directional channel
            // usually channels can do both
            // must specify size of buffer to be used with channel
            //java 8 made it easier to use Files class was introduced in java 7
            // read whole file in one shot --> Java 8 specific

//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            // each call to files.write opens file, writes and closes file
//            // use stringbuilder to do several lines in one write
//            // writes bytes not strings
//
//            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
//
//
//            List<String> lines = Files.readAllLines(dataPath);
//            for(String line : lines){
//                System.out.println(line);
//            }

            // BINARY FORMAT

            // buffer capacity is number of elements that it can contain
            // buffer position is index of the next element that should be read or written
            // cant be > buffer capacity
            // buffer mark --> used by buffer reset method -> if this is called then buffer is
            // moved back to its marked position.

            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello world!".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip(); // changing from writing to buffer to writing to channel
            binChannel.write(buffer);
            



//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            // allocate creates new buffer
//            buffer.put(outputBytes);
//            // wrap method wraps byte array into buffer
//            // buffer is backed by byte array
//            // modifications to buffer change array
//            // mods to array change buffer
//
//            //calling wrap method telling runtime that yuo want to use
//            // byteArray as the buffer
//            // sets pos of buffer to 0
//            // buffer capacity set to length of byteArray
//            // mark set to undefined
//
//            buffer.flip();
//
//            int numBytes = binChannel.write(buffer);
//            System.out.println("num bytes written was " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip(); // reset position to zero
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("num bytes written was " + numBytes);
//
//            // always call when you need to reset buffer position to zero
//            // call when flipping from reading to writing
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip(); // reset position to zero
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("num bytes written was " + numBytes);
//
//            // now close channel and stream unless using try with resources
//
//            //READ DATA BACK INTO APPLICATION
//
//            //writeUTF writes length so reader knows how many to read back
//
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            byte[] b = new byte[outputBytes.length];
////            ra.read(b);
////            System.out.println(new String(b));
////
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////
////            System.out.println("int1 " + int1);
////            System.out.println("int 2 " + int2);
//
//            // can use different IO package to read the file that was created
//
//            //NOW LETS READ WITH JAVA NIO
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            // outputBytes was never loaded into the buffer after being updated so flipping it resets it to prev value
//            long numBytesRead = channel.read(buffer);
//
//            if(buffer.hasArray()){
//                //System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("Byte buffer = " + new String(outputBytes));
//            }
//
//            //flip between each access of the buffer
//            // These are RELATIVE reads
//
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt()); // could pass index to getInt to avoid calling flip
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            System.out.println(intBuffer.getInt());
//
//
//
//            // This is an absolute read
//            // Chose index 0 to read from
//
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//
//            channel.close();
//            ra.close();

           // System.out.println("outputBytes =  " + new String(outputBytes));






        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
