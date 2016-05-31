import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayList;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class restore_svg {
    int r=0;
    SCR t1 = new SCR(r);
    public void restore() throws SAXException, ParserConfigurationException, IOException, XPathExpressionException{
        String h1 = t1.current_file.getAbsolutePath();
        String h2 = String.valueOf(t1.current_file.getName());
        String ty = h2+".html";
        String h4 = h1;
        int index=h4.lastIndexOf("\\");
        h4=h4.substring(0, index+1)+ty;
        File f = null;
        f = new File(h4);
        if(f.exists()){
            line_restore(h4);
            circle_restore(h4);
            polygon_restore(h4);
            polypath_restore(h4);
            text_restore(h4);
        }
    }
    public void line_restore(String name) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        System.out.println(name);
        org.w3c.dom.Document document = builder.parse(name);
        String xpathExpression = "//line/@*";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList svgPaths = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
    //    System.out.println(svgPaths.getLength());
        int x1,y1,x2,y2;
        String col;
        for(int i=0;i<svgPaths.getLength();i++){
            x1 = Integer.valueOf(svgPaths.item(i+1).getNodeValue());
            y1 = Integer.valueOf(svgPaths.item(i+3).getNodeValue());
            x2 = Integer.valueOf(svgPaths.item(i+2).getNodeValue());
            y2 = Integer.valueOf(svgPaths.item(i+4).getNodeValue());
            col = svgPaths.item(i).getNodeValue().substring(1);
            i = i+4;
            SCR.a3.Lines.add(new Pair<>(x1,y1));
            SCR.a3.color_array.add(new Color(Integer.decode("0x"+col)));
            SCR.a3.color_array.add(new Color(Integer.decode("0x"+col)));
            SCR.a3.Lines.add(new Pair<>(x2,y2));
        }
    }
    public void circle_restore(String name) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(name);
        String xpathExpression = "//circle/@*";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList svgPaths = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
        System.out.println(svgPaths.getLength());
        float cx,cy,r;
        String col;
        for(int i=0;i<svgPaths.getLength();i++){
            System.out.println(svgPaths.item(i).getNodeValue());
            cx = Float.valueOf(svgPaths.item(i).getNodeValue());
            System.out.println(svgPaths.item(i+1).getNodeValue());
            cy = Float.valueOf(svgPaths.item(i+1).getNodeValue());
            System.out.println(svgPaths.item(i+2).getNodeValue());
            System.out.println(svgPaths.item(i+3).getNodeValue());
            System.out.println(svgPaths.item(i+4).getNodeValue());
            r = Float.valueOf(svgPaths.item(i+3).getNodeValue());
            col = svgPaths.item(i+2).getNodeValue().substring(1);
            i = i+4;
            if(col.contentEquals("one")){
                SCR.a4.fill_or_not.add(0);
                SCR.a4.color_array.add(Color.black);
            }
            else{
                SCR.a4.fill_or_not.add(1);
                SCR.a4.color_array.add(new Color(Integer.decode("0x"+col)));
            }
            SCR.a4.Centers.add(new Pair<>(cx,cy));
            SCR.a4.Radius.add(r);
        }
        
        
        
        
    }
    
    public void polygon_restore(String name) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(name);
        String xpathExpression = "//polygon/@points";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList svgPaths = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
        for(int i=0;i<svgPaths.getLength();i++){
            String [] p = svgPaths.item(i).getNodeValue().split(",|\\ ");
            ArrayList<Pair<Integer,Integer>> Points_regions=new ArrayList<Pair<Integer,Integer>>();
            for(int j =0;j<p.length-1;j++){
                Points_regions.add(new Pair<>(Integer.valueOf(p[j]),Integer.valueOf(p[j+1])));
                j++;
            }
            Points_regions.add(new Pair<>(Integer.valueOf(p[0]),Integer.valueOf(p[1])));
            SCR.a5.Regions.add(Points_regions);
        }
    }
    
    public void polypath_restore(String name) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(name);
        String xpathExpression = "//polyline/@points";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList svgPaths = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
        for(int i=0;i<svgPaths.getLength();i++){
            String [] p = svgPaths.item(i).getNodeValue().split(",|\\ ");
            ArrayList<Pair<Integer,Integer>> Points_regions=new ArrayList<Pair<Integer,Integer>>();
            for(int j =0;j<p.length-1;j++){
                Points_regions.add(new Pair<>(Integer.valueOf(p[j]),Integer.valueOf(p[j+1])));
                j++;
            }
            Points_regions.add(new Pair<>(Integer.valueOf(p[0]),Integer.valueOf(p[1])));
            SCR.a16.Regions.add(Points_regions);
        }
    }    
    
    public void text_restore(String name) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(name);
        String xpathExpression = "//text/@*";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList svgPaths = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
        
        
        String xpathExpression1 = "//text/text()";
        XPathFactory xpf1 = XPathFactory.newInstance();
        XPath xpath1 = xpf1.newXPath();
        XPathExpression expression1 = xpath1.compile(xpathExpression1);
        //String h = (String) expression.evaluate(document, XPathConstants.STRING);
        NodeList svgPaths1 = (NodeList)expression1.evaluate(document, XPathConstants.NODESET);
        
        
        int x,y,w,h;
        for(int i=0;i<svgPaths.getLength();i++){
            x = Integer.valueOf(svgPaths.item(i+1).getNodeValue());
            y = Integer.valueOf(svgPaths.item(i+2).getNodeValue())-30;
            h = 30;
            w = svgPaths1.item(i/3).getNodeValue().length()*4;
            i = i+2;
            SCR.a6.Rect_array.add(new Rectangle(x, y, w, h));
            SCR.label_counts++;
            String h1 = String.valueOf(SCR.label_counts);
            String h2 = "label - "+h1;
            if(svgPaths1.item(i/3).getNodeValue().length()>0){
                h2 = svgPaths1.item(i/3).getNodeValue();
            }
            SCR.a6.label.add(new Pair<>(h1,h2));
        }
    }    
}
