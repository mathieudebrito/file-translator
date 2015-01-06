package com.mdb.utils.translate.parsers.android.playstore;

import com.mdb.utils.translate.Language;
import com.mdb.utils.translate.parsers.PlainTextFileParser;
import com.mdb.utils.translate.utils.PlayStoreLanguage;

public class TitleFileParser extends PlainTextFileParser {

    @Override
    public String decode(String text) {
        text = text.replace("\n", "<br>");
        return text;
    }

    @Override
    public String getFilename(String path, Language language) {
        return path + "/" + PlayStoreLanguage.getPreciseLanguage(language) + "/listing/title";
    }
}
