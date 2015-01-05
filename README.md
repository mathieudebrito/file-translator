# README #

## Getting started ##

* [Download the jar](https://bitbucket.org/mathieuDeBrito/filetranslator/downloads)
* Create a dedicated module
* Add the jar into the module
* Create the runnable

### Dedicate a specific module to translation ? ###

### Add the jar into the module ###

* Put the jar into the /libs folder
* Add the following line to your build.gradle

```
#!gradle
    compile fileTree(dir: 'libs', include: ['*.jar'])
```

### Create a runnable ###

```
#!java

public class TranslateValues {

    public static final String GOOGLE_API_KEY = "YOUR-API-KEY";

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
}
```

### Run the translator ###

* Right-click on the runnable java file
* Click on Run