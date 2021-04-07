package com.huchx.data.conversion.xml.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ParseXMLUtils {
    public static String readDoc(File f) {
        String text = "";
        int read, N = 1024 * 1024;
        char[] buffer = new char[N];

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while(true) {
                read = br.read(buffer, 0, N);
                text += new String(buffer, 0, read);

                if(read < N) {
                    break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return text;
    }
    /**
     * xml  To  map
     * @throws Exception
     */
    public static Map<String, Object> xmlToMap(String responseXmlTemp) throws DocumentException {
        Document doc = DocumentHelper.parseText(responseXmlTemp);
        Element rootElement = doc.getRootElement();
        Map<String, Object> mapXml = new HashMap<String,Object>();
        elementToMap(mapXml, rootElement);
        return mapXml;
    }

    /**
     * 使用递归调用将多层级xml转为map
     *
     * @param map
     * @param rootElement
     */
    private static void elementToMap(Map<String, Object> map, Element rootElement) {
        // 获得当前节点的子节点
        List<Element> childElements = rootElement.elements();
        if (childElements.size() > 0) {
            Map<String, Object> tempMap = new HashMap<String,Object>();
            for (Element e : childElements) {
                elementToMap(tempMap, e);
                map.put(rootElement.getName(), tempMap);
            }
        } else {
            map.put(rootElement.getName(), rootElement.getText());
        }
    }
}
