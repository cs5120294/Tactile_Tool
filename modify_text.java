
import java.awt.event.MouseEvent;

public class modify_text {
    int selected_rect=10000;
    public void modify_selected_rect(MouseEvent e){
        for(int i=0;i<SCR.a6.Rect_array.size();i++){
            if(SCR.a6.Rect_array.get(i).contains(e.getPoint())){
                if(selected_rect==i){
                    selected_rect=10000;
                }
                else{
                    selected_rect=i;
                }
            }
        }
    }
}
