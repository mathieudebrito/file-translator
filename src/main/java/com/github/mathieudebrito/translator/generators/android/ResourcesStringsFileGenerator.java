package com.github.mathieudebrito.translator.generators.android;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.generators.FileGenerator;
import com.github.mathieudebrito.translator.utils.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResourcesStringsFileGenerator implements FileGenerator {

    public static String[] specialCharacters = new String[]{"'", "\"", "<", ">"};

    @Override
    public void writeEntries(String pathTo, String fileNameTo, Language language, Map<String, String> translations) {

        StringBuilder content = new StringBuilder();
        content = content.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + Files.BR);
        content = content.append("<resources>" + Files.BR);

        for (String key : translations.keySet()) {
            String value = translations.get(key);
            content = content.append(Files.TAB + "<string name=\"" + key + "\">" + value + "</string>" + Files.BR);
        }

        content = content.append("</resources>");

        Files.write(getFileNames(pathTo, fileNameTo, language), content.toString());
    }

    @Override
    public String encode(String text) {

        boolean contains = false;
        for (String specialCharacter : specialCharacters) {
            if (text.contains(specialCharacter)) {
                contains = true;
                break;
            }
        }

        if (contains) {
            text = "<![CDATA[" + text.trim() + "]]>";
        }

        if (text.contains("'")) {
            text = text.replace("'", "\\'");
        }

        return text;
    }

    @Override
    public List<String> getFileNames(String pathTo, String fileNameTo, Language language) {

        List<String> fileNames = new ArrayList<String>();

        String fileName = pathTo + "/values-";
        if (language.toString().equalsIgnoreCase(Language.CHINESE_SIMPLIFIED.toString())) {
            fileName = fileName.concat("zh-rCN");
        } else if (language.toString().equalsIgnoreCase(Language.CHINESE_TRADITIONAL.toString())) {
            fileName = fileName.concat("zh-rTW");
        } else {
            fileName = fileName.concat(language.toString());
        }

        fileName = fileName.concat("/" + fileNameTo);
        fileNames.add(fileName);

        return fileNames;
    }
}
