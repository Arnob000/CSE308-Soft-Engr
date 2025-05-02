import java.util.ArrayList;
import java.util.List;

abstract class Participant {
    protected Mediator mediator;
    protected String name;

    Participant(Mediator m){
        mediator=m;
    }
}

class Examiner extends Participant{
    List<Integer> marks;
    Examiner(Mediator m, String name){
        super(m);
        this.name=name;
        marks=new ArrayList<Integer>();
    }

    public void send(List<Integer> a){
        marks=a;
        System.out.println("\nExaminer");
        System.out.println("Scripts and marks of student id 1,2,3,4,5 sent to exam controller office");
        mediator.send(this, marks);
    }

    public void notify(int ind){
        System.out.println("\nExaminer");
        System.out.println("Re-examine request got from Exam Controller for student id "+(ind+1));
        reExamine(ind);
    }

    public void reExamine(int ind){
        double val,n;
        System.out.println("...\nUpdated mark sent to Exam Controller for student id "+(ind+1));
        val = Math.random() * 2;
        n=val;
        val = Math.round(val);
        if(val==0){
            mediator.send(this, "Mark "+marks.get(ind)+" (Mark unchanged)",marks.get(ind), ind);
        } else if (val==1) {
            n=n*2;
            n=Math.round(n);
            mediator.send(this, "Mark "+(marks.get(ind)+(int)n)+" (Mark increased)",(marks.get(ind)+(int)n), ind);
            marks.set(ind,(marks.get(ind)+(int)n));
        } else if (val==2) {
            n=n*2;
            n=Math.round(n);
            mediator.send(this, "Mark "+(marks.get(ind)-(int)n)+" (Mark decreased)",(marks.get(ind)-(int)n), ind);
            marks.set(ind,(marks.get(ind)-(int)n));
        }
    }
}

class Student extends Participant{
    String mark;
    Student(Mediator m, String name){
        super(m);
        this.name=name;
    }

    public void notify(String msg){
        this.mark=msg;
    }
    public void printMark(){
        System.out.println("Student "+name+": "+mark);
    }

    public String getName(){
        return name;
    }

    public void reExamine(){
        System.out.println("\nStudents\nRe-examine request sent from student id "+name);
        mediator.send(this,"Re-examine request",0,Integer.parseInt(name));
    }

}