package org.example.inputXML;

import org.example.exception.CoordinatesPointException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public interface DataHandler {

    List<?> getElementFromNode(NodeList nodeList) throws CoordinatesPointException;

    String getTagValue(String tag, Element element);


}
