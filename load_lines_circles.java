
import java.awt.Color;
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
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import sun.security.pkcs11.wrapper.Constants;

public class load_lines_circles {
    public void load() throws FileNotFoundException, IOException, InterruptedException{
        BufferedImage temp = ImageIO.read(SCR.current_file);
        int r = 255;
        int g = 255;
        int b = 255;
        int col = (r << 16) | (g << 8) | b;
        int col_black = 0;
        int h = temp.getHeight();
        int w = temp.getWidth();
        int count_black = 0;
        int count_white = 0;
        for(int f1 = 0;f1<h;f1++){
            for(int g1 = 0;g1<w;g1++){
                int sRbgColor = temp.getRGB(g1,f1);
                Color c = new Color(sRbgColor);
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
//                if(red<240 && green<240){
//                System.out.println(red+":"+green+":"+blue);
//                }
                if(red<240 && green <240){
                    temp.setRGB(g1, f1, col);
                    count_white++;
                }
                else{
                    count_black++;
                    temp.setRGB(g1, f1, col_black);
                }
            }
        }
        System.out.println(count_white);
        System.out.println(count_black);
        File outputfile = new File("temp_bw.png");
        ImageIO.write(temp, "PNG", outputfile);
        //Thread.sleep(100000000);
        Runtime rt = Runtime.getRuntime();
        System.out.println("Math start");
        Process pr = rt.exec("maths.exe " +"temp_bw.png");
        pr.waitFor();
        outputfile.delete();
        
        System.out.println("Math done");
        File f = new File("output.txt");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String s1 = br.readLine();
        while(s1!=null){
            if(s1.contains("l-")){
                
                String [] fr = s1.split("-");
                String [] gt = fr[1].split(",");
                int h1 = Integer.valueOf(gt[0]);int h2=Integer.valueOf(gt[1]);
                Pair<Integer,Integer> temp_pair = new Pair <> (h1,h2);
                h1 = Integer.valueOf(gt[2]);h2=Integer.valueOf(gt[3]);
                Pair<Integer,Integer> temp_pair_2 = new Pair <> (h1,h2);
                SCR.a3.Lines.add(temp_pair);
                SCR.a3.color_array.add(SCR.current_color);
                SCR.a3.Lines.add(temp_pair_2);
                SCR.a3.color_array.add(SCR.current_color);
//                System.out.println(s1);
            }
            if(s1.contains("c-")){
                String [] fr = s1.split("-");
                String [] gt = fr[1].split(",");
                float f1 = Float.valueOf(gt[0]);
                float f2 = Float.valueOf(gt[1]);
                float f3 = Float.valueOf(gt[2]);
                Pair<Float,Float> temp_pair = new Pair <> (f1,f2);
                SCR.a4.Centers.add(temp_pair);
                SCR.a4.Radius.add(f3);
                SCR.a4.color_array.add(SCR.current_color);
                SCR.a4.fill_or_not.add(0);
            }
            s1 = br.readLine();
        }
        br.close();
        f.delete();
        
    }
    public void store() throws FileNotFoundException, IOException{
        File f = new File("abhi.txt");
        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f));
        for(int i=0;i<SCR.a4.Radius.size();i++){
            String s1 = String.valueOf(SCR.a4.Radius.get(i));
            String s2 = String.valueOf(SCR.a4.Centers.get(i).getL());
            String s3 = String.valueOf(SCR.a4.Centers.get(i).getR()); 
            o.append("c-"+s2+","+s3+","+s1);
            o.append(Constants.NEWLINE);
        }
        for(int i=0;i<SCR.a3.Lines.size()-1;i++){
            String s1 = String.valueOf(SCR.a3.Lines.get(i).getL());
            String s2 = String.valueOf(SCR.a3.Lines.get(i).getR());
            o.append("l-"+s1+","+s2+",");
            i++;
            s1 = String.valueOf(SCR.a3.Lines.get(i).getL());
            s2 = String.valueOf(SCR.a3.Lines.get(i).getR());
            o.append(s1+","+s2);
            o.append(Constants.NEWLINE);
        }
        o.close();
    }
}
