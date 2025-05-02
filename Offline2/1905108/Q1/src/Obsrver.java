import java.util.Currency;
import java.util.Scanner;

abstract class Obsrver {
    protected Subject subject;
    public abstract void update();

    public abstract void display(String prevState, String curState, String msg);

}

class premiumUser extends Obsrver{
    private String prevState;
    private String curState;
    private String msg;
    int ser;
    premiumUser(Subject sub){
        this.subject=sub;
        sub.register(this);
    }

    @Override
    public void update(){
        prevState=subject.getPrevState();
        curState=subject.getCurrState();
        msg=subject.getPremMsg(this);

        if(curState.equalsIgnoreCase("FullyDown"))
            ser=3;
        else if(curState.equalsIgnoreCase("Operational"))
            ser=1;

        display(prevState,curState,msg);

    }

    @Override
    public void display(String prevState, String curState, String msg) {
        System.out.println("Premium User");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("State changed from "+prevState+" to "+curState+"\n"+msg);
        Scanner scn=new Scanner(System.in);
        if(prevState.equalsIgnoreCase("Operational") && curState.equalsIgnoreCase("Partiallydown")) {
            System.out.print("Enter choice : ");
            if (scn.nextInt() == 1) {
                subject.regDEF(this);
                ser=2;
            }
            else
                ser=3;
        }
        System.out.println();
        if(ser==1){
            System.out.println("Currently using ABC server");
        } else if (ser==2) {
            System.out.println("Currently using both ABC and DEF server");
        } else if (ser==3) {
            System.out.println("Currently using DEF server");
        }
        System.out.println("---------------------------------------------------------------------------");
    }
    

}


class regularUser extends Obsrver{
    private String prevState;
    private String curState;
    private String msgreg;
    int ser;
    
    regularUser(Subject sub){
        this.subject=sub;
        sub.register(this);
    }
    
    
    @Override
    public void update(){
        prevState=subject.getPrevState();
        curState=subject.getCurrState();
        msgreg=subject.getRegMsg(this);

        if(curState.equalsIgnoreCase("Operational")||(curState.equalsIgnoreCase("PartiallyDown") && ser!=2))
            ser=1;
        else if(curState.equalsIgnoreCase("FullyDown") && ser!=2)
            ser=3;

        display(prevState,curState,msgreg);

    }

    @Override
    public void display(String prevState, String curState, String msg){
        System.out.println("Regular User");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("State changed from "+prevState+" to "+curState+"\n"+msg);
        Scanner scn=new Scanner(System.in);
        if(prevState.equalsIgnoreCase("Operational") && (curState.equalsIgnoreCase("Partiallydown") || curState.equalsIgnoreCase("Fullydown")) ){
            System.out.print("Enter choice : ");
            if (scn.nextInt() == 1) {
                subject.regDEF(this);
                ser=2;
            } else if (curState.equalsIgnoreCase("FullyDown")) {
                ser=3;
            } else
                ser=1;
        }
        System.out.println();
        if(ser==1){
            System.out.println("Currently using ABC server");
        } else if (ser==2) {
            System.out.println("Currently using DEF server");
        }
        else {
            System.out.println("Currently service is off");
        }
        System.out.println("---------------------------------------------------------------------------");
    }

}
