package com.mdb.utils.translate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public static final String BR = "\n";
    public static final String TAB = "\t";

    public static String read(String fileName) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {

            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        return sb.toString();
    }


    public static void write(String fileName, String content) {
        BufferedWriter bw = null;

        try {
            (new File(fileName)).getParentFile().mkdirs();

            FileWriter fwLang = new FileWriter(fileName);
            bw = new BufferedWriter(fwLang);
            bw.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
