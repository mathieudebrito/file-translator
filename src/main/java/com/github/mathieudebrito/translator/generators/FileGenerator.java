package com.github.mathieudebrito.translator.generators;

import com.github.mathieudebrito.translator.Language;

import java.util.List;
import java.util.Map;

public interface FileGenerator {
    void writeEntries(String pathTranslated, String fileName, Language languageTo, Map<String, String> translation);

    String encode(String text);

    List<String> getFileNames(String path, String fileName, Language languageTo);
}
