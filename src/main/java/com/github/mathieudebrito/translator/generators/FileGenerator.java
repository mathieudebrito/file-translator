package com.github.mathieudebrito.translator.generators;

import com.github.mathieudebrito.translator.Language;

import java.util.List;
import java.util.Map;

public interface FileGenerator {
    public void writeEntries(String pathTranslated, Language languageTo, Map<String, String> translation);

    public String encode(String text);

    public List<String> getFileNames(String path, Language languageTo);
}
