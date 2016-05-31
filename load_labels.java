
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import sun.security.pkcs11.wrapper.Constants;

public class load_labels {
    int r =0;
    SCR t1 = new SCR(r);
    public void load() throws FileNotFoundException, IOException, InterruptedException{
        Runtime rt = Runtime.getRuntime();
        System.out.println("text start");
        Process pr = rt.exec("text.exe " +SCR.current_file_name);
        pr.waitFor();
        System.out.println("text done");
        File f = new File(SCR.current_file_name+".txt");
//        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String s1 = br.readLine();
        while(s1!=null){
            if(s1.contains("-")){
                int y = s1.indexOf("-");
                String [] fr = s1.split("-");
                fr[1] = s1.substring(y+1);
                String label = fr[1];
                String [] gt = fr[0].split(",");
                Rectangle r1 = new Rectangle(Integer.valueOf(gt[0]),Integer.valueOf(gt[1]),Integer.valueOf(gt[2]),Integer.valueOf(gt[3]));
                if(!SCR.a6.Rect_array.contains(r1)){
                    String h1 ="";String t1 = "";
                    SCR.label_counts++;
                    Pair<String,String> temp_pair = new Pair <String,String> (h1,t1);
                    temp_pair.setL(String.valueOf(SCR.label_counts));
                    temp_pair.setR(label);
                    SCR.a6.label.add(temp_pair);
                    SCR.a6.Rect_array.add(r1);
                    System.out.println(s1);
                }
            }
            s1 = br.readLine();
        }
        br.close();
    }
    public void store() throws FileNotFoundException, IOException{
        File f = new File(SCR.current_file_name+".txt");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
        for(int i=0;i<SCR.a6.Rect_array.size();i++){
            String s1 = String.valueOf(SCR.a6.Rect_array.get(i).x);
            String s2 = String.valueOf(SCR.a6.Rect_array.get(i).y);
            String s3 = String.valueOf(SCR.a6.Rect_array.get(i).width);
            String s4 = String.valueOf(SCR.a6.Rect_array.get(i).height);
            String label = SCR.a6.label.get(i).getR();
            o.append(s1+","+s2+","+s3+","+s4+"-"+label);
            o.append(Constants.NEWLINE);
        }
        BufferedImage temp = ImageIO.read(t1.current_file);
        for(int i=0;i<SCR.a6.Rect_array.size();i++){
            int x1 = SCR.a6.Rect_array.get(i).x;
            int y1 = SCR.a6.Rect_array.get(i).y;
            int w = SCR.a6.Rect_array.get(i).width;
            int h = SCR.a6.Rect_array.get(i).height;
            int r = 255;
            int g = 255;
            int b = 255;
            int col = (r << 16) | (g << 8) | b;
            for(int f1 = y1;f1<y1+h;f1++){
                for(int g1 = x1;g1<x1+w;g1++){
                    temp.setRGB(g1, f1, col);
                }
            }
        }
        String h1 = t1.current_file.getAbsolutePath();
        String h2 = String.valueOf(t1.current_file.getName());
        String ty = h2.substring(0,h2.indexOf("."))+"_1"+h2.substring(h2.indexOf("."));
        String h4 = h1;
        int index=h4.lastIndexOf("\\");
        h4=h4.substring(0, index+1)+ty;
        File outputfile = new File(h4);
        ImageIO.write(temp, "PNG", outputfile);
        
        SCR.current_file = outputfile;
        SCR.screen = ImageIO.read(outputfile);
        SCR.a2.pane.remove(SCR.a2.screenLabel);
        SCR.a2.screenCopy = new BufferedImage(
                                    SCR.screen.getWidth(),
                                    SCR.screen.getHeight(),
                                    SCR.screen.getType());
        SCR.a2.screenLabel = new JLabel(new ImageIcon(SCR.a2.screenCopy));
        SCR.a2.screenLabel.setBounds(100,30,SCR.screen.getWidth(),SCR.screen.getHeight());
        SCR.a15.refresh();
        SCR.a2.pane.add(SCR.a2.screenLabel);
        SCR.fm.validate();
        SCR.fm.repaint();
        t1.repaint(SCR.screen,SCR.a2.screenCopy);
        SCR.a2.screenLabel.repaint();
        SCR.fm.setVisible(true);
        o.close();
        System.out.println(f.getAbsolutePath());
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String s1 = br.readLine();
        while(s1!=null){
            if(s1.contains("-")){
                int y = s1.indexOf("-");
                String [] fr = s1.split("-");
                fr[1] = s1.substring(y+1);
                String label = fr[1];
                String [] gt = fr[0].split(",");
                Rectangle r1 = new Rectangle(Integer.valueOf(gt[0]),Integer.valueOf(gt[1]),Integer.valueOf(gt[2]),Integer.valueOf(gt[3]));
                if(!SCR.a6.Rect_array.contains(r1)){
                    String h12 ="";String t1 = "";
                    SCR.label_counts++;
                    Pair<String,String> temp_pair = new Pair <String,String> (h12,t1);
                    temp_pair.setL(String.valueOf(SCR.label_counts));
                    temp_pair.setR(label);
                    SCR.a6.label.add(temp_pair);
                    SCR.a6.Rect_array.add(r1);
                    System.out.println(s1);
                }
            }
            s1 = br.readLine();
        }
        br.close();
        f.delete();
    }
}
