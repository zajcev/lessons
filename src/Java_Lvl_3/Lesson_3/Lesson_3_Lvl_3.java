package Java_Lvl_3.Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lesson_3_Lvl_3 {
    public static void main(String[] args) {
       fileToByteArr("test.txt");
       mergeFiles();
    }

   private static void mergeFiles(){
       ArrayList<InputStream> ali = new ArrayList<>();
       FileOutputStream out = null;

       try {
           SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
           ali.add(new FileInputStream("test0.txt"));
           ali.add(new FileInputStream("test1.txt"));
           ali.add(new FileInputStream("test2.txt"));
           ali.add(new FileInputStream("test3.txt"));
           ali.add(new FileInputStream("test4.txt"));

           out = new FileOutputStream("out.txt");

           try {
             int rb = in.read();
               while(rb != -1){
                   out.write(rb);
                   rb = in.read();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }finally {
           try {
               out.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }

    private static void fileToByteArr(String path){
        FileInputStream in = null;

        try {
            in = new FileInputStream(path);

            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            while(in.read() != -1) {
                byteOut.write(in.read());
            }
            byte[] br = byteOut.toByteArray();
            ByteArrayInputStream byteIn = new ByteArrayInputStream(br);
            int x;
            while((x = byteIn.read()) != -1) {
                System.out.print(x + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}