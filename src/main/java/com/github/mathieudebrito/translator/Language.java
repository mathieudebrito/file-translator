package com.github.mathieudebrito.translator;

import java.util.ArrayList;
import java.util.List;

public enum Language {
    AUTO_DETECT(""),
    AFRIKAANS("af"),
    ALBANIAN("sq"),
    //AMHARIC("am"),
    ARABIC("ar"),
    ARMENIAN("hy"),
    AZERBAIJANI("az"),
    BASQUE("eu"),
    BELARUSIAN("be"),
    BENGALI("bn"),
    //BIHARI("bh"),
    BULGARIAN("bg"),
    BURMESE("my"),
    CATALAN("ca"),
    //CHEROKEE("chr"),
    CHINESE("zh"),
    CHINESE_SIMPLIFIED("zh-CN"),
    CHINESE_TRADITIONAL("zh-TW"),
    CROATIAN("hr"),
    CZECH("cs"),
    DANISH("da"),
    //DHIVEHI("dv"),
    DUTCH("nl"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    ESTONIAN("et"),
    FILIPINO("tl"),
    FINNISH("fi"),
    FRENCH("fr"),
    GALICIAN("gl"),
    GEORGIAN("ka"),
    GERMAN("de"),
    GREEK("el"),
    //GUARANI("gn"),
    GUJARATI("gu"),
    HEBREW("iw"),
    HINDI("hi"),
    HUNGARIAN("hu"),
    ICELANDIC("is"),
    INDONESIAN("id"),
    //INUKTITUT("iu"),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KANNADA("kn"),
    KAZAKH("kk"),
    KHMER("km"),
    KOREAN("ko"),
    //KURDISH("ku"),
    //KYRGYZ("ky"),
    LAOTHIAN("lo"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    MACEDONIAN("mk"),
    MALAY("ms"),
    MALAYALAM("ml"),
    MALTESE("mt"),
    MARATHI("mr"),
    MONGOLIAN("mn"),
    NEPALI("ne"),
    NORWEGIAN("no"),
    //ORIYA("or"),
    //PASHTO("ps"),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PUNJABI("pa"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    //SANSKRIT("sa"),
    SERBIAN("sr"),
    //SINDHI("sd"),
    SINHALESE("si"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SPANISH("es"),
    SWAHILI("sw"),
    SWEDISH("sv"),
    TAJIK("tg"),
    TAMIL("ta"),
    TAGALOG("tl"),
    TELUGU("te"),
    THAI("th"),
    //TIBETAN("bo"),
    TURKISH("tr"),
    UKRANIAN("uk"),
    URDU("ur"),
    UZBEK("uz"),
    //UIGHUR("ug"),
    VIETNAMESE("vi"),
    WELSH("cy"),
    YIDDISH("yi");

    /**
     * Google's String representation of this language.
     */
    private final String language;

    /**
     * Enum constructor.
     *
     * @param pLanguage The language identifier.
     */
    private Language(final String pLanguage) {
        language = pLanguage;
    }

    public static Language fromString(final String pLanguage) {
        for (Language l : values()) {
            if (l.toString().equals(pLanguage)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Returns the String representation of this language.
     *
     * @return The String representation of this language.
     */
    @Override
    public String toString() {
        return language;
    }

    public static List<Language> all() {
        List<Language> languageList = new ArrayList<Language>();

        Language[] possibleValues = Language.values();
        for (int numLanguage = 0; numLanguage < possibleValues.length; numLanguage++) {
            if (!possibleValues[numLanguage].toString().isEmpty()) {
                languageList.add(possibleValues[numLanguage]);
            }
        }
        return languageList;
    }

    public static List<Language> toList(Language... languages) {
        List<Language> languageList = new ArrayList<Language>();

        for (int numLanguage = 0; numLanguage < languages.length; numLanguage++) {
            languageList.add(languages[numLanguage]);
        }

        return languageList;
    }
    
    public static List<Language> getGooglePlayCompliantLanguages() {
        List<Language> languageList = new ArrayList<Language>();

        languageList.add(Language.AFRIKAANS);
        languageList.add(Language.GERMAN);
        languageList.add(Language.ENGLISH);
        languageList.add(Language.BELARUSIAN);
        languageList.add(Language.BULGARIAN);
        languageList.add(Language.CATALAN);
        languageList.add(Language.CHINESE_SIMPLIFIED);
        languageList.add(Language.CHINESE_TRADITIONAL);
        languageList.add(Language.KOREAN);
        languageList.add(Language.CROATIAN);
        languageList.add(Language.DANISH);
        languageList.add(Language.SPANISH);
        languageList.add(Language.ESTONIAN);
        languageList.add(Language.FILIPINO);
        languageList.add(Language.FINNISH);
        languageList.add(Language.FRENCH);
        languageList.add(Language.GREEK);
        languageList.add(Language.HEBREW);
        languageList.add(Language.HINDI);
        languageList.add(Language.HUNGARIAN);
        languageList.add(Language.INDONESIAN);
        languageList.add(Language.ITALIAN);
        languageList.add(Language.JAPANESE);
        languageList.add(Language.LITHUANIAN);
        languageList.add(Language.MALAY);
        languageList.add(Language.NORWEGIAN);
        languageList.add(Language.PERSIAN);
        languageList.add(Language.POLISH);
        languageList.add(Language.PORTUGUESE);
        languageList.add(Language.ROMANIAN);
        languageList.add(Language.SERBIAN);
        languageList.add(Language.SLOVAK);
        languageList.add(Language.SLOVENIAN);
        languageList.add(Language.SWEDISH);
        languageList.add(Language.SWAHILI);
        languageList.add(Language.CZECH);
        languageList.add(Language.THAI);
        languageList.add(Language.TURKISH);
        languageList.add(Language.UKRANIAN);
        languageList.add(Language.VIETNAMESE);

        return languageList;
    }
}