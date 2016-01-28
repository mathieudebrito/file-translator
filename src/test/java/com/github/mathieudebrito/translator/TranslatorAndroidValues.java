package com.github.mathieudebrito.translator;

import com.github.mathieudebrito.translator.generators.android.ResourcesStringsFileGenerator;
import com.github.mathieudebrito.translator.parsers.android.ResourcesStringsFileParser;

public class TranslatorAndroidValues {

    public static final String GOOGLE_API_KEY = "";

    @org.junit.Test
    public void testInit() throws Exception {

        String root = "/Users/mathieudebrito/IdeaProjects/file-translator/src/test/resources";

        Translator.Config config = new Translator.Config();
        config.key = GOOGLE_API_KEY;
        config.languageFrom = Language.ENGLISH;
        config.languageTo = Language.toList(Language.FRENCH, Language.ESTONIAN);
        config.excludes = Language.toList(Language.ESTONIAN);
        config.files.add(new FileToTranslate.Builder()
                .path(root).from("strings.xml").to("strings.xml")
                .fileNameOfEntriesToExclude("strings_translated.xml")
                .parser(new ResourcesStringsFileParser())
                .generator(new ResourcesStringsFileGenerator())
                .build());
        Translator translator = new TranslatorGoogle();
        translator.init(config);

        translator.translate();
    }


}
