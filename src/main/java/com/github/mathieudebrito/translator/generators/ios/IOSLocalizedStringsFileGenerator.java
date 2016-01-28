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
    public void writeEntries(String path, String fileNameTo, Language language, Map<String, String> translations) {

        StringBuilder content = new StringBuilder();

        for (String key : translations.keySet()) {
            String value = translations.get(key);
            content = content.append("\"" + key + "\" = \"" + value + "\";" + Files.BR);
        }

        Files.write(getFileNames(path, fileNameTo, language), content.toString());
    }

    @Override
    public String encode(String text) {

        return text;
    }

    @Override
    public List<String> getFileNames(String path, String fileNameTo, Language language) {

        List<String> fileNames = new ArrayList<String>();

        String fileNamePrefix = path + "/";
        String fileNameSuffix = ".lproj/Localizable.strings";
        if (language.toString().equalsIgnoreCase(Language.CHINESE_SIMPLIFIED.toString())) {
            fileNames.add(fileNamePrefix + "zh-Hans" + fileNameSuffix);
        } else if (language.toString().equalsIgnoreCase(Language.CHINESE_TRADITIONAL.toString())) {
            fileNames.add(fileNamePrefix + "zh-Hant" + fileNameSuffix);
        } else if (language.toString().equalsIgnoreCase(Language.NORWEGIAN.toString())) {
            fileNames.add(fileNamePrefix + "nb" + fileNameSuffix);
        } else if (language.toString().equalsIgnoreCase(Language.PORTUGUESE.toString())) {
            fileNames.add(fileNamePrefix + "pt" + fileNameSuffix);
            fileNames.add(fileNamePrefix + "pt-PT" + fileNameSuffix);
        } else if (language.toString().equalsIgnoreCase(Language.SPANISH.toString())) {
            fileNames.add(fileNamePrefix + "es" + fileNameSuffix);
            fileNames.add(fileNamePrefix + "es-MX" + fileNameSuffix);
        } else {
            fileNames.add(fileNamePrefix + language.toString() + fileNameSuffix);
        }

        return fileNames;
    }
}
