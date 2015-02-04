package com.github.mathieudebrito.translator;

import com.github.mathieudebrito.translator.generators.ios.IOSLocalizedStringsFileGenerator;
import com.github.mathieudebrito.translator.parsers.ios.IOSLocalizedStringsFileParser;

import java.util.ArrayList;

public class TranslatorIOSLocalizedStrings {

    public static final String GOOGLE_API_KEY = "";

    @org.junit.Test
    public void testInit() throws Exception {

        String root = "/Users/mathieudebrito/IdeaProjects/file-translator/src/test/resources/appstore";

        Translator.Config config = new Translator.Config();
        config.key = GOOGLE_API_KEY;
        config.languageFrom = Language.ENGLISH;
        config.languageTo = Language.getAppleStoreCompliantLanguages();
        config.files = new ArrayList<FileToTranslate>();
        config.files.add(new FileToTranslate(root, new IOSLocalizedStringsFileParser(), new IOSLocalizedStringsFileGenerator()));

        Translator translator = new TranslatorGoogle();
        translator.init(config);

        translator.translate();
    }


}
