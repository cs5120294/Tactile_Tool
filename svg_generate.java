
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import sun.security.pkcs11.wrapper.Constants;

public class svg_generate {
    int r=0;
    SCR t1 = new SCR(r);
    public void svg_lines() throws FileNotFoundException, IOException{
        File f = new File("line.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a3.Lines.size()-1;i++){
            o.append("<line x1="+"\""+SCR.a3.Lines.get(i).getL()+"\" ");
            o.append("y1="+"\""+SCR.a3.Lines.get(i).getR()+"\" ");
            i++;
            o.append("x2="+"\""+SCR.a3.Lines.get(i).getL()+"\" ");
            o.append("y2="+"\""+SCR.a3.Lines.get(i).getR()+"\" ");
            String hash_code = rgbtohash(SCR.a3.color_array.get(i).getRed(),
                    SCR.a3.color_array.get(i).getGreen(),
                    SCR.a3.color_array.get(i).getBlue());
            o.append("stroke="+"\""+"#"+hash_code+"\"" +"/>");
            o.append(Constants.NEWLINE);  
        }
//        o.append("</svg>"); 
        o.close();
    }

    public void svg_arc() throws FileNotFoundException, IOException{
        File f = new File("arc.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a8.Radius.size();i++){
            float c_x = SCR.a8.Centers.get(i).getL();
            float c_y = SCR.a8.Centers.get(i).getR();
            float r = SCR.a8.Radius.get(i);
            int g1 = SCR.a8.arc_angles.get(i).getL();
            int g2 = SCR.a8.arc_angles.get(i).getR();
            int g3 = (g1+g2)%360;
            float s1 = (float) (c_x+r*Math.cos(Math.toRadians(g1)));
            float s2 = (float) (c_y-r*Math.sin(Math.toRadians(g1)));
            float e1 = (float) (c_x+r*Math.cos(Math.toRadians(g3)));
            float e2 = (float) (c_y-r*Math.sin(Math.toRadians(g3)));
            int lsa = 0;
            if(SCR.a8.arc_angles.get(i).getR()>180){
                lsa = 1;
            }
            String hash_code = rgbtohash(SCR.a8.color_array.get(i).getRed(),
                    SCR.a8.color_array.get(i).getGreen(),
                    SCR.a8.color_array.get(i).getBlue());
            if(SCR.a8.fill_or_not.get(i)==0){
                hash_code = "ffffff";
            }
            o.append("<path d="+"\"M"+s1+" "+s2+" A "+r+" "+r+", 0, "+lsa+", 0, "+e1+" "+e2+"\" ");
            o.append("style="+"\""+"stroke:#006600; fill:#"+hash_code+";"+"\"" +"/>");
            o.append(Constants.NEWLINE);  
        }
//        o.append("</svg>");  
        o.close();
    }    
    public String rgbtohash(int r,int g,int b){
        String g1 = Integer.toHexString(r);
        if(g1.length()==1){
            g1 = "0"+g1;
        }
        String g2 = Integer.toHexString(g);
        if(g2.length()==1){
            g2 = "0"+g2;
        }
        String g3 = Integer.toHexString(b);
        if(g3.length()==1){
            g3 = "0"+g3;
        }
        return g1+g2+g3;
    }
    public void svg_circles() throws FileNotFoundException, IOException{
        File f = new File("circle.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a4.Radius.size();i++){
        //    <circle cx="196.0" cy="172.0" r="138.0" stroke="#006600" fill="#ffffff"/>
            o.append("<circle cx="+"\""+SCR.a4.Centers.get(i).getL()+"\" ");
            o.append("cy="+"\""+SCR.a4.Centers.get(i).getR()+"\" ");
            o.append("r="+"\""+SCR.a4.Radius.get(i)+"\" ");
            String hash_code = rgbtohash(SCR.a4.color_array.get(i).getRed(),
                    SCR.a4.color_array.get(i).getGreen(),
                    SCR.a4.color_array.get(i).getBlue());
            if(SCR.a4.fill_or_not.get(i)==0){
                o.append("stroke=\"#006600\" fill=\""+"none"+"\"" +"/>");
            }
            else{
                o.append("stroke=\"#006600\" fill=\"#"+hash_code+"\"" +"/>");
            }
            o.append(Constants.NEWLINE);  
        }
//        o.append("</svg>");  
        o.close();
    }

    public void svg_polygon() throws FileNotFoundException, IOException{
        File f = new File("polygon.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a7.Polygons.size();i++){
            o.append("<polygon points="+"\"");
            for(int j=0;j<SCR.a7.Polygons.get(i).size()-1;j++){
                o.append(SCR.a7.Polygons.get(i).get(j).getL()+","+SCR.a7.Polygons.get(i).get(j).getR()+" ");
            }
            o.append("\" ");
            String hash_code = rgbtohash(SCR.a7.color_array.get(i).getRed(),
                    SCR.a7.color_array.get(i).getGreen(),
                    SCR.a7.color_array.get(i).getBlue());
            if(SCR.a7.fill_or_not.get(i)==0){
                hash_code = "ffffff";
            }
            o.append("style="+"\""+"stroke:#660000; fill:#"+hash_code+";"+"\"" +"/>");
            o.append(Constants.NEWLINE);  
        }
//        o.append("</svg>");  
        o.close();
    }
    
    public void svg_region() throws FileNotFoundException, IOException{
        File f = new File("region.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a5.Regions.size();i++){
            o.append("<polygon points="+"\"");
            for(int j=0;j<SCR.a5.Regions.get(i).size()-1;j++){
                o.append(SCR.a5.Regions.get(i).get(j).getL()+","+SCR.a5.Regions.get(i).get(j).getR()+" ");
            }
            String hash_code = rgbtohash(SCR.a5.color_array.get(i).getRed(),
                    SCR.a5.color_array.get(i).getGreen(),
                    SCR.a5.color_array.get(i).getBlue());
            if(SCR.a5.fill_or_not.get(i)==0){
                hash_code = "ffffff";
            }
            o.append("\"");
            o.append(" style="+"\""+"stroke:#660000; fill:#"+hash_code+";"+"\"" +"/>");
            o.append(Constants.NEWLINE);  
        }
//        o.append("</svg>");  
        o.close();
    }    
    
    public void svg_path_region() throws FileNotFoundException, IOException{
        File f = new File("path_region.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a16.Regions.size();i++){
            o.append("<polyline points="+"\"");
            for(int j=0;j<SCR.a16.Regions.get(i).size()-1;j++){
                o.append(SCR.a16.Regions.get(i).get(j).getL()+","+SCR.a16.Regions.get(i).get(j).getR()+" ");
            }
            String hash_code = rgbtohash(SCR.a16.color_array.get(i).getRed(),
                    SCR.a16.color_array.get(i).getGreen(),
                    SCR.a16.color_array.get(i).getBlue());
            
            o.append("\"");
            o.append(" style="+"\""+"stroke:#"+hash_code+"; fill:none;"+"\"" +"/>");
            o.append(Constants.NEWLINE);  
        }
//        o.append("</svg>");  
        o.close();
    }
    public void svg_text() throws FileNotFoundException, IOException{
        File f = new File("text.svg");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
//        o.append("<svg>");
        o.append(Constants.NEWLINE);
        for(int i=0;i<SCR.a6.Rect_array.size();i++){
            if(!SCR.a6.label.get(i).getR().contains("label -")){
                int x1 = SCR.a6.Rect_array.get(i).x;
                int y1 = SCR.a6.Rect_array.get(i).y+SCR.a6.Rect_array.get(i).height;
                int y3 = SCR.a6.Rect_array.get(i).height;
                y3 = 15;
                o.append("<text x="+"\""+x1+"\" ");
                o.append("y="+"\""+y1+"\" ");
                o.append("style="+"\""+"font-family: Arial; font-size : "+y3+"; stroke : #000000; fill : #00ff00;"+"\"" +">");
                o.append(SCR.a6.label.get(i).getR());
                o.append("</text>");
                o.append(Constants.NEWLINE);  
            }
        }
//        o.append("</svg>");  
        o.close();
    }
    public void svg_file() throws FileNotFoundException, IOException{
        svg_lines();
        svg_arc();
        svg_circles();
        svg_polygon();
        svg_region();
        svg_text();
        svg_path_region();
        String h1 = t1.current_file.getAbsolutePath();
        String h2 = t1.current_file_name;
        String ty = h2.replace("_1.", ".")+".html";
                //h2.substring(0,h2.indexOf("."))+".html";
        String h4 = h1;
        int index=h4.lastIndexOf("\\");
        h4=h4.substring(0, index+1)+ty;
        File f = new File(h4);
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
        o.append("<!DOCTYPE html>");
        o.append(Constants.NEWLINE);
        o.append("<html>");
        o.append(Constants.NEWLINE);
        o.append("<body>");
        o.append(Constants.NEWLINE);
        o.append("<div>");
        o.append(Constants.NEWLINE);
        String ht1 = "width="+"\""+ SCR.screen.getWidth() +"\" ";
        ht1 = ht1 + "height="+"\""+ SCR.screen.getHeight()+"\"";
        o.append("<svg "+ht1+">");
        o.append(Constants.NEWLINE);
        
        File f1 = new File("line.svg");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        String ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();
        f1.delete();
        
        f1 = new File("arc.svg");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();
        f1.delete();
        f1 = new File("circle.svg");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();        
        f1.delete();
        f1 = new File("polygon.svg");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();
        f1.delete();
        f1 = new File("path_region.svg");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();
        f1.delete();
        f1 = new File("region.svg");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();
        f1.delete();
        f1 = new File("text.svg");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        ht  = br.readLine();
        while(ht!=null){
           o.append(ht);
           o.append(Constants.NEWLINE);
           ht = br.readLine();
        }
        br.close();
        f1.delete();
        o.append("</svg>");
        o.append(Constants.NEWLINE);
        o.append("</div>");
        o.append(Constants.NEWLINE);
        o.append("</body>");
        o.append(Constants.NEWLINE);
        o.append("</html>"); 
        o.close();
    }
    
    
}
