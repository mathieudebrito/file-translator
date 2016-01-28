package com.github.mathieudebrito.translator;

import com.github.mathieudebrito.translator.generators.FileGenerator;
import com.github.mathieudebrito.translator.parsers.FileParser;
import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;

public class FileToTranslate {

    /**
     * path for the entries file
     */
    public String pathFrom;

    /**
     * file for the translated result
     */
    public String pathTo;

    /**
     * file names of the entries file
     */
    public List<String> fileNamesFrom;

    /**
     * file names of the translated result
     */
    public String fileNameTo;

    /**
     * fileName of the translated
     */
    public List<String> fileNameOfEntriesToExclude;

    /**
     * Parser languageTo use languageTo read the file
     */
    public FileParser parser;

    /**
     * Generator languageTo use languageTo generate the translated file
     */
    public FileGenerator generator;

    private FileToTranslate() {

    }

    public static class Builder {
        public FileToTranslate fileToTranslate;

        public Builder() {
            fileToTranslate = new FileToTranslate();
        }

        public FileToTranslate.Builder path(String path) {
            fileToTranslate.pathFrom = path;
            if (Strings.isNullOrEmpty(fileToTranslate.pathTo)) {
                fileToTranslate.pathTo = path;
            }
            return this;
        }

        public FileToTranslate.Builder pathTranslated(String pathTranslated) {
            fileToTranslate.pathTo = pathTranslated;
            return this;
        }

        public FileToTranslate.Builder from(String fileNameFrom) {
            fileToTranslate.fileNamesFrom = Arrays.asList(fileNameFrom);
            return this;
        }

        public FileToTranslate.Builder from(String... fileNamesFrom) {
            fileToTranslate.fileNamesFrom = Arrays.asList(fileNamesFrom);
            return this;
        }

        public FileToTranslate.Builder from(List<String> fileNamesFrom) {
            fileToTranslate.fileNamesFrom = fileNamesFrom;
            return this;
        }

        public FileToTranslate.Builder fileNameOfEntriesToExclude(String fileNameOfEntriesToExclude) {
            fileToTranslate.fileNameOfEntriesToExclude = Arrays.asList(fileNameOfEntriesToExclude);
            return this;
        }

        public FileToTranslate.Builder fileNameOfEntriesToExclude(String... fileNameOfEntriesToExclude) {
            fileToTranslate.fileNameOfEntriesToExclude = Arrays.asList(fileNameOfEntriesToExclude);
            return this;
        }

        public FileToTranslate.Builder fileNameOfEntriesToExclude(List<String> fileNameOfEntriesToExclude) {
            fileToTranslate.fileNameOfEntriesToExclude = fileNameOfEntriesToExclude;
            return this;
        }

        public FileToTranslate.Builder to(String fileNameTo) {
            fileToTranslate.fileNameTo = fileNameTo;
            return this;
        }

        public FileToTranslate.Builder parser(FileParser parser) {
            fileToTranslate.parser = parser;
            return this;
        }

        public FileToTranslate.Builder generator(FileGenerator generator) {
            fileToTranslate.generator = generator;
            return this;
        }

        public FileToTranslate build() {
            return fileToTranslate;
        }
    }
}
