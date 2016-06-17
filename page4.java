import javax.swing.JPanel;

public class page4 extends JPanel{
    public page4(){
        SCR.a2.pane.remove(SCR.a1.Math_diagram);
        SCR.a2.pane.remove(SCR.a1.Science_diagram);
        SCR.a2.pane.remove(SCR.a1.Go_back_page3);
        SCR.a2.pane.remove(SCR.a1.skip_page3);        

        SCR.a2.pane.add(SCR.a1.Line);
        SCR.a1.Line.setBounds(0, 50, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.Circle);
        SCR.a1.Circle.setBounds(0, 100, 100, 20);

        SCR.a2.pane.add(SCR.a1.Arc);
        SCR.a1.Arc.setBounds(0, 150, 100, 20);

        SCR.a2.pane.add(SCR.a1.Polygon);
        SCR.a1.Polygon.setBounds(0, 200, 100, 20);

        SCR.a2.pane.add(SCR.a1.Path);
        SCR.a1.Path.setBounds(0, 250, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.Region);
        SCR.a1.Region.setBounds(0, 300, 100, 20);

        SCR.a2.pane.add(SCR.a1.Edit_page4);
        SCR.a1.Edit_page4.setBounds(0, 370, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.delete_page4);
        SCR.a1.delete_page4.setBounds(0, 420, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.Go_back_page4);
        SCR.a1.Go_back_page4.setBounds(600, 150, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.Next_page4);
        SCR.a1.Next_page4.setBounds(600, 300, 100, 20);
    }
}
