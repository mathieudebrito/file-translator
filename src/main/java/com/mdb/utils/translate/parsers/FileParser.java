package com.mdb.utils.translate.parsers;

import com.mdb.utils.translate.Language;

import java.util.Map;

public interface FileParser {
    public Map<String, String> readEntries(String path, Language language);

    public String decode(String text);

    public String getFilename(String path, Language language);
}
