import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;


public class Listener {
    int r=0;
    SCR t1 = new SCR(r);
    JMenuBar menu_bar = new JMenuBar();
    JMenu file_menu = new JMenu("File");
    JMenuItem open_file = new JMenuItem("Open");
    Checkbox chkApple = new Checkbox("Select Line");
    Checkbox chkcrl = new Checkbox("Select Circle");
    Checkbox chk_arc = new Checkbox("Select Arc");
    Checkbox Select_arbit = new Checkbox("Draw Region");
    Checkbox Select_text = new Checkbox("Select text");
    Checkbox edit = new Checkbox("Edit");
    Checkbox arbit_path = new Checkbox("Select path");
    Checkbox chkplg = new Checkbox("Select Polygon");
    Checkbox color = new Checkbox("Modify Color");
    Checkbox fill_color = new Checkbox("Fill Color");
    JRadioButton rb1 = new JRadioButton("Start");
    JRadioButton rb2 = new JRadioButton("End");
    JRadioButton edit_circle = new JRadioButton("Circle");
    JRadioButton edit_arc = new JRadioButton("Arc");
    JRadioButton edit_line = new JRadioButton("Line");
    JRadioButton edit_polygon = new JRadioButton("Polygon");
    JRadioButton edit_text = new JRadioButton("Text");
    JRadioButton edit_region = new JRadioButton("Region");
    
    
    JButton delete=new JButton("Delete");
    
    JButton load_ankit = new JButton("TXT_S");
    JButton load_abhi = new JButton("MATH");
    JButton store_ankit = new JButton("TXT_E");
    JButton store_abhi = new JButton("abhi_s");
    JButton generate_svg = new JButton("SVG");
    JButton clear_svg = new JButton("CLEAR");
    JButton selected_color = new JButton("");
    JButton choose_color = new JButton("Fill");
    
    Checkbox modify_label = new Checkbox("Modify label");
    JTextField enter_label=new JTextField();
    
    public void disable_edit_all(){
        edit.setState(false);
        color.setState(false);
        fill_color.setState(false);
        edit_circle.setEnabled(false);
        edit_arc.setEnabled(false);
        edit_line.setEnabled(false);
        edit_polygon.setEnabled(false);
        edit_text.setEnabled(false);
        edit_region.setEnabled(false);
        edit_circle.setSelected(false);
        edit_arc.setSelected(false);
        edit_line.setSelected(false);
        edit_polygon.setSelected(false);
        edit_text.setSelected(false);
        edit_region.setSelected(false);
    }
    public void deselect_Rest_of_editoptions(ItemEvent e){
        SCR.edit_counter=1;
        edit_circle.setSelected(false);
        edit_arc.setSelected(false);
        edit_line.setSelected(false);
        edit_polygon.setSelected(false);
        edit_text.setSelected(false);
        edit_region.setSelected(false);
        JRadioButton b=(JRadioButton)e.getItem();
        b.setSelected(true);
//        String b1 = e.getItem().toString();
//        String [] gh = b1.split("=");
//        b1 = gh[gh.length-1].substring(0,gh[gh.length-1].length()-1);
//        System.out.println(b1);
//        switch(b1){
//            case "Circle":
//                edit_circle.setSelected(true);break;
//            case "Line":
//                edit_line.setSelected(true);break;
//            case "Polygon":
//                edit_polygon.setSelected(true);break;
//            case "Text":
//                edit_text.setSelected(true);break;
//            case "Region":
//                edit_region.setSelected(true);break;
//        }
                    
    }
	
	public Listener() {		
		
            open_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnVal =  fc.showOpenDialog(SCR.fm);
                System.out.println(returnVal);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    
                    try {
                        File file1 = fc.getSelectedFile();
                        SCR.current_file = file1;
                        SCR.current_file_name = String.valueOf(SCR.current_file.getName());
                        SCR.screen = ImageIO.read(file1);
                        SCR.a2.pane.remove(SCR.a2.screenLabel);
                        SCR.a2.screenCopy = new BufferedImage(
                                                SCR.screen.getWidth(),
                                                SCR.screen.getHeight(),
                                                SCR.screen.getType());
                        SCR.a2.screenLabel = new JLabel(new ImageIcon(SCR.a2.screenCopy));
                        SCR.a2.screenLabel.setBounds(100,30,SCR.screen.getWidth(),SCR.screen.getHeight());
                        SCR.a15.refresh();
                        SCR.a17.restore();
                        SCR.a2.pane.add(SCR.a2.screenLabel);
                        SCR.fm.validate();
                        SCR.fm.repaint();
                        t1.repaint(SCR.screen,SCR.a2.screenCopy);
                        SCR.a2.screenLabel.repaint();
                        SCR.fm.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (XPathExpressionException ex) {
                        Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
            
            
		final MouseEvent m = null;
		rb1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    modify_label.setState(false);
                    chkApple.setState(false);
                    chkcrl.setState(false);
                    arbit_path.setState(false);
                    chk_arc.setState(false);
                    rb2.setSelected(false);
                    Select_text.setState(false);
                    System.out.println("Start");  
                    disable_edit_all();
            	}
               }
         });
		
		rb2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    modify_label.setState(false);
                    chkApple.setState(false);
                    arbit_path.setState(false);
                    chkcrl.setState(false);
                    chk_arc.setState(false);
                    Select_text.setState(false);
                    //rb1.setSelected(false);
                    SCR.a7.get_polygons(m);
                    System.out.println("End");  
                    disable_edit_all();
            	}
               }
         });

            Select_arbit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    modify_label.setState(false);
                    chkApple.setState(false);
                    chkplg.setState(false);
                    arbit_path.setState(false);
                    chkcrl.setState(false);
                    chk_arc.setState(false);
                    Select_text.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    System.out.println("Draw any arbitrary Shape");
                    disable_edit_all();
                    //color.setState(false);
            	}
               }
         });
            arbit_path.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    modify_label.setState(false);
                    chkApple.setState(false);
                    chkplg.setState(false);
                    Select_arbit.setState(false);
                    chkcrl.setState(false);
                    chk_arc.setState(false);
                    Select_text.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    System.out.println("Draw any arbitrary path");
                    disable_edit_all();
                    //color.setState(false);
            	}
               }
         });
		chkplg.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    modify_label.setState(false);
                    rb1.setEnabled(true);
                    rb2.setEnabled(false);
                    chkApple.setState(false);
                    arbit_path.setState(false);
                    chkcrl.setState(false);
                    chk_arc.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    Select_text.setState(false);
                    Select_arbit.setState(false);
                    System.out.println("Select the start button");  
                    disable_edit_all();
            	}
            	else{
            		rb1.setSelected(false);
            		rb2.setSelected(false);
            		rb1.setEnabled(false);
            		rb2.setEnabled(false);
            	}
               }
         });
        Select_text.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    chkApple.setState(false);
                    modify_label.setState(false);
                    chkplg.setState(false);
                    chkcrl.setState(false);
                    arbit_path.setState(false);
                    chk_arc.setState(false);
                    Select_arbit.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    System.out.println("Select text");  
                    disable_edit_all();
            	}
            
               }
         });
       
        chkApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    chkcrl.setState(false);
                    modify_label.setState(false);
                    chk_arc.setState(false);
                    chkplg.setState(false);
                    arbit_path.setState(false);
                    Select_arbit.setState(false);
                    Select_text.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    System.out.println("Select any two points for the line");  
                    disable_edit_all();
            	}
            
               }
         });
        chkcrl.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    chkApple.setState(false);
                    chkplg.setState(false);
                    modify_label.setState(false);
                    chk_arc.setState(false);
                    arbit_path.setState(false);
                    Select_arbit.setState(false);
                    Select_text.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    System.out.println("Select any three points on the circle");
                    disable_edit_all();
            	}
            
               }
         });
        chk_arc.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    chkApple.setState(false);
                    chkplg.setState(false);
                    chkcrl.setState(false);
                    Select_arbit.setState(false);
                    modify_label.setState(false);
                    arbit_path.setState(false);
                    Select_text.setState(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    System.out.println("Select any three points on the arc");
                    disable_edit_all();
            	}
            
               }
         });
        edit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    chkcrl.setState(false);
                    chk_arc.setState(false);
                    chkApple.setState(false);
                    chkplg.setState(false);
                    arbit_path.setState(false);
                    modify_label.setState(false);
                    Select_arbit.setState(false);
                    Select_text.setState(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    color.setState(false);
                    fill_color.setState(false);
//                    edit_circle.setEnabled(true);
//                    edit_arc.setEnabled(true);
//                    edit_line.setEnabled(true);
//                    edit_polygon.setEnabled(true);
//                    edit_text.setEnabled(true);
//                    edit_region.setEnabled(true);
            	}
                else{
                    disable_edit_all();
                }
            
               }
         });
        color.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                   chkcrl.setState(false);
                    chk_arc.setState(false);
                    chkApple.setState(false);
                    chkplg.setState(false);
                    arbit_path.setState(false);
                    modify_label.setState(false);
                    Select_arbit.setState(false);
                    Select_text.setState(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    edit.setState(false);
                    fill_color.setState(false);
                }
            }
        });
        
        fill_color.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                   chkcrl.setState(false);
                    chk_arc.setState(false);
                    chkApple.setState(false);
                    chkplg.setState(false);
                    arbit_path.setState(false);
                    modify_label.setState(false);
                    Select_arbit.setState(false);
                    Select_text.setState(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    enter_label.setText("");
                    enter_label.setEditable(false);
                    edit.setState(false);
                    color.setState(false);
                }
            }
        });
                
        edit_circle.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1&&SCR.edit_counter==0){
//                    System.out.println("kuch bhi");
                    deselect_Rest_of_editoptions(e);
                    SCR.edit_counter=0;
            	}
               }
         });
        edit_arc.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1&&SCR.edit_counter==0){
//                    System.out.println("kuch bhi");
                    deselect_Rest_of_editoptions(e);
                    SCR.edit_counter=0;
            	}
               }
         });
        
        edit_line.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1&&SCR.edit_counter==0){
//                    System.out.println("kuch bhi");
                    deselect_Rest_of_editoptions(e);
                    SCR.edit_counter=0;
            	}
               }
         });
        edit_polygon.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1&&SCR.edit_counter==0){
//                    System.out.println("kuch bhi");
                    deselect_Rest_of_editoptions(e);
                    SCR.edit_counter=0;
            	}
               }
         });
        edit_text.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1&&SCR.edit_counter==0){
                       
                    deselect_Rest_of_editoptions(e);
                    SCR.edit_counter=0;
            	}
               }
         });
        
        edit_region.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1&&SCR.edit_counter==0){
//                    System.out.println("kuch bhi");
                    deselect_Rest_of_editoptions(e);
                    SCR.edit_counter=0;
            	}
               }
         });
            delete.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        SCR.a4.delete_indices();
                        SCR.a3.delete_line_indices();
                        SCR.a6.delete_indices();
                        SCR.a8.delete_indices();
                        SCR.a7.delete_indices();
                        SCR.a5.delete_indices();
                        SCR.a16.delete_indices();
                        t1.repaint(SCR.screen, SCR.a2.screenCopy);
                        SCR.a2.screenLabel.repaint();
                    }               
            });
            load_ankit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SCR.a11.load();
                            t1.repaint(SCR.screen, SCR.a2.screenCopy);
                            SCR.a2.screenLabel.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            
            store_ankit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SCR.a11.store();
                            t1.repaint(SCR.screen, SCR.a2.screenCopy);
                            SCR.a2.screenLabel.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            load_abhi.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SCR.a12.load();
                            t1.repaint(SCR.screen, SCR.a2.screenCopy);
                            SCR.a2.screenLabel.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            
            store_abhi.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SCR.a12.store();
                            t1.repaint(SCR.screen, SCR.a2.screenCopy);
                            SCR.a2.screenLabel.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            
            generate_svg.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SCR.a13.svg_file();
                            if(SCR.current_file.getAbsolutePath().contains("_1.")){
                                SCR.current_file.delete();
                            }
                            t1.repaint(SCR.screen,SCR.a2.screenCopy);
                            SCR.a2.screenLabel.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            choose_color.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SCR.a18.actionPerformed(e);
                    }
                });
            clear_svg.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SCR.a15.refresh();
                            
                            SCR.a13.svg_file();
                            t1.repaint(SCR.screen,SCR.a2.screenCopy);
                            SCR.a2.screenLabel.repaint();
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            
            
            
            modify_label.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
            	if(e.getStateChange()==1){
                    chkApple.setState(false);
                    chkplg.setState(false);
                    arbit_path.setState(false);
                    Select_arbit.setState(false);
                    chkcrl.setState(false);
                    chk_arc.setState(false);
                    Select_text.setState(false);
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    if(SCR.a9.selected_rect!=10000){
                    //    enter_label.setEnabled(true);
                        enter_label.setEditable(true);
                        if(SCR.a6.label.get(SCR.a9.selected_rect).getR().contains("label -")){
                    //    if(SCR.a6.label.get(SCR.a9.selected_rect).contains("label -")){    
                            enter_label.setText("");
                        }
                        else{
                            enter_label.setText(SCR.a6.label.get(SCR.a9.selected_rect).getR());
                        //    enter_label.setText(SCR.a6.label.get(SCR.a9.selected_rect));
                        }
                    }
                    System.out.println("Draw any arbitrary Shape");
                    disable_edit_all();    
            	}
                else{
                    enter_label.setText("");
                //    enter_label.setEnabled(false);
                    enter_label.setEditable(false);
                }
               }
         });
            
            
//    enter_label.addKeyListener(new KeyAdapter()
//    {
//        public void keyPressed(KeyEvent ke)
//        {
//            
//            
//            //SCR.a6.label.set(SCR.a9.selected_rect,enter_label.getText());
//        }
//    });
    enter_label.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String th = SCR.a6.label.get(SCR.a9.selected_rect).getL();
                    //System.out.println(enter_label.getText());
                    Pair<String,String> temp_pair = new Pair <String,String> (th,enter_label.getText());
                    SCR.a6.label.set(SCR.a9.selected_rect,temp_pair);
                    t1.repaint(SCR.screen,SCR.a2.screenCopy);
                    SCR.a2.screenLabel.repaint();
                }
            });
        
	}

}
