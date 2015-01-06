package com.mdb.utils.translate.parsers.android;

import com.mdb.utils.translate.Language;
import com.mdb.utils.translate.parsers.FileParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

public class ResourcesStringsFileParser implements FileParser {

    public static final boolean LOG_ENABLED = true;

    @Override
    public Map<String, String> readEntries(String path, Language languageFrom) {

        Map<String, String> entries = new TreeMap<String, String>();
        try {

            //String fileContent = Files.read(getFileNames(path));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(getFilename(path, languageFrom));
            doc.getDocumentElement().normalize();

            NodeList strings = doc.getElementsByTagName("string");
            if (strings != null) {

                StringWriter sw = new StringWriter();
                Transformer serializer = TransformerFactory.newInstance().newTransformer();
                serializer.transform(new DOMSource(strings.item(0)), new StreamResult(sw));

                for (int numChild = 0; numChild < strings.getLength(); numChild++) {

                    Element entry = (Element) strings.item(numChild);

                    String key = entry.getAttribute("name");
                    String value = "";
                    if (entry.hasChildNodes()) {
                        value = entry.getChildNodes().item(0).getNodeValue();
                    }

                    if (LOG_ENABLED) {
                        System.out.println(key + " = " + decode(value));
                    }

                    entries.put(key, value);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("[ERROR] file may not be found : " + getFilename(path, languageFrom));
            return null;
        }

        return entries;
    }

    @Override
    public String decode(String text) {
        text = text.replace("\\'", "'");

        return text;
    }

    @Override
    public String getFilename(String path, Language language) {
        return path + "/values/strings.xml";
    }
}
