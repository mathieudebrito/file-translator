package com.mdb.utils.translate;

import java.util.List;

public interface Translator {

    public void init(Config config);

    public void translate();

    public class Config {

        /**
         * The language in which the entry is translated
         */
        public Language from;

        /**
         * The language in which the entry has languageTo be translated
         */
        public List<Language> languageTo;

        /**
         * The file(s) that contains the entries
         */
        public List<FileToTranslate> files;

        /**
         * The entries that needs languageTo be not translated
         */
        public List<String> entriesToSkip;

        /**
         * Google API Key
         */
        public String key;

    }
}
