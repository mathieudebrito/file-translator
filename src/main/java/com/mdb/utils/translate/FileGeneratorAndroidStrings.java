package com.mdb.utils.translate;

import java.util.Map;

public class FileGeneratorAndroidStrings implements FileGenerator {

    @Override
    public void writeEntries(String path, Language language, Map<String, String> translations) {

        StringBuilder content = new StringBuilder();
        content = content.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + Files.BR);
        content = content.append("<resources>" + Files.BR);

        for (String key : translations.keySet()) {
            String value = translations.get(key);
            content = content.append(Files.TAB + "<string name=\"" + key + "\">" + value + "</string>" + Files.BR);
        }

        content = content.append("</resources>");

        Files.write(getFilename(path, language), content.toString());
    }

    @Override
    public String getFilename(String path, Language language) {

        String fileName = path + "/values-";
        if (language.toString().equalsIgnoreCase(Language.CHINESE_SIMPLIFIED.toString())) {
            fileName = fileName.concat("zh-rCN");
        } else if (language.toString().equalsIgnoreCase(Language.CHINESE_TRADITIONAL.toString())) {
            fileName = fileName.concat("zh-rTW");
        } else {
            fileName = fileName.concat(language.toString());
        }

        fileName = fileName.concat("/strings.xml");

        return fileName;
    }
}
