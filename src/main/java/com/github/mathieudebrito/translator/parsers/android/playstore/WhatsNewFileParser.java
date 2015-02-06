package com.github.mathieudebrito.translator.parsers.android.playstore;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.parsers.PlainTextFileParser;
import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;

public class WhatsNewFileParser extends PlainTextFileParser {

    @Override
    public String decode(String text) {
        text = text.replace("\n", "<br />");
        text = text.replace("<br>", "<br />");
        return text;
    }

    @Override
    public String getFilename(String path, Language language) {
        return path + "/" + PlayStoreLanguage.getPreciseLanguage(language) + "/whatsnew";
    }
}
