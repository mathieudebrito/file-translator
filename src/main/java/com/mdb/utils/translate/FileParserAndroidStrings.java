package com.mdb.utils.translate;

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

public class FileParserAndroidStrings implements FileParser {

    @Override
    public Map<String, String> readEntries(String path) {

        Map<String, String> entries = new TreeMap<String, String>();
        try {

            //String fileContent = Files.read(getFilename(path));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(getFilename(path));
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

            System.out.println("[ERROR] file may not be found : " + getFilename(path));
            return null;
        }

        return entries;
    }

    @Override
    public String getFilename(String path) {
        return path + "/values/strings.xml";
    }
}
