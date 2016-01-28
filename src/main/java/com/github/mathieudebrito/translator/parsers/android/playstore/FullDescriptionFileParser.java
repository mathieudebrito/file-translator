package com.github.mathieudebrito.translator.parsers.android.playstore;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.parsers.PlainTextFileParser;
import com.github.mathieudebrito.translator.utils.PlayStoreLanguage;

/**
 * http://stackoverflow.com/questions/11071127/google-play-app-description-formatting
 */
public class FullDescriptionFileParser extends PlainTextFileParser {

    @Override
    public String getFilename(String path, String fileNameFrom, Language language) {
        return path + "/" + PlayStoreLanguage.getPreciseLanguage(language) + "/listing/fulldescription";
    }
}
