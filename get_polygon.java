import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JRadioButton;


public class get_polygon {
	int x =0;int y=0;
	ArrayList<ArrayList<Pair<Integer,Integer>>> Polygons=new ArrayList<ArrayList<Pair<Integer,Integer>>>();
	ArrayList<Pair<Integer,Integer>> Points=new ArrayList<Pair<Integer,Integer>>();
        ArrayList<Integer> polygon_indices=new ArrayList<Integer>();
        ArrayList<Integer> fill_or_not=new ArrayList<Integer>();
        ArrayList<Color> color_array = new ArrayList<Color>();	
	boolean firstPointCaptured = false;
	boolean end_selected = false;
	Point startPoint;
	Point nextPoint;
	Pair<Integer,Integer> STARTPOINT = new Pair<Integer,Integer>(x, y);
	int r =0;
	SCR t1 = new SCR(r);
	int i=0;
	public get_polygon() {
		
	}
	public void get_polygons(MouseEvent e)
    {	
		
		Pair<Integer,Integer> temp = new Pair<Integer,Integer>(x, y);                       
            if (SCR.a1.rb1.isSelected()&&!firstPointCaptured)
            {
                startPoint = e.getPoint();
                firstPointCaptured = true;
                temp.setL(startPoint.x);temp.setR(startPoint.y);
                nextPoint = null;
                System.out.println("Started :- "+ startPoint+" gggg "+nextPoint);
                Points=new ArrayList<Pair<Integer,Integer>>();
                Points.add(temp);
                STARTPOINT=temp;
                SCR.a1.rb1.setSelected(false);
                SCR.a1.rb1.setEnabled(false);
                SCR.a1.rb2.setEnabled(true);
            }
            else
            {
            	if(SCR.a1.rb2.isSelected()){
            		firstPointCaptured = false;
            		if(Points.size()>2){
                            Points.add(STARTPOINT);
                            ArrayList<Pair<Integer,Integer>> temp_Points=new ArrayList<Pair<Integer,Integer>>();
                            for(int g=0;g<Points.size();g++){
                                int y1 = Points.get(g).getL();
                                int y2 = Points.get(g).getR();
                                temp_Points.add(new Pair<>(y1,y2));
                            }
                            Polygons.add(temp_Points);
                            fill_or_not.add(0);
                            color_array.add(SCR.current_color);
                        }
            		Points = null;
            		t1.repaint(SCR.screen, SCR.a2.screenCopy);
                	SCR.a2.screenLabel.repaint();
                	SCR.a1.rb2.setSelected(false);
                	SCR.a1.rb2.setEnabled(false);
                	SCR.a1.rb1.setEnabled(true);
            		//Points.clear();
            	//	System.out.println("size == "+Polygons.get(0).size());
            	}
            	if(firstPointCaptured){
            		nextPoint = e.getPoint();
                	//System.out.println("Reached :- "+ startPoint+" gggg "+nextPoint);
                	temp.setL(nextPoint.x);temp.setR(nextPoint.y);
                	System.out.println("The point is selected");
                	Points.add(temp);
                	//firstPointCaptured = false;
//                	System.out.println("The line is :- "+"[" +"("+Points.get(i).getL()+","+Points.get(i).getR()+")"+ " "+"("+Points.get(i+1).getL()+","+Points.get(i+1).getR()+")"+"]");
//                	i=i+2;
                	//System.out.println(Points.size());
                	//Repaint.repaint(screen, screenCopy,array,Lines,Circles,Centers,Radius,Rect_array);
                	t1.repaint(SCR.screen, SCR.a2.screenCopy);
                	SCR.a2.screenLabel.repaint();
            	}
            	
            }
        
    }
      public void add_indices(MouseEvent e){
            Point p=e.getPoint();
        //    p.y=-1*p.y;
            for(int i=0;i<Polygons.size();i++){
                Point [] p1 = new Point[Polygons.get(i).size()-1];
                for(int y=0;y<p1.length;y++){
                    p1[y] = new Point(Polygons.get(i).get(y).getL(),Polygons.get(i).get(y).getR());
                }
                if(SCR.a10.isInside(p1, p1.length, p)){
                    if(polygon_indices.contains(i)){
                        polygon_indices.remove((Integer)i);
                    }
                    else{
                        polygon_indices.add(i);
                    }
                }
            }
      }
      
      public void add_color_indices(MouseEvent e){
            Point p=e.getPoint();
        //    p.y=-1*p.y;
            for(int i=0;i<Polygons.size();i++){
                Point [] p1 = new Point[Polygons.get(i).size()-1];
                for(int y=0;y<p1.length;y++){
                    p1[y] = new Point(Polygons.get(i).get(y).getL(),Polygons.get(i).get(y).getR());
                }
                if(SCR.a10.isInside(p1, p1.length, p)){
                    if(fill_or_not.get(i)==1&&color_array.get(i)!=SCR.current_color){
                            color_array.set(i,SCR.current_color);
                            fill_or_not.set(i,1);
                    }
                    else{
                        color_array.set(i,SCR.current_color);
                        fill_or_not.set(i,(fill_or_not.get(i)+1)%2);
                    }
                }
            }
      }
        
      public void delete_indices(){
         // ArrayList<ArrayList<Pair<Integer,Integer>>> temp_Polygons=new ArrayList<ArrayList<Pair<Integer,Integer>>>();
         polygon_indices.sort(null); 
         for(int i=polygon_indices.size()-1;i>=0;i--){
              Polygons.remove((int)polygon_indices.get(i));
              color_array.remove((int)polygon_indices.get(i));
              fill_or_not.remove((int)polygon_indices.get(i));
          }
//          Polygons.removeAll(temp_Polygons);
          polygon_indices.clear();
      }
}
