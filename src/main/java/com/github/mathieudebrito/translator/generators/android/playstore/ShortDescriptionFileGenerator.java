package com.github.mathieudebrito.translator.generators.android.playstore;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.generators.PlainTextFileGenerator;
import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;

import java.util.ArrayList;
import java.util.List;

public class ShortDescriptionFileGenerator extends PlainTextFileGenerator {

    @Override
    public String encode(String text) {
        text = text.replace(" <br /> ", "\n");
        text = text.replace("<br /> ", "\n");
        text = text.replace(" <br />", "\n");
        text = text.replace("<br />", "\n");
        return text;
    }

    @Override
    public List<String> getFileNames(String path, Language languageTo) {
        List<String> languages = new ArrayList<String>();

        for (String language : PlayStoreLanguage.getPreciseLanguages(languageTo)) {
            String fileName = path + "/" + language + "/listing/shortdescription";
            languages.add(fileName);
        }

        return languages;
    }
}
