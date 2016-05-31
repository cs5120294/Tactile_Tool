import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class label_image extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel buttonPanel = new JPanel();
	JPanel panel = new JPanel(new BorderLayout());
	JLabel screenLabel=null;
        Container pane = null;
	BufferedImage screenCopy;
//	SCR t1 = new SCR();
	public label_image() {
		// TODO Auto-generated constructor stub
		
		screenCopy = new BufferedImage(
                SCR.screen.getWidth(),
                SCR.screen.getHeight(),
                SCR.screen.getType());
        screenLabel = new JLabel(new ImageIcon(screenCopy));
        JScrollPane screenScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane = SCR.fm.getContentPane();
        SCR.fm.setContentPane(screenScroll);
        pane = SCR.fm.getContentPane();
        pane.setLayout(null);
        SCR.a1.menu_bar.setBounds(0, 0,700, 30);
        
        //menu_bar.setBounds(0, 0,500, 30);
        SCR.a1.file_menu.setBounds(0,0,50,30);
        SCR.a1.open_file.setBounds(0,30,50,30);
//        pane.add(file_menu);
        SCR.a1.file_menu.add(SCR.a1.open_file);
        SCR.a1.menu_bar.add(SCR.a1.file_menu);
        pane.add(SCR.a1.menu_bar);
        pane.add(screenLabel);
        Insets insets = pane.getInsets();
        Dimension size = screenLabel.getPreferredSize();
        System.out.println(insets.left+" "+insets.top+" "+insets.bottom+" "+insets.right+" "+size.width+" "+size.height);
        screenLabel.setBounds(100,30,SCR.screen.getWidth(),SCR.screen.getHeight());
        
        pane.add(SCR.a1.chkcrl);
        SCR.a1.chkcrl.setBounds(0, 30, 100, 20);
        SCR.a1.chkcrl.setState(false);
        pane.add(SCR.a1.chk_arc);
        SCR.a1.chk_arc.setBounds(0, 50, 100, 20);
        SCR.a1.chk_arc.setState(false);
        pane.add(SCR.a1.Select_arbit);
        SCR.a1.Select_arbit.setBounds(0, 70, 100, 20);
        SCR.a1.Select_arbit.setState(false);
        pane.add(SCR.a1.Select_text);
        SCR.a1.Select_text.setBounds(0, 90, 100, 20);
        SCR.a1.Select_text.setState(false);
        pane.add(SCR.a1.chkplg);
        SCR.a1.chkplg.setBounds(0, 110, 100, 20);
        SCR.a1.chkplg.setState(false);
        SCR.a1.rb1.setSelected(false);
        SCR.a1.rb1.setEnabled(false);
        pane.add(SCR.a1.rb1);
        SCR.a1.rb1.setBounds(20, 130, 80, 20);
        SCR.a1.rb2.setEnabled(false);
        SCR.a1.rb2.setSelected(false);
        pane.add(SCR.a1.rb2);
        SCR.a1.rb2.setBounds(20, 150, 80, 20);
        pane.add(SCR.a1.arbit_path);
        SCR.a1.arbit_path.setBounds(0,170,100,20);
        SCR.a1.arbit_path.setState(false);
        pane.add(SCR.a1.chkApple);
        SCR.a1.chkApple.setBounds(0, 190, 100, 20);
        SCR.a1.chkApple.setState(false);
        pane.add(SCR.a1.edit);
        SCR.a1.edit.setState(false);
        pane.add(SCR.a1.modify_label);
        SCR.a1.modify_label.setState(false);
        SCR.a1.modify_label.setBounds(0, 210, 100, 20);
        pane.add(SCR.a1.enter_label);
        SCR.a1.enter_label.setBounds(20, 230, 80, 20);
        SCR.a1.enter_label.setEditable(false);
        SCR.a1.enter_label.setText("");
        SCR.a1.edit.setBounds(0, 250, 100, 20);
//        pane.add(SCR.a1.color);
//        SCR.a1.color.setBounds(0,270,100,20);
        pane.add(SCR.a1.fill_color);
        SCR.a1.fill_color.setBounds(0,270,100,20);
//        SCR.pane.add(SCR.a1.edit_circle);
//        SCR.a1.edit_circle.setBounds(20, 230, 80, 20);
//        SCR.a1.edit_circle.setEnabled(false);
//        SCR.pane.add(SCR.a1.edit_arc);
//        SCR.a1.edit_arc.setBounds(20, 250, 80, 20);
//        SCR.a1.edit_arc.setEnabled(false);
//        SCR.pane.add(SCR.a1.edit_line);
//        SCR.a1.edit_line.setBounds(20, 270, 80, 20);
//        SCR.a1.edit_line.setEnabled(false);
//        SCR.pane.add(SCR.a1.edit_polygon);
//        SCR.a1.edit_polygon.setBounds(20, 290, 80, 20);
//        SCR.a1.edit_polygon.setEnabled(false);
//        SCR.pane.add(SCR.a1.edit_text);
//        SCR.a1.edit_text.setBounds(20, 310, 80, 20);
//        SCR.a1.edit_text.setEnabled(false);
//        SCR.pane.add(SCR.a1.edit_region);
//        SCR.a1.edit_region.setBounds(20, 330, 80, 20);
//        SCR.a1.edit_region.setEnabled(false);
        pane.add(SCR.a1.delete);
        SCR.a1.delete.setBounds(20, 350, 80, 20);
        pane.add(SCR.a1.load_ankit);
        SCR.a1.load_ankit.setBounds(20, 370, 80, 20);
        pane.add(SCR.a1.store_ankit);
        SCR.a1.store_ankit.setBounds(20, 390, 80, 20);
        pane.add(SCR.a1.load_abhi);
        SCR.a1.load_abhi.setBounds(20, 410, 80, 20);
//        pane.add(SCR.a1.store_abhi);
//        SCR.a1.store_abhi.setBounds(20, 430, 80, 20);        
        pane.add(SCR.a1.generate_svg);
        SCR.a1.generate_svg.setBounds(20, 450,80,20);
        pane.add(SCR.a1.selected_color);
        SCR.a1.selected_color.setBounds(20, 470,20,20);
        SCR.a1.selected_color.setEnabled(false);
        SCR.a1.selected_color.setBackground(Color.black);
        SCR.current_color=Color.black;
        pane.add(SCR.a1.choose_color);
        SCR.a1.choose_color.setBounds(40, 470,60,20);
        pane.add(SCR.a1.clear_svg);
        SCR.a1.clear_svg.setBounds(20, 490,80,20);
	}

}
