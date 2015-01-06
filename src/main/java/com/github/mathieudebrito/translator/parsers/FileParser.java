package com.github.mathieudebrito.translator.parsers;

import com.github.mathieudebrito.translator.Language;

import java.util.Map;

public interface FileParser {
    public Map<String, String> readEntries(String path, Language language);

    public String decode(String text);

    public String getFilename(String path, Language language);
}
