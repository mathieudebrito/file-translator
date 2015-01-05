package com.mdb.utils.translate;

import java.util.Map;

public interface FileGenerator {
    public void writeEntries(String pathTranslated, Language languageTo, Map<String, String> translation);

    public String encode(String text);

    public String getFilename(String path, Language languageTo);
}
