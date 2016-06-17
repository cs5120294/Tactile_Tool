import javax.swing.JPanel;

public class page2 extends JPanel{
    public page2(){
        SCR.a2.pane.remove(SCR.a1.detect_text);
        SCR.a2.pane.remove(SCR.a1.skip_page1);

        SCR.a2.pane.add(SCR.a1.Select_Text);
        SCR.a1.Select_Text.setBounds(0, 100, 100, 20);

        SCR.a2.pane.add(SCR.a1.Edit);
        SCR.a1.Edit.setBounds(0, 300, 100, 20);

        SCR.a2.pane.add(SCR.a1.delete_page2);
        SCR.a1.delete_page2.setBounds(0, 400, 100, 20);

        SCR.a2.pane.add(SCR.a1.Modify_Label);
        SCR.a1.Modify_Label.setSelected(false);
        SCR.a1.Modify_Label.setBounds(0, 200, 100, 20);

        SCR.a2.pane.add(SCR.a1.Label);
        SCR.a1.Label.setBounds(250, 470, 200, 30); //525
        SCR.a1.Label.setEditable(false);
        SCR.a1.Label.setText("");
        
        SCR.a2.pane.add(SCR.a1.Go_back_page2);
        SCR.a1.Go_back_page2.setBounds(600, 150, 100, 20);  //680
        
        SCR.a2.pane.add(SCR.a1.Next_page2);
        SCR.a1.Next_page2.setBounds(600, 300, 100, 20);
    }
}
