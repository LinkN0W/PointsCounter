package org.example.inputXML;

import org.example.enums.MethodCalculation;
import org.example.exception.CoordinatesPointException;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points;
import org.example.points.entities.Points2D;
import org.example.points.entities.Points3D;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class PointsHandler implements DataHandler{
    @Override
    public List<CouplePoints> getElementFromNode(NodeList nodeList) throws CoordinatesPointException {

        List<CouplePoints> couplePointsList = new ArrayList<>();
        CouplePoints couplePoints = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            System.out.println(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elementCouple = (Element) node;
                NodeList coupleNodeList = elementCouple.getElementsByTagName("Point");
                couplePoints = new CouplePoints();

                Node nodePointA = coupleNodeList.item(0);
                Element elementPointA = (Element) nodePointA;

                Node nodePointB = coupleNodeList.item(1);
                Element elementPointB = (Element) nodePointB;

                Points pointA = parsePointElement(elementPointA);

                Points pointB = parsePointElement(elementPointB);


                if(pointA.getMethodCalculation() == pointB.getMethodCalculation()) {
                    couplePoints.setPointA(parsePointElement(elementPointA));

                    couplePoints.setPointB(parsePointElement(elementPointB));

                    couplePointsList.add(couplePoints);
                }
                else throw new CoordinatesPointException("Points have different coordinate systems");
            }


        }
        return couplePointsList;
    }

    @Override
    public String getTagValue(String tag, Element element) {
        NodeList nodeList;
        Node nodePre = element.getElementsByTagName(tag).item(0);
        if(nodePre != null) {
            nodeList = nodePre.getChildNodes();
            Node node = (Node) nodeList.item(0);
            return node.getNodeValue();
        }
        return "0";
    }

    private Points parsePointElement(Element elementPoint){
        float x = Float.parseFloat(getTagValue("x", elementPoint));
        float y = Float.parseFloat(getTagValue("y", elementPoint));
        float z = Float.parseFloat(getTagValue("z", elementPoint));
        return z != 0 ? new Points3D(x, y, z) : new Points2D(x, y);
    }


}
