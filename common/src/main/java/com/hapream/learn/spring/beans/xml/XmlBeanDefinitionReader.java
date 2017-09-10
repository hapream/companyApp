package com.hapream.learn.spring.beans.xml;

import com.google.common.base.Preconditions;
import com.hapream.learn.spring.beans.AbstractBeanDefinitionReader;
import com.hapream.learn.spring.beans.BeanDefinition;
import com.hapream.learn.spring.beans.BeanReference;
import com.hapream.learn.spring.beans.PropertyValue;
import com.hapream.learn.spring.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void loadBeanDefinitions(String location) throws Exception {
       InputStream inputStream =  getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        registerBeanDefinitions(document);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document document) {
        Element root  =document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList n1 =  root.getChildNodes();
        for (int i=0; i< n1.getLength(); i++){
            Node node = n1.item(i);
            if (node instanceof Element){
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition) {

            NodeList nodeList = ele.getElementsByTagName("property");
            for (int i=0; i< nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node instanceof Element){
                    Element eleChild = (Element) node;
                    String name = eleChild.getAttribute("name");
                    String value = eleChild.getAttribute("value");
                    if (value != null && value.length()> 0){
                        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                    }else {
                        String ref = eleChild.getAttribute("ref");
                        Preconditions.checkNotNull(ref);
                        BeanReference beanReference = new BeanReference(ref);
                        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                    }
                }
            }
    }
}
