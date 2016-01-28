package com.github.mathieudebrito.translator.parsers;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.utils.Files;
import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlainTextFileParser implements FileParser {

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

        String content = Files.read(getFilename(path, fileNameFrom, languageFrom));

        entries.put("content", content);

        return entries;
    }

    @Override
    public String decode(String text) {
        text = text.replace("\n", "<br />");
        text = text.replace("<br>", "<br />");
        return text;
    }

    @Override
    public String getFilename(String path, String fileNameFrom, Language language) {
        return path + "/" + PlayStoreLanguage.getPreciseLanguage(language) + "/" + fileNameFrom;
    }
}
