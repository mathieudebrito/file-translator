package com.github.mathieudebrito.translator.generators.ios;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.generators.FileGenerator;
import com.github.mathieudebrito.translator.utils.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IOSLocalizedStringsFileGenerator implements FileGenerator {

    public static String[] specialCharacters = new String[]{"'", "\"", "<", ">"};

    @Override
    public void writeEntries(String path, Language language, Map<String, String> translations) {

        StringBuilder content = new StringBuilder();

        for (String key : translations.keySet()) {
            String value = translations.get(key);
            content = content.append("\"" + key + "\" = \"" + value + "\";" + Files.BR);
        }

        Files.write(getFileNames(path, language), content.toString());
    }

    @Override
    public String encode(String text) {

        return text;
    }

    @Override
    public List<String> getFileNames(String path, Language language) {

        List<String> fileNames = new ArrayList<String>();

        String fileName = path + "/";
        if (language.toString().equalsIgnoreCase(Language.CHINESE_SIMPLIFIED.toString())) {
            fileName = fileName.concat("zh-rCN");
        } else if (language.toString().equalsIgnoreCase(Language.CHINESE_TRADITIONAL.toString())) {
            fileName = fileName.concat("zh-rTW");
        } else {
            fileName = fileName.concat(language.toString());
        }

        fileName = fileName.concat(".lproj/Localizable.strings");

        fileNames.add(fileName);

        return fileNames;
    }
}
