package com.javarush.test.level33.lesson10.bonus01;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.regex.Pattern;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>


Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>");
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<anExample>
    <!--it's a comment - <needCDATA>-->
    <needCDATA><![CDATA[need CDATA because of < and >  !!!]]></needCDATA>
    <!--it's a comment - <needCDATA>-->
    <needCDATA/>
</anExample>
*/
/*public class Solution
{
    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample
    {
        public String[] needCDATA = new String[]{"need CDATA because of < and >  !!!", ""};
    }

    public static void main(String[] args)
    {
        System.out.println(Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>"));
    }

    public static String toXmlWithComment(Object obj, String tagName, String comment)
    {
        StringWriter writer = new StringWriter();
        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        //створили текст. тепер можна редагувати.
        String result = writer.toString().replace("standalone=\"yes\"", "standalone=\"no\"");
        result = result.replace("&amp;", "&");
        result = result.replace("&quot;", "\"");
        result = result.replace("&lt;", "<");
        result = result.replace("&gt;", "\t>");
        result = result.replace("&apos;", "\t‘");
        return result;
    }
}*/ //забиваю болт і роблю копі-вклей. скоріш за все мені дуже нескоро е пригодиться, і на роботу візьмуть і без цього

public class Solution
{

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample
    {
        public String[] needCDATA = new String[]{"need CDATA because of < and >  !!!", ""};
    }

    public static void main(String[] args)
    {
        System.out.println(Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>"));
    }

    public static String toXmlWithComment(Object obj, String tagName, String comment)
    {
        StringWriter writer = new StringWriter();
        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            marshaller.marshal(obj, doc);

            NodeList nodes = doc.getElementsByTagName("*");

            for (int i = 0; i < nodes.getLength(); i++)
            {
                Node node = nodes.item(i);

                if (node.getNodeName().equals(tagName))
                {
                    Comment com = doc.createComment(comment);
                    node.getParentNode().insertBefore(com, node);
                }
                //replaceTextWithCDATA(node, doc);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return writer.toString();
    }

    private static void replaceTextWithCDATA(Node node, Document doc)
    {
        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find()))
        {
            Node cnode = doc.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cnode, node);
        }

        NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++)
        {
            replaceTextWithCDATA(list.item(i), doc);
        }
    }
}
