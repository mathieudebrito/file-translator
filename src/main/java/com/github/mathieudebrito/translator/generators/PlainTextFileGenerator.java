package com.github.mathieudebrito.translator.generators;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.utils.Files;

import java.util.Map;

public abstract class PlainTextFileGenerator implements FileGenerator {

    @Override
    public void writeEntries(String path, String fileName, Language language, Map<String, String> translations) {

        StringBuilder content = new StringBuilder();

        for (String key : translations.keySet()) {
            String value = translations.get(key);
            content = content.append(value);
        }

        Files.write(getFileNames(path, fileName, language), content.toString());
    }

    @Override
    public String encode(String text) {
        return text;
    }

}
