package com.mdb.utils.translate.generators;

import com.mdb.utils.translate.Language;

import java.util.List;
import java.util.Map;

public interface FileGenerator {
    public void writeEntries(String pathTranslated, Language languageTo, Map<String, String> translation);

    public String encode(String text);

    public List<String> getFileNames(String path, Language languageTo);
}
