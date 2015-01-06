package com.mdb.utils.translate;

import com.mdb.utils.translate.generators.android.playstore.FullDescriptionFileGenerator;
import com.mdb.utils.translate.generators.android.playstore.ShortDescriptionFileGenerator;
import com.mdb.utils.translate.generators.android.playstore.TitleFileGenerator;
import com.mdb.utils.translate.generators.android.playstore.WhatsNewFileGenerator;
import com.mdb.utils.translate.parsers.android.playstore.FullDescriptionFileParser;
import com.mdb.utils.translate.parsers.android.playstore.ShortDescriptionFileParser;
import com.mdb.utils.translate.parsers.android.playstore.TitleFileParser;
import com.mdb.utils.translate.parsers.android.playstore.WhatsNewFileParser;

import java.util.ArrayList;

public class TranslatorAndroidPlayStoreListing {

    public static final String GOOGLE_API_KEY = "";

    @org.junit.Test
    public void testWhatsNew() throws Exception {

        String root = "/Users/mathieudebrito/IdeaProjects/file-translator/src/test/resources/play";

        Translator.Config config = new Translator.Config();
        config.key = GOOGLE_API_KEY;
        config.languageFrom = Language.ENGLISH;
        config.languageTo = Language.toList(Language.FRENCH);
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