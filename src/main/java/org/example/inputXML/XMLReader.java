package org.example.inputXML;

import org.example.exception.CoordinatesPointException;
import org.example.points.entities.Points;
import org.example.points.entities.Points2D;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {

    private File xmlFile;

    private String element;
    private DocumentBuilderFactory factory;




    private DocumentBuilder builder;



    private NodeList readFromXML(){

        NodeList nodeList = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            nodeList = document.getElementsByTagName(element);


        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return nodeList;
    }


    public List getElements(){

        List elements = null;
        DataHandler dataHandler;
        if(element.equals("CouplePoints")){
            dataHandler = new PointsHandler();
            try {
                elements = dataHandler.getElementFromNode(readFromXML());
            } catch (CoordinatesPointException e) {
                throw new RuntimeException(e);
            }
        }
        return elements;

    }


    private XMLReader(Builder builder){
        this.xmlFile = builder.xmlFile;
        this.element = builder.element;
        factory = DocumentBuilderFactory.newInstance();
    }


    public static class Builder{
        private File xmlFile;

        private String element;



        public Builder(String xmlFile){
            this.xmlFile = new File(xmlFile);
        }

        public Builder setElement(String element) {
            this.element = element;
            return this;
        }

        public XMLReader build(){
            return new XMLReader(this);
        }


    }
}
