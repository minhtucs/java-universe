package juniverse.core.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author tunm2
 */
public class FileIO2020 {
    
    static String srcFileName = "/data/dmp/audience-sql/audience_part_9.sql";
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        copyStream(srcFileName,  srcFileName + "_cloned");
//        copyByChunksConcurrently(srcFileName, srcFileName + "_cloned");
        
        System.err.println("## elapsed " + (System.currentTimeMillis() - start));
        System.exit(0);
    }
    
    static final int CHUNK_SIZE = 512 * 1024;
    static final int BUFF_SIZE = 8 * 1024;
    
    static void copyByChunksConcurrently(String srcFileName, String dstFileName) throws IOException {
        RandomAccessFile srcFile = new RandomAccessFile(srcFileName, "r");
        long fileSize = srcFile.length();
        System.err.println("file size: " + fileSize);
        
        long totalChunk = fileSize / CHUNK_SIZE + (fileSize % CHUNK_SIZE != 0 ? 1 : 0);
        for (int chunkNo = 0; chunkNo < totalChunk; chunkNo++) {
            copyChunk(srcFileName, dstFileName, chunkNo);
        }
    }

    private static void copyChunk(String srcFileName, String dstFileName, int chunkNo) throws IOException {
        RandomAccessFile srcChunkFile = new RandomAccessFile(srcFileName, "r");
        RandomAccessFile dstChunkFile = new RandomAccessFile(createIfNotExisted(dstFileName), "rw");
        
        int offset = chunkNo * CHUNK_SIZE;
        srcChunkFile.seek(offset);
        dstChunkFile.seek(offset);
        
        int totalRead = 0;
        int reads = 0;
        byte[] buffer = new byte[BUFF_SIZE];
        
        while ((reads = srcChunkFile.read(buffer, 0, BUFF_SIZE)) != -1) {
            int remain = CHUNK_SIZE - totalRead;
            int writes = remain < BUFF_SIZE ? remain : BUFF_SIZE;
            dstChunkFile.write(buffer, 0, writes);
            if (writes < BUFF_SIZE) {
                break;
            }
            totalRead += reads;
        }
    }
    
    static File createIfNotExisted(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
    
    static void copyStream(String srcFile, String dstFile) {
        try (
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(dstFile);
        ) {
            System.err.println("file size: " + fis.available());
            
            byte[] buffer = new byte[8*1024];
            while (fis.read(buffer) != -1) {
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
