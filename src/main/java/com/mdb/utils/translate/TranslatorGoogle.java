package com.mdb.utils.translate;

import com.google.gson.Gson;
import com.mdb.utils.translate.payloads.TranslationPayload;
import com.mdb.utils.translate.payloads.TranslationTextPayload;
import com.mdb.utils.translate.utils.HTMLEntities;
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
            System.out.println("AppTranslator has not been initialized");
        }

        // Translate all files given
        for (FileToTranslate file : config.files) {

            // Get the entries of the current file
            Map<String, String> entries = file.parser.readEntries(file.path);

            // Translate the entries in each language set in the config
            for (Language languageTo : config.languageTo) {
                Map<String, String> translation = translate(languageTo, entries);
                file.generator.writeEntries(file.pathTranslated, languageTo, translation);
            }
        }
    }

    public Map<String, String> translate(Language to, Map<String, String> entries) {
        try {
            OkHttpClient client = new OkHttpClient();

            StringBuilder url = new StringBuilder(URL_TRANSLATE);
            url = url.append("?key=" + config.key);
            url = url.append("&source=" + config.from.toString());
            url = url.append("&target=" + to);

            for (String key : entries.keySet()) {

                String value = entries.get(key);
                url = url.append("&q=" + URLEncoder.encode(value));
                url = url.append("&cid=" + URLEncoder.encode(value)); //does not work as intented

                System.out.println(key + " = " + value);
            }

            Request request = new Request.Builder()
                    .url(url.toString())
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            Map<String, String> translations = parse(entries, responseBody);

            return translations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, String> parse(Map<String, String> entries, String content) {
        Map<String, String> translations = new TreeMap<>();

        Gson gson = new Gson();
        TranslationPayload payload = gson.fromJson(content, TranslationPayload.class);
        if (payload != null) {
            if (payload.data != null) {
                int numTranslation = 0;
                for (String key : entries.keySet()) {
                    TranslationTextPayload translation = payload.data.translations.get(numTranslation);
                    translations.put(key, HTMLEntities.unhtmlentities(translation.translatedText));
                    numTranslation++;
                }

                for (String key : entries.keySet()) {
                    String value = entries.get(key);
                    System.out.println(key + " = " + value);
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
