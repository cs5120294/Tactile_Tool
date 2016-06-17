import javax.swing.JPanel;

public class page1 extends JPanel{
        public page1(){
            SCR.a2.pane.remove(SCR.a1.Start);
            SCR.a2.pane.add(SCR.a1.detect_text);
            SCR.a1.detect_text.setBounds(0, 150, 100, 30);
            SCR.a2.pane.add(SCR.a1.skip_page1);
            SCR.a1.skip_page1.setBounds(0, 300, 100, 30);
        }
}
