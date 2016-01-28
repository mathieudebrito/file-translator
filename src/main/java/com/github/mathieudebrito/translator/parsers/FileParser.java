package com.github.mathieudebrito.translator.parsers;

import com.github.mathieudebrito.translator.Language;

import java.util.List;
import java.util.Map;

public interface FileParser {
    Map<String, String> readEntries(String path, List<String> fileName, Language language);

    String decode(String text);

    String getFilename(String path, String fileName, Language language);
}
