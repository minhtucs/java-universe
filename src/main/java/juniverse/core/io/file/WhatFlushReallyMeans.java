package juniverse.core.io.file;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author tunm2
 */
public class WhatFlushReallyMeans {
    
    public static void main(String[] args) throws IOException {
//        flushFileOutputStream();
        flushBufferedOutputStream();
    }
    
    static void mappedByteBuffer() {
        
    }
    
    static void flushFileOutputStream() throws IOException {
        FileOutputStream fos = new FileOutputStream("/tmp/flush-file-output-stream.log");
        fos.write(1);
        fos.flush(); // nothing
        fos.getFD().sync(); // really sync data to physical device
        fos.close();
    }
    
    static void flushBufferedOutputStream() throws IOException {
        FileOutputStream fos = new FileOutputStream("/tmp/flush-buffered-output-stream.log");
        BufferedOutputStream bufOutStream = new BufferedOutputStream(fos);
        bufOutStream.write(1);
        bufOutStream.flush(); // just flush data in buffer to OS
        fos.getFD().sync(); // really sync data to physical device
        bufOutStream.close();
    }
    
    static void flushBufferedWriter() throws IOException {
        FileWriter fWriter = new FileWriter("/tmp/flush-buffered-writer.log");
        BufferedWriter bufWriter = new BufferedWriter(fWriter);
        bufWriter.append("hello world");
        bufWriter.flush();  // just flush data in buffer to OS
        bufWriter.close();
    }
    
    static void flushRandomAccessFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("/tmp/flush-random-access-file.log", "w");
        raf.write(1);
        raf.close();
    }
}
