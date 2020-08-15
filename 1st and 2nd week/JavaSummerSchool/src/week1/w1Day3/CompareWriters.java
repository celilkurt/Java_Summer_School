package week1.w1Day3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CompareWriters {

    public static void main(String[] args) {

        bufferWriter("Hello world! It's a example\n",1000000);
        writer("Hello world! It's a example\n",1000000);

    }

    static void bufferWriter(String str,int testNum){

        File file = new File("bufferwriter.txt");
        try {

            long start = System.currentTimeMillis();
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            for (int i = 0; i < 1000000; i++)
                bufferWriter.write("Hello World! It's a example\n");

            bufferWriter.close();
            System.out.println("BufferWriter: " + (System.currentTimeMillis() - start));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void writer(String str,int testNum){

        File file = new File("fileWriter.txt");
        try {

            long start = System.currentTimeMillis();
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < 1000000; i++)
                writer.write("Hello World! It's a example\n");

            writer.close();
            System.out.println("FileWriter: " + (System.currentTimeMillis() - start));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
