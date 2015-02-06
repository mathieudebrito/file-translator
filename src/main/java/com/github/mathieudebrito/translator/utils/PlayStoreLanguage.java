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
                    updatedLanguage = "en-US";// get US as default
                } else if (language == Language.FRENCH) {
                    updatedLanguage = "fr-FR";// get FR as default
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

        if (language == Language.AFRIKAANS) {
            addSingle(languages, language);
        } else if (language == Language.ARABIC) {
            addSingle(languages, language);
        } else if (language == Language.BELARUSIAN) {
            addSingle(languages, language);
        } else if (language == Language.BULGARIAN) {
            addSingle(languages, language);
        } else if (language == Language.CATALAN) {
            addSingle(languages, language);
        } else if (language == Language.CHINESE_SIMPLIFIED) {
            languages.add("zh-CN");
        } else if (language == Language.CHINESE_TRADITIONAL) {
            languages.add("zh-TW");
        } else if (language == Language.CROATIAN) {
            languages.add("cs-CZ");
        } else if (language == Language.CZECH) {
            languages.add("es-419");
        } else if (language == Language.DANISH) {
            languages.add("da-DK");
        } else if (language == Language.DUTCH) {
            addDuo(languages, language);
        } else if (language == Language.ENGLISH) {
            languages.add("en-US");
            languages.add("en-GB");
        } else if (language == Language.ESTONIAN) {
            addSingle(languages, language);
        } else if (language == Language.FRENCH) {
            addDuo(languages, language);
            languages.add("fr-CA");
        } else if (language == Language.FILIPINO) {
            addSingle(languages, language);
        } else if (language == Language.FINNISH) {
            addDuo(languages, language);
        } else if (language == Language.GERMAN) {
            addDuo(languages, language);
        } else if (language == Language.GREEK) {
            languages.add("el-GR");
        } else if (language == Language.HEBREW) {
            languages.add("iw-IL");
        } else if (language == Language.HINDI) {
            languages.add("hi-IN");
        } else if (language == Language.HUNGARIAN) {
            addDuo(languages, language);
        } else if (language == Language.INDONESIAN) {
            addSingle(languages, language);
        } else if (language == Language.ITALIAN) {
            addDuo(languages, language);
        } else if (language == Language.JAPANESE) {
            languages.add("ja-JP");
        } else if (language == Language.KOREAN) {
            languages.add("ko-KR");
        } else if (language == Language.LATVIAN) {
            addSingle(languages, language);
        } else if (language == Language.LITHUANIAN) {
            addSingle(languages, language);
        } else if (language == Language.MALAY) {
            addSingle(languages, language);
        } else if (language == Language.NORWEGIAN) {
            addDuo(languages, language);
        } else if (language == Language.PERSIAN) {
            addSingle(languages, language);
        } else if (language == Language.POLISH) {
            addDuo(languages, language);
        } else if (language == Language.PORTUGUESE) {
            addDuo(languages, language);
            languages.add("pt-BR");
        } else if (language == Language.RUSSIAN) {
            addDuo(languages, language);
        } else if (language == Language.ROMANIAN) {
            addSingle(languages, language);
        } else if (language == Language.SERBIAN) {
            addSingle(languages, language);
        } else if (language == Language.SLOVAK) {
            addSingle(languages, language);
        } else if (language == Language.SLOVENIAN) {
            addSingle(languages, language);
        } else if (language == Language.SPANISH) {
            addDuo(languages, language);
            languages.add("es-US");
            languages.add("es-419");
        } else if (language == Language.SWAHILI) {
            addSingle(languages, language);
        } else if (language == Language.SWEDISH) {
            languages.add("sv-SE");
        } else if (language == Language.THAI) {
            addSingle(languages, language);
        } else if (language == Language.TURKISH) {
            addDuo(languages, language);
        } else if (language == Language.UKRANIAN) {
            addSingle(languages, language);
        } else if (language == Language.VIETNAMESE) {
            addSingle(languages, language);
        } else {
            String playStoreLanguage = language.toString() + "-" + language.toString().toUpperCase();
            languages.add(playStoreLanguage);
        }

        return languages;
    }

    public static void addSingle(List<String> languages, Language language) {
        String playStoreLanguage = language.toString();
        languages.add(playStoreLanguage);
    }

    public static void addDuo(List<String> languages, Language language) {
        String playStoreLanguage = language.toString() + "-" + language.toString().toUpperCase();
        languages.add(playStoreLanguage);
    }

}
