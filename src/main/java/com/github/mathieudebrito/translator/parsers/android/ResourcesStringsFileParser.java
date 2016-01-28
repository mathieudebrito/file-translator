package com.github.mathieudebrito.translator.parsers.android;

import com.github.mathieudebrito.translator.Language;
import com.github.mathieudebrito.translator.parsers.FileParser;
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
import java.util.*;

public class ResourcesStringsFileParser implements FileParser {

    @Override
    public Map<String, String> readEntries(String path, List<String> fileNamesFrom, Language languageFrom) {

        Map<String, String> entries = new TreeMap<String, String>();
        for (String fileName : fileNamesFrom) {
            entries.putAll(readEntries(path, fileName, languageFrom));
        }
        return entries;
    }

    private Map<String, String> readEntries(String path, String fileNameFrom, Language languageFrom) {

        Map<String, String> entries = new TreeMap<String, String>();
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(getFilename(path, fileNameFrom, languageFrom));
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

                    entries.put(key, value);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("[WARNING] file may not be found : " + getFilename(path, fileNameFrom, languageFrom));
            return new TreeMap<String, String>();
        }

        return entries;
    }

    @Override
    public String decode(String text) {


        text = text.replace("\\'", "'");
        text = text.replace("]]>", "");
        text = text.replace("<![CDATA[", "");

        return text.trim();
    }

    @Override
    public String getFilename(String path, String fileNameFrom, Language language) {
        return path + "/values/" + fileNameFrom;
    }
}
