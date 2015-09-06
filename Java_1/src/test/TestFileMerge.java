package test;

import static java.lang.System.out;  
  
import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.nio.ByteBuffer;  
import java.nio.channels.FileChannel;  
import java.util.Arrays;  

import org.apache.commons.io.FileUtils;

 
public class TestFileMerge {  
      
    public static final int BUFSIZE = 1024 * 8;  
      
    public static void mergeFiles(String outFile, String[] files) {  
       FileChannel outChannel = null;  
        out.println("Merge " + Arrays.toString(files) + " into " + outFile);  
        try {  
            outChannel = new FileOutputStream(outFile).getChannel();  
           for(String f : files){  
                FileChannel fc = new FileInputStream(f).getChannel();   
                ByteBuffer bb = ByteBuffer.allocate(BUFSIZE);  
                while(fc.read(bb) != -1){  
                    bb.flip();  
                    outChannel.write(bb);
                    bb.clear();  
               }  
                fc.close();  
            }  
           out.println("Merged!! ");  
        } catch (IOException ioe) {  
            ioe.printStackTrace();  
        } finally {  
            try {if (outChannel != null) {outChannel.close();}} catch (IOException ignore) {}  
        }  
    }  
    
	public static void merge(String outFile, String[] files)
	{
		File file = new File(outFile);
		
		try {
			for(String f : files)
			{
				FileUtils.writeLines(file, FileUtils.readLines(new File(f)), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
      
    public static void main(String[] args) {  
    	String[] strs = new String[]{"D:/out/N109-常州.txt", "D:/out/N109-淮安.txt", "D:/out/N109-连云港.txt", "D:/out/N109-南京.txt", "D:/out/N109-南通.txt", "D:/out/N109-苏州.txt", "D:/out/N109-泰州.txt", "D:/out/N109-无锡.txt", "D:/out/N109-宿迁.txt", "D:/out/N109-徐州.txt", "D:/out/N109-盐城.txt", "D:/out/N109-扬州.txt", "D:/out/N109-镇江.txt"};
    	merge("D:\\out\\n1000.txt", strs);  
    }  
}  

