package com.mdb.utils.translate.generators;

import com.mdb.utils.translate.utils.Files;
import com.mdb.utils.translate.Language;

import java.util.Map;

public abstract class PlainTextFileGenerator implements FileGenerator {

    @Override
    public void writeEntries(String path, Language language, Map<String, String> translations) {

        StringBuilder content = new StringBuilder();

        for (String key : translations.keySet()) {
            String value = translations.get(key);
            content = content.append(value);
        }

        Files.write(getFileNames(path, language), content.toString());
    }

    @Override
    public String encode(String text) {
        return text;
    }

}
