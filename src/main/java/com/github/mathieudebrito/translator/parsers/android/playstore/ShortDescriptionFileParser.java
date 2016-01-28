package com.github.mathieudebrito.translator.parsers.android.playstore;

import com.github.mathieudebrito.translator.parsers.PlainTextFileParser;
import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;
import com.github.mathieudebrito.translator.Language;

public class ShortDescriptionFileParser extends PlainTextFileParser {

    @Override
    public String getFilename(String path, String fileName, Language language) {
        return path + "/" + PlayStoreLanguage.getPreciseLanguage(language) + "/listing/shortdescription";
    }
}
