package com.mdb.utils.translate.parsers;

import com.mdb.utils.translate.Language;
import com.mdb.utils.translate.utils.Files;

import java.util.Map;
import java.util.TreeMap;

public abstract class PlainTextFileParser implements FileParser {

    public static final boolean LOG_ENABLED = true;

    @Override
    public Map<String, String> readEntries(String path, Language languageFrom) {

        Map<String, String> entries = new TreeMap<String, String>();

        String content = Files.read(getFilename(path, languageFrom));

        entries.put("content", content);

        return entries;
    }

}
