package com.github.mathieudebrito.translator;

import java.util.ArrayList;
import java.util.List;

public interface Translator {

    public void init(Config config);

    public void translate();

    public class Config {

        /**
         * The language in which the entry is translated
         */
        public Language languageFrom = Language.ENGLISH;

        /**
         * The language in which the entry has languageTo be translated
         */
        public List<Language> languageTo = new ArrayList<Language>();

        /**
         * The language to be exclude from being translated
         * Default : none
         */
        public List<Language> excludes = new ArrayList<Language>();

        /**
         * The file(s) that contains the entries
         */
        public List<FileToTranslate> files = new ArrayList<FileToTranslate>();

        /**
         * Google API Key
         */
        public String key = null;

    }
}
