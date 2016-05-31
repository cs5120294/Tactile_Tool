import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
public class SCR  {
    static int label_counts=0;
    int startX = -1, startY = -1;
    static int edit_counter = 0;
    static JFrame fm=null;
    static Listener a1 = null;
    static label_image a2=null;
    static get_lines a3 = null;
    static get_circles a4 = null;
    static BufferedImage screen = null;
    static BufferedImage screen1 = null;
    static get_arbit_2 a5 = null;
    static get_text a6 = null;
    static get_polygon a7 = null;
    static get_arc a8 = null;
    static modify_text a9 = null;
    static which_polygon a10 = null;
    static load_labels a11 = null;
    static load_lines_circles a12 = null;
    static svg_generate a13 = null;
    static add_listener_to_screenlabel a14 = null;
    static refresh_all a15 = null;
    static get_arbitpath a16 = null;
    static restore_svg a17 = null;
    static color a18 = null;
    static Point start = new Point();
    static File current_file;
    static String current_file_name;
    static Color current_color;
    boolean checked = false;
    Point startPoint;
    Point endPoint;
    int i=0,j=0;
    SCR(int r){};
    String label;
    SCR(){
        repaint(screen,a2.screenCopy);
        a2.screenLabel.repaint();
        
    }
    
    public void repaint(BufferedImage orig, BufferedImage copy){
    	Graphics2D g = copy.createGraphics();
    	g.drawImage(orig,0,0, null);
    	g.setColor(Color.blue);
    	for(int k=0;k<a3.Lines.size();k++){
            g.setColor(current_color);
            g.fillRect(a3.Lines.get(k).getL(), a3.Lines.get(k).getR(), 2,2);
    	}
    	for(int k=0;k<a3.Lines.size()-1;k++){
            g.setColor(a3.color_array.get(k));
            if(a3.line_indices.contains(k)){
                g.setStroke(new BasicStroke(3.0f));
                g.drawLine(a3.Lines.get(k).getL(), a3.Lines.get(k).getR(), a3.Lines.get(k+1).getL(), a3.Lines.get(k+1).getR());
                g.setStroke(new BasicStroke(1.0f));
            }
            else{
                g.drawLine(a3.Lines.get(k).getL(), a3.Lines.get(k).getR(), a3.Lines.get(k+1).getL(), a3.Lines.get(k+1).getR());
            }
            g.setColor(current_color);
            k++;
    	}
        if(a7.Points!=null){
            g.setColor(current_color);
            for(int h=0;h<a7.Points.size();h++){
                g.fillRect(a7.Points.get(h).getL(),a7.Points.get(h).getR(), 2,2);
            }
            for(int k=0;k<a7.Points.size()-1;k++){
                g.drawLine(a7.Points.get(k).getL(), a7.Points.get(k).getR(), a7.Points.get(k+1).getL(), a7.Points.get(k+1).getR());
            }
            
        }
        
        if(a5.Points_regions.size()>0){
            g.setColor(current_color);
            for(int h=0;h<a5.Points_regions.size();h++){
                g.fillRect(a5.Points_regions.get(h).getL(),a5.Points_regions.get(h).getR(), 2,2);
            }
            for(int k=0;k<a5.Points_regions.size()-1;k++){
                g.drawLine(a5.Points_regions.get(k).getL(), a5.Points_regions.get(k).getR(), a5.Points_regions.get(k+1).getL(), a5.Points_regions.get(k+1).getR());
            }
        }
        
    	for(int k=0;k<a7.Polygons.size();k++){
            g.setColor(a7.color_array.get(k));
            if(a7.polygon_indices.contains(k)){
                g.setStroke(new BasicStroke(3.0f));
                for(int h=0;h<a7.Polygons.get(k).size()-1;h++){
                    g.drawLine(a7.Polygons.get(k).get(h).getL(),a7.Polygons.get(k).get(h).getR(), a7.Polygons.get(k).get(h+1).getL(),a7.Polygons.get(k).get(h+1).getR());
                }
                g.setStroke(new BasicStroke(1.0f));
            }
            else{
                for(int h=0;h<a7.Polygons.get(k).size()-1;h++){
                    g.drawLine(a7.Polygons.get(k).get(h).getL(),a7.Polygons.get(k).get(h).getR(), a7.Polygons.get(k).get(h+1).getL(),a7.Polygons.get(k).get(h+1).getR());
                }
            }
            if(a7.fill_or_not.get(k)==1){
                Polygon p = new Polygon();
                for(int h=0;h<a7.Polygons.get(k).size()-1;h++){
                    p.addPoint(a7.Polygons.get(k).get(h).getL(), a7.Polygons.get(k).get(h).getR());
                }
                g.fillPolygon(p);
            }
            g.setColor(current_color);
    	}
        
    	for(int k=0;k<a5.Regions.size();k++){
            g.setColor(a5.color_array.get(k));
            if(a5.region_indices.contains(k)){
                g.setStroke(new BasicStroke(3.0f));
                for(int h=0;h<a5.Regions.get(k).size()-1;h++){
                    g.drawLine(a5.Regions.get(k).get(h).getL(),a5.Regions.get(k).get(h).getR(), a5.Regions.get(k).get(h+1).getL(),a5.Regions.get(k).get(h+1).getR());
                }
                g.setStroke(new BasicStroke(1.0f));
            }
            else{
                for(int h=0;h<a5.Regions.get(k).size()-1;h++){
                    g.drawLine(a5.Regions.get(k).get(h).getL(),a5.Regions.get(k).get(h).getR(), a5.Regions.get(k).get(h+1).getL(),a5.Regions.get(k).get(h+1).getR());
                }
            }
            if(a5.fill_or_not.get(k)==1){
                Polygon p = new Polygon();
                for(int h=0;h<a5.Regions.get(k).size()-1;h++){
                    p.addPoint(a5.Regions.get(k).get(h).getL(), a5.Regions.get(k).get(h).getR());
                }
                g.fillPolygon(p);
            }
            g.setColor(current_color);
    	}        
    	
    	for(int k=0;k<a4.Circles.size();k++){
            g.setColor(current_color);
            int r1 = (int)(float)a4.Circles.get(k).getL();
            int r2 = (int)(float)a4.Circles.get(k).getR();
            g.fillRect(r1,r2,2,2);
    	}
        
        
        for(int k=0;k<a8.Circles.size();k++){
            g.setColor(current_color);
            int r1 = (int)(float)a8.Circles.get(k).getL();
            int r2 = (int)(float)a8.Circles.get(k).getR();
            g.fillRect(r1,r2,2,2);
    	}

    	for(int k=0;k<a4.Centers.size();k++){
            int r1 = (int)(float)a4.Centers.get(k).getL();
            int r2 = (int)(float)a4.Centers.get(k).getR();
            int r3 = (int)(float)a4.Radius.get(k);
            g.setColor(a4.color_array.get(k));
            if(a4.circle_indices.contains(k)){
                g.setStroke(new BasicStroke(3.0f));
                g.drawArc(r1-r3,r2-r3,2*r3,2*r3, 0, 360);
                g.setStroke(new BasicStroke(1.0f));
            }
            else{
                g.drawArc(r1-r3,r2-r3,2*r3,2*r3, 0, 360); 
            }
            if(a4.fill_or_not.get(k)==1){
                g.fillArc(r1-r3,r2-r3,2*r3,2*r3, 0, 360);
            }
            g.setColor(current_color);
    	}
        
        for(int k=0;k<a8.Centers.size();k++){
            int r1 = (int)(float)a8.Centers.get(k).getL();
            int r2 = (int)(float)a8.Centers.get(k).getR();
            int r3 = (int)(float)a8.Radius.get(k);
            int r4 = a8.arc_angles.get(k).getL();
            int r5 = a8.arc_angles.get(k).getR();
            g.setColor(a8.color_array.get(k));
            if(a8.circle_indices.contains(k)){
               g.setStroke(new BasicStroke(3.0f));
               g.drawArc(r1-r3,r2-r3,2*r3,2*r3, r4, r5);
               g.setStroke(new BasicStroke(1.0f));
            }
            else{
                g.drawArc(r1-r3,r2-r3,2*r3,2*r3, r4,r5); 
            }
            if(a8.fill_or_not.get(k)==1){
                g.fillArc(r1-r3,r2-r3,2*r3,2*r3, r4,r5);
            }
            g.setColor(current_color);
    	}


    	
        
        if(a16.Points_regions.size()>0){
            g.setColor(current_color);
            for(int h=0;h<a16.Points_regions.size();h++){
                g.fillRect(a16.Points_regions.get(h).getL(),a16.Points_regions.get(h).getR(), 2,2);
            }
            for(int k=0;k<a16.Points_regions.size()-1;k++){
                g.drawLine(a16.Points_regions.get(k).getL(), a16.Points_regions.get(k).getR(), a16.Points_regions.get(k+1).getL(), a16.Points_regions.get(k+1).getR());
            }
        }
        
    	for(int k=0;k<a16.Regions.size();k++){
            g.setColor(a16.color_array.get(k));
            if(a16.region_indices.contains(k)){
                g.setStroke(new BasicStroke(3.0f));
                for(int h=0;h<a16.Regions.get(k).size()-2;h++){
                    g.drawLine(a16.Regions.get(k).get(h).getL(),a16.Regions.get(k).get(h).getR(), a16.Regions.get(k).get(h+1).getL(),a16.Regions.get(k).get(h+1).getR());
                }
                g.setStroke(new BasicStroke(1.0f));
            }
            else{
                for(int h=0;h<a16.Regions.get(k).size()-2;h++){
                    g.drawLine(a16.Regions.get(k).get(h).getL(),a16.Regions.get(k).get(h).getR(), a16.Regions.get(k).get(h+1).getL(),a16.Regions.get(k).get(h+1).getR());
                }	    
            }
            g.setColor(current_color);
    	}
        
        for(int k=0;k<a6.Rect_array.size();k++){
            g.setColor(Color.black);
            if(a6.rect_indices.contains(k)){
    		if(!a6.label.get(k).getR().contains("label -")){
                    g.drawString(a6.label.get(k).getR(),a6.Rect_array.get(k).x, a6.Rect_array.get(k).y-4);
                }
                g.setStroke(new BasicStroke(3.0f));
                g.drawRect(a6.Rect_array.get(k).x, a6.Rect_array.get(k).y, a6.Rect_array.get(k).width,a6.Rect_array.get(k).height);
                g.setStroke(new BasicStroke(1.0f));
            }
            else{
                if(!a6.label.get(k).getR().contains("label -")){
                    g.drawString(a6.label.get(k).getR(),a6.Rect_array.get(k).x, a6.Rect_array.get(k).y-4);
                }
                g.drawRect(a6.Rect_array.get(k).x, a6.Rect_array.get(k).y, a6.Rect_array.get(k).width,a6.Rect_array.get(k).height);
            }
            if(a9.selected_rect==k){
                g.setColor(Color.RED);
                if(!a6.label.get(k).getR().contains("label -")){
                    g.drawString(a6.label.get(k).getR(),a6.Rect_array.get(k).x, a6.Rect_array.get(k).y-4);
                }
                g.drawRect(a6.Rect_array.get(k).x+2, a6.Rect_array.get(k).y+2, a6.Rect_array.get(k).width-4,a6.Rect_array.get(k).height-4);
                g.setColor(current_color);
            }
            g.setColor(current_color);
        }
        
    	if(a6.captureRect!= null){
            g.setColor(Color.black);
            g.drawRect(a6.captureRect.x, a6.captureRect.y, a6.captureRect.width, a6.captureRect.height);
            g.setColor(current_color);
        }
    	g.dispose();
    }
    public static void main(String[] args) throws Exception {
    	fm= new JFrame("New Frame");
        a1 = new Listener();
    	File img = new File("tactile_tool.jpg");
        current_file = img;
    	screen = ImageIO.read(img);
    	fm.setSize(700,700);
    	fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	fm.setVisible(true);
    	a2 = new label_image();
    	a3 = new get_lines();
    	a4 = new get_circles();
    	a5 = new get_arbit_2();
    	a6 = new get_text();
    	a7 = new get_polygon();
        a8 = new get_arc();
        a9 = new modify_text();
        a10 = new which_polygon();
        a16 = new get_arbitpath();
        a11 = new load_labels();
        a12 = new load_lines_circles();
        a13 = new svg_generate();
        a14 = new add_listener_to_screenlabel();
        a15 = new refresh_all();
        a17 = new restore_svg();
        a18 = new color();
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                    new SCR();
                    fm.setVisible(true);
            }
    	});
    }
}		