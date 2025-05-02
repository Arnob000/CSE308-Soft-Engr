import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Crewmate> crewmates=new ArrayList<>();
        Imposter im;
        Crewmate cm;
        String s="";
        double val;
        for(int i=0; i<5; i++){
            val=Math.random()*2;
            s=s+(i+1);
            if(val>1){
                im=new Monster(s);
                val=Math.random()*2;
                if(val>1) {
                    im.poison();
                    im.setType(1);
                }
                else {
                    im.damage();
                    im.setType(0);
                }
                crewmates.add(new ImposterAdapter(im));
            }
            else{
                cm=new Crew(s);
                val=Math.random()*2;
                if(val>1) {
                    cm.study();
                    cm.setType(1);
                }
                else {
                    cm.maintenance();
                    cm.setType(0);
                }
                crewmates.add(cm);
            }
            s="";
        }
        System.out.println("\nSome Crewmates have started to notice strange behavior from some of the passengers...");
        System.out.println("Crewpter has been developed by the non-passangers...\n");
        //Usage of Adapter
        for (Crewmate c: crewmates){
            if(c.getType()==1)
                c.study();
            else
                c.maintenance();
        }
    }
}
