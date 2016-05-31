
public class refresh_all {
    public void refresh(){
        SCR.label_counts = 0;
        SCR.a1.Select_arbit.setState(false);
        SCR.a1.modify_label.setState(false);
        SCR.a1.chkApple.setState(false);
        SCR.a1.arbit_path.setState(false);
        SCR.a1.chkplg.setState(false);
        SCR.a1.chkcrl.setState(false);
        SCR.a1.chk_arc.setState(false);
        SCR.a1.Select_text.setState(false);
        SCR.a1.enter_label.setText("");
        SCR.a1.enter_label.setEditable(false);
        SCR.a1.rb1.setSelected(false);
        SCR.a1.rb2.setSelected(false);
        SCR.a1.rb1.setEnabled(false);
        SCR.a1.rb2.setEnabled(false);
        SCR.a3 = new get_lines();
    	SCR.a4 = new get_circles();
    	SCR.a5 = new get_arbit_2();
    	SCR.a6 = new get_text();
    	SCR.a7 = new get_polygon();
        SCR.a8 = new get_arc();
        SCR.a9 = new modify_text();
        SCR.a16 = new get_arbitpath();
        SCR.a10 = new which_polygon();
        SCR.a11 = new load_labels();
        SCR.a12 = new load_lines_circles();
        SCR.a13 = new svg_generate();
        SCR.a14 = new add_listener_to_screenlabel();
        
    }
}
