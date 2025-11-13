package javainter.threadings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.EmptyStackException;

public class FileTool {
    public static void copy(String src, String destination) throws Exception{

        /*
        Flux pour les fichiers:
        FileInputStream, FileOutputStream: flux binaires lecture et écriture char/char
        FileReader, FileWriter: flux caractères : lecture et écriture ligne/ligne
         */

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(destination);

        int tmp = fis.read();

        while ((tmp = fis.read()) != -1){
            fos.write(tmp);
        }



        fis.close();
        fos.close();

    }
}
