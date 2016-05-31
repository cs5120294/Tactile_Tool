import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class get_lines {
    ArrayList<Pair<Integer,Integer>> Lines=new ArrayList<Pair<Integer,Integer>>();
    ArrayList<Integer> line_indices=new ArrayList<Integer>();
    ArrayList<Color> color_array = new ArrayList<Color>();
    boolean firstPointCaptured = false;
    Point startPoint;
    Point endPoint;
    int r =0;
    SCR t1 = new SCR(r);
    int i=0;
    public get_lines() {
            // TODO Auto-generated constructor stub
    }
    public boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
    }
    public float calc_distance(int x1,int y1,int x2,int y2){
        return (float)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public void get_line(MouseEvent e)
    {	
        int x=0,y=0;
        Pair<Integer,Integer> temp = new Pair<Integer,Integer>(x, y);
        if (!firstPointCaptured)
        {
                startPoint = e.getPoint();
                firstPointCaptured = true;
                temp.setL(startPoint.x);temp.setR(startPoint.y);
                endPoint = null;
                Lines.add(temp);
                color_array.add(SCR.current_color);
                
            }
            else
            {
                endPoint = e.getPoint();
                if(calc_distance(endPoint.x, endPoint.y,Lines.get(Lines.size()-1).getL() ,Lines.get(Lines.size()-1).getR())>5){
                    temp.setL(endPoint.x);temp.setR(endPoint.y);
                    Lines.add(temp);
                    firstPointCaptured = false;
                    color_array.add(SCR.current_color);
              
                }
                t1.repaint(SCR.screen, SCR.a2.screenCopy);
                SCR.a2.screenLabel.repaint();
            }
        
    }
        public void add_indices(MouseEvent e){
            for(int i=0;i<Lines.size()-1;i++){
                int x1 = Lines.get(i).getL();
                int y1 = Lines.get(i).getR();
                int x2 = Lines.get(i+1).getL();
                int y2 = Lines.get(i+1).getR();
                int p1 = e.getPoint().x;
                int p2 = e.getPoint().y;
                double d1 =Math.pow( Math.pow(x1-p1, 2)+Math.pow(y1-p2, 2) , 0.5);
                double d2 =Math.pow( Math.pow(x2-p1, 2)+Math.pow(y2-p2, 2) , 0.5);
                double d3 =Math.pow( Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2) , 0.5);
                double s = ((d1+d2+d3)/2.0);
                double area = Math.pow(s*(s-d1)*(s-d2)*(s-d3),0.5);
                double h = (2.0*area)/d3;
                if(h<4&&d1<d3&&d2<d3){
                    if(line_indices.contains(i)){
                        line_indices.remove((Integer) i);
                        line_indices.remove((Integer) (i+1));
                    }
                    else{
                        line_indices.add(i);
                        line_indices.add(i+1);
                    }
                }
                i = i+1;
            }
        }
        public void add_color_indices(MouseEvent e){
            for(int i=0;i<Lines.size()-1;i++){
                int x1 = Lines.get(i).getL();
                int y1 = Lines.get(i).getR();
                int x2 = Lines.get(i+1).getL();
                int y2 = Lines.get(i+1).getR();
                int p1 = e.getPoint().x;
                int p2 = e.getPoint().y;
                double d1 =Math.pow( Math.pow(x1-p1, 2)+Math.pow(y1-p2, 2) , 0.5);
                double d2 =Math.pow( Math.pow(x2-p1, 2)+Math.pow(y2-p2, 2) , 0.5);
                double d3 =Math.pow( Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2) , 0.5);
                double s = ((d1+d2+d3)/2.0);
                double area = Math.pow(s*(s-d1)*(s-d2)*(s-d3),0.5);
                double h = (2.0*area)/d3;
                if(h<4&&d1<d3&&d2<d3){
                    color_array.set(i,SCR.current_color);
                    color_array.set(i+1,SCR.current_color);
                }
                i = i+1;
            }
        }
        public void delete_line_indices(){
//            ArrayList<Pair<Integer,Integer>> temp_Lines=new ArrayList<Pair<Integer,Integer>>();
            line_indices.sort(null);
            for (int i=line_indices.size()-1;i>=0;i--){
                //temp_Lines.add(Lines.get(line_indices.get(i)));
                Lines.remove((int)line_indices.get(i));
                color_array.remove((int)line_indices.get(i));
            }
            //Lines.removeAll(temp_Lines);
            line_indices.clear();
        }
}
