import java.util.ArrayList;
import java.util.List;

interface Mediator {
    public void send(Participant p, String msg,int mark,int ind);
    public void send(Participant p, List<Integer> a);
}


class ExamController implements Mediator{
    private List<Student> students;
    private Examiner examiner;
    private List<Integer> marks;

    ExamController(){
        students=new ArrayList<Student>();
        marks=new ArrayList<Integer>();
    }

    public void setExaminer(Examiner e){
        examiner=e;
    }
    public void setStudent(Student s){
        students.add(s);
    }

    public void send(Participant p, String msg,int mark, int ind){
        if(p instanceof Student && msg.equalsIgnoreCase("Re-examine request")){
            System.out.println("\nExam Controller");
            System.out.println(msg+" got from student id "+((students.indexOf(p))+1));
            examiner.notify(students.indexOf(p));
        }
        else if(p==examiner){
            System.out.println("\nExam Controller");
            System.out.println("(From Examiner) "+msg+" of student "+(ind+1));
            System.out.println();
            marks.set(ind,mark);
            students.get(ind).notify(msg);
        }

    }

    public void send(Participant p, List<Integer> a){
        if(p==examiner){
            //marks correction
            marksCorrection(a);
            for(int i=0; i<students.size();i++) {
                students.get(i).notify("Mark "+marks.get(i));
            }
        }
    }

    private void marksCorrection(List<Integer> a){
        int id=1;
        double val;
        double n;
        System.out.println("\nExam Controller");
        for(Integer i:a){
            System.out.println("Student id: "+id+" Marks: "+i);
            id++;
        }
        System.out.println();

        id=1;
        for(Integer i:a){
            val = Math.random() * 1;
            n=val;
            val = Math.round(val);
            if(val==1){
                n=n*7;
                n=Math.round(n);
                System.out.println("Student id: "+id+" Previous Mark: "+i+" Corrected Mark: "+(int)(i+n));
                marks.add((int)(i+n));
                id++;
            }
            else{
                marks.add(i);
                id++;
            }
        }
    }

}