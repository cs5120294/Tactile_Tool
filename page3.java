import javax.swing.JPanel;

public class page3 extends JPanel{
    public page3(){
        SCR.a2.pane.remove(SCR.a1.Select_Text);
        SCR.a2.pane.remove(SCR.a1.Edit);
        SCR.a2.pane.remove(SCR.a1.delete_page2);
        SCR.a2.pane.remove(SCR.a1.Modify_Label);        
        SCR.a2.pane.remove(SCR.a1.Label);
        SCR.a2.pane.remove(SCR.a1.Go_back_page2);
        SCR.a2.pane.remove(SCR.a1.Next_page2);
        
        SCR.a2.pane.add(SCR.a1.Math_diagram); //,BorderLayout.WEST
        SCR.a1.Math_diagram.setBounds(0, 150, 100, 30);
        SCR.a2.pane.add(SCR.a1.Science_diagram);
        SCR.a1.Science_diagram.setBounds(0, 300, 100, 30);

        SCR.a2.pane.add(SCR.a1.Go_back_page3);
        SCR.a1.Go_back_page3.setBounds(600, 150, 100, 20);
        
        SCR.a2.pane.add(SCR.a1.skip_page3);
        SCR.a1.skip_page3.setBounds(600, 300, 100, 20);
    }
}
