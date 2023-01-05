package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\1.txt";
        System.out.println(Paths.get(filename));
        byte[] inputByte = { 0 };
        long startTime, endTime;
        inputByte = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte sb : inputByte){
            outputStringBuilder.append((char)sb);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
