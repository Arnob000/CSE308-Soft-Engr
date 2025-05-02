import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


interface Subject {
    public void register(Obsrver o);
    public void unregister(Obsrver o);
    public void notifyall();
    public void regDEF(Obsrver o);

    public String getPrevState();
    public String getCurrState();
    public String getPremMsg(Obsrver obs);
    public String getRegMsg(Obsrver obs);
}

class ABCserver implements Subject{
    private final int Operational=0;
    private final int PartiallyDown=1;
    private final int FullyDown=2;

    private int prevState;
    private int curState;

    List<Obsrver> observers;
    List<Obsrver> obDEF;
    String msg;
    double val;
    ABCserver(int state){
        prevState=Operational;
        curState=state;
        observers = new ArrayList<Obsrver>();
        obDEF = new ArrayList<Obsrver>();
    }

    @Override
    public void register(Obsrver o) {
        int ind=-1;
        for(int i=0; i<observers.size(); i++) {
            ind=observers.indexOf(o);
        }
        if(ind>=0) {}
        else {
            observers.add(o);
        }
    }

    @Override
    public void regDEF(Obsrver o){
        int ind=-1;
        for(int i=0; i<obDEF.size(); i++) {
            ind=obDEF.indexOf(o);
        }
        if(ind>=0){}
        else {
            obDEF.add(o);
        }
    }

    @Override
    public void unregister(Obsrver o) {
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyall() {
        for(Obsrver obsrver:observers){
            obsrver.update();
        }
    }

    public void setState(int state){
        prevState=curState;
        curState=state;
        if(prevState!=curState){
            this.notifyall();
        }
    }

    @Override
    public String getPrevState(){
        String p;
        if(prevState==Operational)
            p="Operational";
        else if (prevState==PartiallyDown)
            p="PartiallyDown";
        else
            p="FullyDown";
        return p;
    }
    @Override
    public String getCurrState(){
        String c;
        if(curState==Operational)
            c="Operational";
        else if (curState==PartiallyDown)
            c="PartiallyDown";
        else
            c="FullyDown";

        return c;

    }

    public String getPremMsg(Obsrver obs){
        if(prevState==Operational && curState==PartiallyDown){
            msg="1.Want to use service from two servers(ABC,DEF (partially))?\n2.Want to use service from one server(DEF)?\n";
        } else if (prevState==Operational && curState==FullyDown) {
            msg="You will receive services from DEF server\n";
        } else if (prevState==PartiallyDown && curState==Operational) {
            if(obDEF.indexOf(obs)>=0)
                obDEF.remove(obs);
            msg="";
        } else if (prevState==PartiallyDown && curState==FullyDown) {
            msg="You will receive services from DEF server\n";
            int i=obDEF.indexOf(obs);
            if(i>=0){
                msg="Your services are shifts to the server of DEF\n";
            }
        } else if (prevState==FullyDown && curState==Operational) {
            if(obDEF.indexOf(obs)>=0)
                obDEF.remove(obs);
            msg="";
        } else if (prevState==FullyDown && curState==PartiallyDown) {
            msg="";
        }
        return msg;
    }

    public String getRegMsg(Obsrver obs){
        if(prevState==Operational && curState==PartiallyDown){
            msg="1.Want to enjoy the full functionality by paying $20 per hour and taking service from server of DEF ?\n2.Want to continue using the limited functionalities?\n";
        } else if (prevState==Operational && curState==FullyDown) {
            msg="1.Want to pay $20 per hour to take service from DEF company?\n";
        } else if (prevState==PartiallyDown && curState==Operational) {
            if(obDEF.indexOf(obs)>=0) {
                val = Math.random() * 250 + 250;
                val = Math.round(val * 100.0) / 100.0;
                msg = "Your bill from last session $" + val + "\n";
                obDEF.remove(obs);
            }
        } else if (prevState==PartiallyDown && curState==FullyDown) {
            msg="";
        } else if (prevState==FullyDown && curState==Operational) {
            if(obDEF.indexOf(obs)>=0) {
                val = Math.random() * 250 + 250;
                val = Math.round(val * 100.0) / 100.0;
                msg = "Your bill from last session $" + val + "\n";
                obDEF.remove(obs);
            }
        } else if (prevState==FullyDown && curState==PartiallyDown) {
            msg="";
        }
        return msg;
    }

}
