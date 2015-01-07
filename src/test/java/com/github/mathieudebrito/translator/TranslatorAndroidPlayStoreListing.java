package com.github.mathieudebrito.translator;

import com.github.mathieudebrito.translator.generators.android.playstore.FullDescriptionFileGenerator;
import com.github.mathieudebrito.translator.generators.android.playstore.WhatsNewFileGenerator;
import com.github.mathieudebrito.translator.parsers.android.playstore.ShortDescriptionFileParser;
import com.github.mathieudebrito.translator.parsers.android.playstore.TitleFileParser;
import com.github.mathieudebrito.translator.generators.android.playstore.ShortDescriptionFileGenerator;
import com.github.mathieudebrito.translator.generators.android.playstore.TitleFileGenerator;
import com.github.mathieudebrito.translator.parsers.android.playstore.FullDescriptionFileParser;
import com.github.mathieudebrito.translator.parsers.android.playstore.WhatsNewFileParser;

import java.util.ArrayList;

public class TranslatorAndroidPlayStoreListing {

    public static final String GOOGLE_API_KEY = "AIzaSyBKLWxBb2nMr9bIb4-PRUkHH7Df8-fxmAw";

    @org.junit.Test
    public void testWhatsNew() throws Exception {

        String root = "/Users/mathieudebrito/IdeaProjects/file-translator/src/test/resources/play";

        Translator.Config config = new Translator.Config();
        config.key = GOOGLE_API_KEY;
        config.languageFrom = Language.ENGLISH;
        config.languageTo = Language.all();
        config.files = new ArrayList<FileToTranslate>();
        config.files.add(new FileToTranslate(root, new WhatsNewFileParser(), new WhatsNewFileGenerator()));
        config.files.add(new FileToTranslate(root, new FullDescriptionFileParser(), new FullDescriptionFileGenerator()));
        config.files.add(new FileToTranslate(root, new ShortDescriptionFileParser(), new ShortDescriptionFileGenerator()));
        config.files.add(new FileToTranslate(root, new TitleFileParser(), new TitleFileGenerator()));

        Translator translator = new TranslatorGoogle();
        translator.init(config);

        translator.translate();
    }


}