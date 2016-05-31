
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saurabh Nakra
 */
public class add_listener_to_screenlabel {
    int r =0;
    SCR t1 = new SCR(r);
    public add_listener_to_screenlabel(){
        add();
    }
    public void add(){
        SCR.a2.screenLabel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me) {
                SCR.start = me.getPoint();
                t1.repaint(SCR.screen,SCR.a2.screenCopy);
                SCR.a2.screenLabel.repaint();
            }
            
            @Override
            public void mouseDragged(MouseEvent me) {
               if(SCR.a1.Select_arbit.getState()){ SCR.a5.get_region(me);}
               else if(SCR.a1.arbit_path.getState()){
                   SCR.a16.get_region(me);
               }
               else if(SCR.a1.Select_text.getState()){ SCR.a6.select_text(me);}
            }
        });
        
        SCR.a2.screenLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (SCR.a1.chkApple.getState()){
                    
                    SCR.a3.get_line(e);
                }
                if (SCR.a1.chkcrl.getState()){
                    SCR.a4.get_circle(e);
                }
                if (SCR.a1.chk_arc.getState()){
                    SCR.a8.get_circle(e);
                }
                if (SCR.a1.chkplg.getState()){
                    SCR.a7.get_polygons(e);
                }
                if(SCR.a1.edit.getState()){
                    SCR.a3.add_indices(e);
                    SCR.a4.add_indices(e);
                    SCR.a5.add_indices(e);
                    SCR.a6.add_indices(e);
                    SCR.a7.add_indices(e);
                    SCR.a8.add_indices(e);
                    SCR.a16.add_indices(e);
                }
                if(SCR.a1.color.getState()){
                    SCR.a5.modify_color(e);
                }
                if(SCR.a1.fill_color.getState()){
                    SCR.a5.add_color_indices(e);
                    SCR.a4.add_color_indices(e);
                    SCR.a3.add_color_indices(e);
                    SCR.a7.add_color_indices(e);
                    SCR.a16.add_color_indices(e);
                    SCR.a8.add_color_indices(e);
                }
                
                if(SCR.a1.edit_circle.isSelected()){
                    SCR.a4.add_indices(e);
                }
                if(SCR.a1.edit_arc.isSelected()){
                    SCR.a8.add_indices(e);
                }
                if(SCR.a1.edit_line.isSelected()){
                    SCR.a3.add_indices(e);
                }
                if(SCR.a1.edit_text.isSelected()){
                    SCR.a6.add_indices(e);
                    
                }
                if(SCR.a1.edit_polygon.isSelected()){
                    SCR.a7.add_indices(e);
                }
                if(SCR.a1.edit_region.isSelected()){
                    SCR.a5.add_indices(e);
                }
                if(SCR.a1.modify_label.getState()){
                    SCR.a9.modify_selected_rect(e);
                    if(SCR.a9.selected_rect!=10000){
                        SCR.a1.enter_label.setEditable(true);
                        if(SCR.a6.label.get(SCR.a9.selected_rect).getR().contains("label -")){
                    //    if(a6.label.get(a9.selected_rect).contains("label -")){
                            SCR.a1.enter_label.setText("");
                        }
                        else{
                            SCR.a1.enter_label.setText(SCR.a6.label.get(SCR.a9.selected_rect).getR());
                        //    a1.enter_label.setText(a6.label.get(a9.selected_rect));
                        
                        }
                        
                    }
                }
                t1.repaint(SCR.screen,SCR.a2.screenCopy);
                SCR.a2.screenLabel.repaint();
            }
            public void mouseEntered(MouseEvent arg0) {
            }
            public void mouseExited(MouseEvent arg0) {
            }
            public void mousePressed(MouseEvent arg0) {
            }
            public void mouseReleased(MouseEvent me){
            	if(SCR.a1.Select_text.getState()){
                    SCR.a6.update_capture_rect(me);
            	} 
                if(SCR.a1.Select_arbit.getState()){
                    SCR.a5.update_regions();
                }
                if(SCR.a1.arbit_path.getState()){
                    SCR.a16.update_regions();
                }
            }
        });
    }
    
}
