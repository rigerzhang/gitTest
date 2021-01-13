package com.xunjia.ppojo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.lang.model.util.Elements;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXResult;
import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        System.out.println(document);

    }
    @Test
    public void test2() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");

        for (Element book : books){
            String nameText = book.elementText("name");
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            String sn = book.attributeValue("sn");

            Book newBook = new Book(sn,nameText, BigDecimal.valueOf(Double.parseDouble(priceText)),authorText);

            System.out.println(newBook);
        }
    }
}
