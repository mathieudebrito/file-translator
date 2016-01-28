package com.github.mathieudebrito.translator.generators.android.playstore;

import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;
import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.generators.PlainTextFileGenerator;

import java.util.ArrayList;
import java.util.List;

public class FullDescriptionFileGenerator extends PlainTextFileGenerator {

    @Override
    public String encode(String text) {
        text = text.replace(" <br /> ", "\n");
        text = text.replace("<br /> ", "\n");
        text = text.replace(" <br />", "\n");
        text = text.replace("<br />", "\n");
        return text;
    }

    @Override
    public List<String> getFileNames(String path, String fileNameTo, Language languageTo) {
        List<String> languages = new ArrayList<String>();

        for (String language : PlayStoreLanguage.getPreciseLanguages(languageTo)) {
            String fileName = path + "/" + language + "/listing/fulldescription";
            languages.add(fileName);
        }

        return languages;
    }
}
