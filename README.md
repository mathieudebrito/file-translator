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

        Translator.Config config = new Translator.Config();
        config.key = GOOGLE_API_KEY;
        config.languageFrom = Language.ENGLISH;
        config.languageTo = Language.toList(Language.FRENCH, Language.ESTONIAN);
        config.excludes = Language.toList(Language.ESTONIAN);
        config.files.add(new FileToTranslate.Builder()
                .path(root).from("strings.xml").to("strings.xml")
                .fileNameOfEntriesToExclude("strings_translated.xml")
                .parser(new ResourcesStringsFileParser())
                .generator(new ResourcesStringsFileGenerator())
                .build());
        Translator translator = new TranslatorGoogle();
        translator.init(config);
        
        translator.translate();
    }
}
```

### Run the translator ###

* Right-click on the runnable java file
* Click on Run

## License

	 The MIT License (MIT)

	 Copyright (c) 2015 Mathieu de Brito

	 Permission is hereby granted, free of charge, to any person obtaining a copy
	 of this software and associated documentation files (the "Software"), to deal
	 in the Software without restriction, including without limitation the rights
	 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	 copies of the Software, and to permit persons to whom the Software is
	 furnished to do so, subject to the following conditions:

	 The above copyright notice and this permission notice shall be included in all
	 copies or substantial portions of the Software.

	 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 	 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	 SOFTWARE.
