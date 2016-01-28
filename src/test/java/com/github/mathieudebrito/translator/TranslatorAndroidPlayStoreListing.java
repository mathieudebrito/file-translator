package com.github.mathieudebrito.translator;

import com.github.mathieudebrito.translator.generators.android.playstore.FullDescriptionFileGenerator;
import com.github.mathieudebrito.translator.generators.android.playstore.ShortDescriptionFileGenerator;
import com.github.mathieudebrito.translator.generators.android.playstore.TitleFileGenerator;
import com.github.mathieudebrito.translator.generators.android.playstore.WhatsNewFileGenerator;
import com.github.mathieudebrito.translator.parsers.PlainTextFileParser;
import com.github.mathieudebrito.translator.parsers.android.playstore.FullDescriptionFileParser;
import com.github.mathieudebrito.translator.parsers.android.playstore.ShortDescriptionFileParser;
import com.github.mathieudebrito.translator.parsers.android.playstore.TitleFileParser;

import java.util.ArrayList;

public class TranslatorAndroidPlayStoreListing {

    public static final String GOOGLE_API_KEY = "";

    @org.junit.Test
    public void testWhatsNew() throws Exception {

        String root = "/Users/mathieudebrito/IdeaProjects/file-translator/src/test/resources/play";

        Translator.Config config = new Translator.Config();
        config.key = GOOGLE_API_KEY;
        config.languageFrom = Language.ENGLISH;
        config.languageTo = Language.toList(Language.FRENCH, Language.ENGLISH);
        config.files = new ArrayList<FileToTranslate>();
        config.files.add(new FileToTranslate.Builder()
                .path(root)
                .parser(new PlainTextFileParser())
                .generator(new WhatsNewFileGenerator()).build());
        config.files.add(new FileToTranslate.Builder()
                .path(root)
                .parser(new FullDescriptionFileParser())
                .generator(new FullDescriptionFileGenerator()).build());
        config.files.add(new FileToTranslate.Builder()
                .path(root)
                .parser(new ShortDescriptionFileParser())
                .generator(new ShortDescriptionFileGenerator()).build());
        config.files.add(new FileToTranslate.Builder()
                .path(root)
                .parser(new TitleFileParser())
                .generator(new TitleFileGenerator()).build());

        Translator translator = new TranslatorGoogle();
        translator.init(config);

        translator.translate();
    }


}
