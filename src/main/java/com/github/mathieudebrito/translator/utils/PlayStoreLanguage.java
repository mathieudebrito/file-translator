package com.github.mathieudebrito.translator.utils;

import com.github.mathieudebrito.translator.Language;

import java.util.ArrayList;
import java.util.List;

public class PlayStoreLanguage {

    public static String getPreciseLanguage(Language language) {
        String updatedLanguage = language.toString() + "-" + language.toString().toUpperCase();
        List<String> languages = PlayStoreLanguage.getPreciseLanguages(language);
        if (languages.size() > 0) {
            if (languages.size() > 1) {
                if (language == Language.ENGLISH) {
                    updatedLanguage = "en-US";
                } else if (language == Language.FRENCH) {
                    updatedLanguage = "fr-FR";
                } else {
                    updatedLanguage = languages.get(0);
                }
            } else {
                updatedLanguage = languages.get(0);
            }
        }
        return updatedLanguage;
    }

    public static List<String> getPreciseLanguages(Language language) {
        List<String> languages = new ArrayList<String>();

        if (language == Language.ENGLISH) {
            languages.add("en-US");
            languages.add("en-GB");
        } else if (language == Language.FRENCH) {
            languages.add("fr-FR");
            languages.add("fr-CA");
        } else {
            String playStoreLanguage = language.toString() + "-" + language.toString().toUpperCase();
            languages.add(playStoreLanguage);
        }

        return languages;
    }

}
