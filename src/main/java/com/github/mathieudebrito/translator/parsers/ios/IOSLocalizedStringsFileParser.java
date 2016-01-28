package com.github.mathieudebrito.translator.parsers.ios;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.parsers.FileParser;
import com.google.common.base.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IOSLocalizedStringsFileParser implements FileParser {

    public static final boolean LOG_ENABLED = true;

    @Override
    public Map<String, String> readEntries(String path, List<String> fileNamesFrom, Language languageFrom) {

        Map<String, String> entries = new TreeMap<String, String>();
        for (String fileName : fileNamesFrom) {
            entries.putAll(readEntries(path, fileName, languageFrom));
        }
        return entries;
    }

    private Map<String, String> readEntries(String path, String fileNameFrom, Language languageFrom) {

        Map<String, String> entries = new TreeMap<String, String>();

        try {

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();
            try {

                File file = new File(getFilename(path, fileNameFrom, languageFrom));
                br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    line = line.trim();

                    boolean isEmpty = Strings.isNullOrEmpty(line);
                    boolean beginWithQuote = line.startsWith("\"");
                    boolean containsEqual = line.contains("=");
                    boolean endsWithSemiColon = line.endsWith(";");

                    if (!isEmpty && beginWithQuote && containsEqual && endsWithSemiColon) {
                        String[] keyValue = line.trim().replace("\"", "").replace(";", "").split("=");

                        String key = keyValue[0].trim();
                        String value = keyValue[1].trim();

                        System.out.println(key + " = " + value);
                        entries.put(key, value);
                    } else {
                        System.out.println("[SKIPPED] line : '" + line + "'");
                    }
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

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("[ERROR] file may not be found : " + getFilename(path, fileNameFrom, languageFrom));
            return null;
        }

        return entries;
    }

    @Override
    public String decode(String text) {

        return text.trim();
    }

    @Override
    public String getFilename(String path, String fileNameFrom, Language language) {
        return path + "/Base.lproj/Localizable.strings";
    }
}
