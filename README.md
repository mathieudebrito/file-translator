# README #

## Getting started ##

* [Download the jar](https://bitbucket.org/mathieuDeBrito/filetranslator/downloads)
* Create a dedicated module
* Create the runnable

### Dedicate a specific module to translation ? ###

### Create a runnable ###

### Run the translator ###

public class TranslateValues {

```
#!java
public static final String GOOGLE_API_KEY = "AIzaSyBKLWxBb2nMr9bIb4-PRUkHH7Df8-fxmAw";

public static void main(String[] args) {

    String root = "/Users/mathieudebrito/AndroidStudioProjects/freeparkingandroid/app/src/main/res";

    Translator.Config config = new Translator.Config();
    config.key = GOOGLE_API_KEY;
    config.from = Language.ENGLISH;
    config.languageTo = Language.toList(Language.FRENCH);
    config.files = new ArrayList<>();
    config.files.add(new FileToTranslate(root, new FileParserAndroidStrings(), new FileGeneratorAndroidStrings()));

    Translator translator = new TranslatorGoogle();
    translator.init(config);

    translator.translate();
}
```
}