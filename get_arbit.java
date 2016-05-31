import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class get_arbit {
	int curX = -1, curY = -1;
	int r =0;
	SCR t1 = new SCR(r);
	ArrayList<ArrayList<Integer>> array=new ArrayList<ArrayList <Integer> >();
	public get_arbit() {
	}
	public void select_arbit(MouseEvent me){
        Point p = me.getPoint();
        curX = p.x;
        curY = p.y;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(curX);
        temp.add(curY);
        array.add(temp);
        t1.repaint(SCR.screen, SCR.a2.screenCopy);
        SCR.a2.screenLabel.repaint();
    }

}
