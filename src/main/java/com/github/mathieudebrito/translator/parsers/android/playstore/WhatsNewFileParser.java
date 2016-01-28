package com.github.mathieudebrito.translator.parsers.android.playstore;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.parsers.PlainTextFileParser;
import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;

public class WhatsNewFileParser extends PlainTextFileParser {

    @Override
    public String getFilename(String path, String fileName, Language language) {
        return path + "/" + PlayStoreLanguage.getPreciseLanguage(language) + "/whatsnew";
    }
}
