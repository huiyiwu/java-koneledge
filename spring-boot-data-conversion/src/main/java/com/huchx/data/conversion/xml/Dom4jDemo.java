package com.huchx.data.conversion.xml;

import com.google.gson.Gson;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultElement;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

public class Dom4jDemo {
    public static void main(String[] args) {
        createXml();
        readXml();
    }

    /**
     * 读取XML文件
     */
    private static void readXml() {
        SAXReader reader = new SAXReader();
        try {
            Map<String, Object> respMap = new HashMap<String, Object>();
            Document document = reader.read(new File("students.xml"));
            Map<String,Object> map = parseElement(document.getRootElement());
            System.out.println(new Gson().toJson(map));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将XML文件内容转换为Map对象
     * @param rootElement
     * @return
     */
    private static Map<String, Object> parseElement(Element rootElement) {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<Element> it = rootElement.elementIterator();
        while (it.hasNext()){
            Element element = it.next();
            if (element.elementIterator().hasNext()){
                map.put(element.getName(),parseElement(element));
            }else {
                map.put(element.getName(),element.getTextTrim());
            }
        }
        return map;
    }

    /**
     * 创建XML文件
     */
    private static void createXml() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("students");
        Element oneChildElement = root.addElement("student");
        oneChildElement.addElement("name").addText("huchx");
        oneChildElement.addElement("url").addText("www.baidu.com");
        Element twoChildElement = root.addElement("student1");
        twoChildElement.addElement("name").addText("王金");
        twoChildElement.addElement("url").addText("www.google.com");

        //自定义样式
        OutputFormat format = new OutputFormat();
        format.setIndentSize(2);//行缩进
        format.setNewlines(true);//一个节点为一行
        format.setTrimText(true);//去除空格
        format.setPadText(true);

        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(new File("students.xml")), format);
            writer.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
