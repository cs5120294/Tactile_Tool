import java.awt.Point;
import java.awt.Rectangle;
//import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.function.Predicate;


public class get_text {
    int curX,curY ;
    int r =0;
    SCR t1 = new SCR(r);
    Rectangle captureRect;
    ArrayList<Rectangle> Rect_array=new ArrayList<Rectangle>();
    ArrayList<Integer> rect_indices=new ArrayList<Integer>();
    ArrayList<Pair<String,String>> label=new ArrayList<Pair<String,String>>();
//    ArrayList<String> label=new ArrayList<String>();
    
    public get_text() {
            // TODO Auto-generated constructor stub
    }
    public void select_text(MouseEvent me){
        Point p = me.getPoint();
        curX = p.x;
        curY = p.y;
        int w=curX-SCR.start.x;int h=curY-SCR.start.y;
        captureRect =new Rectangle(SCR.start.x, SCR.start.y,w,h);
        t1.repaint(SCR.screen, SCR.a2.screenCopy);
        SCR.a2.screenLabel.repaint();
    }
    public void update_capture_rect(MouseEvent me){
        Point p = me.getPoint();
        curX = p.x;
        curY = p.y;
        int w=curX-SCR.start.x;int h=curY-SCR.start.y;
        if(w>5&&h>5){
            Rectangle tempRect =new Rectangle(SCR.start.x, SCR.start.y,w,h);
            Rect_array.add(tempRect);
            SCR.label_counts++;
            String h1 = "";String t1 = "";
            Pair<String,String> temp_pair = new Pair <String,String> (h1,t1);
            temp_pair.setL(String.valueOf(SCR.label_counts));
            temp_pair.setR("label - "+SCR.label_counts);
            label.add(temp_pair);
        }
//        label.add("label - "+SCR.label_counts);
        captureRect = null;
        System.out.println(Rect_array.size());
    }
    
    public void add_indices(MouseEvent e){
        for(int i=0;i<Rect_array.size();i++){
            if(Rect_array.get(i).contains(e.getPoint())){
                if(rect_indices.contains(i)){
                    rect_indices.remove((Integer)i );
                }
                else{
                    rect_indices.add(i);
                }
            }
        }
    }
    public void delete_indices(){
        ArrayList<Rectangle> temp_Rect_array=new ArrayList<Rectangle>();
        ArrayList<Pair<String,String>> temp_label=new ArrayList<Pair<String,String>>();
        for(int i=0;i<rect_indices.size();i++){
            if(rect_indices.get(i)<SCR.a9.selected_rect&&SCR.a9.selected_rect<10000){
                SCR.a9.selected_rect--;
            }
            temp_Rect_array.add(Rect_array.get(rect_indices.get(i)));
            temp_label.add(label.get(rect_indices.get(i)));
        }
        if(rect_indices.contains(SCR.a9.selected_rect)){
            SCR.a9.selected_rect=10000;
        }
        
        Rect_array.removeAll(temp_Rect_array);
        label.removeAll(temp_label);
        rect_indices.clear();
    }
}
