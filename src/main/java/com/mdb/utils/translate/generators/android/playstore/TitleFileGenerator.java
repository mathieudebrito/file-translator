package com.mdb.utils.translate.generators.android.playstore;

import com.mdb.utils.translate.Language;
import com.mdb.utils.translate.generators.PlainTextFileGenerator;
import com.mdb.utils.translate.utils.PlayStoreLanguage;

import java.util.ArrayList;
import java.util.List;

public class TitleFileGenerator extends PlainTextFileGenerator {

    @Override
    public String encode(String text) {
        text = text.replace(" <br> ", "\n");
        text = text.replace("<br> ", "\n");
        text = text.replace(" <br>", "\n");
        return text;
    }

    @Override
    public List<String> getFileNames(String path, Language languageTo) {
        List<String> languages = new ArrayList<String>();

        for (String language : PlayStoreLanguage.getPreciseLanguages(languageTo)) {
            String fileName = path + "/" + language + "/listing/title";
            languages.add(fileName);
        }

        return languages;
    }
}
