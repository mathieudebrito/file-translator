# README #

File-Translator helps you translate your Android app using Google Translate.

### Getting started ###

* [Download the library](https://github.com/mathieudebrito/file-translator#download)
* Add a dedicated module into your project
* Add the library to the newly created module
* Create the runnable

### Dedicate a specific module to translation ? ###

* Right-click on the main project
* Click on *add a new module*
* Select *Java module*

### Download ###

##### Using gradle #####

Add this line to your module dependencies
```gradle
    compile 'com.github.mathieudebrito:file-translator:1.0.+'
```

##### Using the .jar #####

* [Download the latest version](https://github.com/mathieudebrito/file-translator/releases)
* Put the jar into the */libs* folder
* Add this line to your module dependencies

```gradle
    compile fileTree(dir: 'libs', include: ['*.jar'])
```

### Create a runnable ###

```java
public class TranslateValues {

    public static final String GOOGLE_API_KEY = "YOUR-API-KEY";

    public static void main(String[] args) {

        String root = "/path-to-your-app/app/src/main/res";

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
