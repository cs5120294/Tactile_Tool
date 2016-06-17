import java.awt.Color;
import javax.swing.JPanel;

public class page5 extends JPanel{
    public page5(){
        SCR.a2.pane.remove(SCR.a1.Line);
        SCR.a2.pane.remove(SCR.a1.Circle);
        SCR.a2.pane.remove(SCR.a1.Arc);
        SCR.a2.pane.remove(SCR.a1.Polygon);
        SCR.a2.pane.remove(SCR.a1.Path);
        SCR.a2.pane.remove(SCR.a1.Region);
        SCR.a2.pane.remove(SCR.a1.Edit_page4);
        SCR.a2.pane.remove(SCR.a1.delete_page4);  
        SCR.a2.pane.remove(SCR.a1.Go_back_page4);
        SCR.a2.pane.remove(SCR.a1.Next_page4);
        
        SCR.a2.pane.add(SCR.a1.Fill_color);
        SCR.a1.Fill_color.setBounds(0,150,100,20);
        
        SCR.a2.pane.add(SCR.a1.Selected_color);
        SCR.a1.Selected_color.setBounds(0, 300,30,20);
        SCR.a1.Selected_color.setEnabled(false);
        SCR.a1.Selected_color.setBackground(Color.black);
        SCR.current_color=Color.black;
        SCR.a2.pane.add(SCR.a1.Choose_color);
        SCR.a1.Choose_color.setBounds(30, 300,70,20);

        SCR.a2.pane.add(SCR.a1.Go_back_page5);
        SCR.a1.Go_back_page5.setBounds(600, 150, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.Finish);
        SCR.a1.Finish.setBounds(600, 300, 100, 20);
    }
}
