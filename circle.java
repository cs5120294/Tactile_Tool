

public class circle {
	
	public float get_radius(Pair<Float,Float> A, Pair<Float,Float> B){
        float rad;
        rad = (float) Math.pow(Math.pow((A.getL()-B.getL()), 2) + Math.pow((A.getR()-B.getR()), 2),0.5);

        return rad;
    }
    public  int calc_an(int a1,int a2){
        int an=0;
        an = (int) ( (double)(180.0/Math.PI) * Math.acos(a1/Math.pow((Math.pow(a1,2)+Math.pow(a2,2)),0.5))  );
        if(a2>0){
            an = 360-an;
        }
        return an;    }

    public int[] calc_angles(int a1,int a2,int b1,int b2,int c1,int c2){
        int [] p = calc(a1,a2,b1,b2,c1,c2);
        int c_x = p[0];
        int c_y = p[1];
        int [] s1 = new int[3];
        int [] arc_angles = new int[2];
        
        s1[0] = calc_an(a1-c_x,a2-c_y);
        
        s1[1] = calc_an(b1-c_x,b2-c_y);
        s1[2] = calc_an(c1-c_x,c2-c_y);
        System.out.println(s1[0]+","+s1[1]+","+s1[2]);
        if(s1[0]<s1[2]){
            
            if(s1[1]>s1[0]&&s1[1]<s1[2]){
                arc_angles[1]=s1[2]-s1[0];
                arc_angles[0]=s1[0];
            }
            else{
                arc_angles[0]=s1[2];
                arc_angles[1]=360-(s1[2]-s1[0]);
            }
        }
        else{
            
            if(s1[1]<s1[2]||s1[0]<s1[1]){
                arc_angles[1]=360-s1[0]+s1[2];
                arc_angles[0]=s1[0];
            }
            else{
                arc_angles[0]=s1[2];
                arc_angles[1]=s1[0]-s1[2];
            }
        }
        return arc_angles;
    }
    public int[] calc(int a1,int a2,int b1,int b2,int c1,int c2){        
        int m1,m2;
        int n1,n2;
        m1=(a1+b1)/2;
        m2=(a2+b2)/2;
        n1=(a1+c1)/2;
        n2=(a2+c2)/2;
        int cenx = 0;
        int ceny = 0;
        int a = 0,b = 0,c = 0;
            int d = 0,e = 0,f = 0;
            if(a1==c1){
                d=0;e=1;f=-n2;ceny = n2;
                if(a2==b2){
                    cenx = m1;
                }
                else{
                    a=b1-a1;
                    b=b2-a2;
                    c=-1*(a*m1+b*m2);
                    cenx = (b*f-c)/a;
                }
            }
            else if(a1==b1){
                a=0;b=1;c=-m2;ceny = m2;
                if(a2==c2){
                    cenx = n1;
                }
                else{
                    d=c1-a1;
                    e=c2-a2;
                    f=-1*(d*n1+e*n2);
                    cenx = (e*c-f)/d;
                }
            }
            else if(a2==c2){
                d=1;e=0;f=-n1;cenx = n1;
                if(a1==b1){
                    ceny = m2;
                }
                else{
                    a=b1-a1;
                    b=b2-a2;
                    c=-1*(a*m1+b*m2);
                    ceny = (-1*c-a*n1)/b;
                }
            }
            else if(a2==b2){
                a=1;b=0;c=-m1;cenx = m1;
                if(a1==c1){
                    ceny = m2;
                }
                else{
                    d=c1-a1;
                    e=c2-a2;
                    f=-1*(d*n1+e*n2);
                    ceny = (-1*f-d*m1)/e;
                }
            }
            else{
                a=b1-a1;
                b=b2-a2;
                c=-1*(a*m1+b*m2);
                d=c1-a1;
                e=c2-a2;
                f=-1*(d*n1+e*n2);
                ceny = (a*f-c*d)/(b*d-a*e);
                cenx = (b*f-c*e)/(a*e-b*d); 
            }
            int [] ret = new int[3];
            ret[0] = cenx;
            ret[1] = ceny;
            return ret;
    }
    public static void main(String[] args){
//        int [] s = calc_angles(50,0,0,50,100,50);
//        System.out.println(s[0]+","+s[1]);
    }
}
