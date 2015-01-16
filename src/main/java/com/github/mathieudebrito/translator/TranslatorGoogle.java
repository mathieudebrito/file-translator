package com.github.mathieudebrito.translator;

import com.github.mathieudebrito.translator.payloads.TranslationPayload;
import com.github.mathieudebrito.translator.payloads.TranslationTextPayload;
import com.github.mathieudebrito.translator.utils.HTMLEntities;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class TranslatorGoogle implements Translator {

    public static final String URL_TRANSLATE = "https://www.googleapis.com/language/translate/v2";

    protected Config config;

    @Override
    public void init(Config config) {
        this.config = config;
    }

    @Override
    public void translate() {
        if (config == null) {
            System.out.println("[ERROR] Config parameter is null");
        }

        // Translate all files given
        for (FileToTranslate file : config.files) {

            // Get the entries of the current file
            Map<String, String> entries = file.parser.readEntries(file.path, config.languageFrom);

            // Decode all values
            for (String key : entries.keySet()) {
                String value = entries.get(key);
                entries.put(key, file.parser.decode(value));
            }

            System.out.println("Found " + entries.size() + " entries from " + config.languageFrom);

            // Translate the entries in each language set in the config
            for (Language languageTo : config.languageTo) {
                System.out.print("Translation in " + languageTo.toString());

                Map<String, String> translations = entries;
                if (!languageTo.equals(config.languageFrom)) {
                    translations = translateViaGoogle(entries, languageTo);
                }

                // Encode all values
                for (String key : entries.keySet()) {
                    String value = translations.get(key);
                    translations.put(key, file.generator.encode(value));
                }

                file.generator.writeEntries(file.pathTranslated, languageTo, translations);

                System.out.println(" : Done");
            }
        }
    }

    public Map<String, String> translateViaGoogle(Map<String, String> entries, Language to) {
        try {
            OkHttpClient client = new OkHttpClient();

            StringBuilder url = new StringBuilder(URL_TRANSLATE);
            url = url.append("?key=" + config.key);
            url = url.append("&source=" + config.languageFrom.toString());
            url = url.append("&target=" + to);

            for (String key : entries.keySet()) {

                String value = entries.get(key);
                url = url.append("&q=" + URLEncoder.encode(value));
                url = url.append("&cid=" + URLEncoder.encode(value)); //does not work as intended
            }

            Request request = new Request.Builder()
                    .url(url.toString())
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            Map<String, String> translations = parse(responseBody, entries);

            return translations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, String> parse(String content, Map<String, String> defaultEntries) {
        Map<String, String> translations = new TreeMap<String, String>();

        Gson gson = new Gson();
        TranslationPayload payload = gson.fromJson(content, TranslationPayload.class);
        if (payload != null) {
            if (payload.data != null) {
                int numTranslation = 0;
                for (String key : defaultEntries.keySet()) {
                    TranslationTextPayload translation = payload.data.translations.get(numTranslation);
                    
                    String translatedText = translation.translatedText;
                    translatedText = HTMLEntities.unhtmlentities(translatedText).trim();
                    translatedText = HTMLEntities.unhtmlAngleBrackets(translatedText);

                    translations.put(key, translatedText);
                    numTranslation++;
                }

            } else {
                throw new RuntimeException("[TranslatorGoogle] Parse - payload.data is null (" + content + ")");
            }
        } else {
            throw new RuntimeException("[TranslatorGoogle] Parse - payload is null (" + content + ")");
        }

        return translations;
    }


}
