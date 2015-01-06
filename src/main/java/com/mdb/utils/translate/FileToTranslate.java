package com.mdb.utils.translate;

import com.mdb.utils.translate.generators.FileGenerator;
import com.mdb.utils.translate.parsers.FileParser;

public class FileToTranslate {

    /**
     * path AND filename fot the entries file
     */
    public String path;

    /**
     * file AND filename for the translated result
     */
    public String pathTranslated;

    /**
     * Parser languageTo use languageTo read the file
     */
    public FileParser parser;

    /**
     * Generator languageTo use languageTo generate the translated file
     */
    public FileGenerator generator;

    public FileToTranslate(String path, FileParser parser, FileGenerator generator) {
        this(path, path, parser, generator);
    }

    public FileToTranslate(String path, String pathTranslated, FileParser parser, FileGenerator generator) {
        this.path = path;
        this.pathTranslated = pathTranslated;
        this.parser = parser;
        this.generator = generator;
    }
}
