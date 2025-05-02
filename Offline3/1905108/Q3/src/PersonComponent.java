import java.util.ArrayList;
import java.util.List;

abstract class PersonComponent extends CompanyComponent {
    public void details(){
        System.out.println("\nName: "+name);
        System.out.println("Role: "+role);
        System.out.println("Current Project: "+currProject);
    }

}

class ProjectManager extends PersonComponent{
    List<PersonComponent> developers;

    ProjectManager(String name, String prjt){
        this.name=name;
        this.role="Project Manager";
        this.currProject=prjt;
        this.numOfProject=1;
        developers=new ArrayList<>();
    }

    public int getNumOfDeveloper(){
        return developers.size();
    }

    public boolean addDeveloper(PersonComponent p, PersonComponent pp){
        boolean flag=true;
        PersonComponent a=new Developer("","");
        for (PersonComponent developer : developers) {
            if (p.getName().equalsIgnoreCase(developer.getName())) {
                a = developer;
                flag = false;
            }
        }
        if(flag) {
            developers.add(p);
            return true;
        }
        else {
            System.out.println(p.getName() + " is already in project " + a.getCurrProject());
            return false;
        }
    }

    public void removeDeveloper(String p){
        for(int i=0; i<developers.size(); i++) {
            if (p.equalsIgnoreCase(developers.get(i).getName())) {
                System.out.println(developers.get(i).getName()+" removed");
                developers.remove(developers.get(i));
            }
        }
    }

    public void removeAll(){
        for(int i=0; i<developers.size(); i++){
            System.out.println(developers.get(i).getName()+" removed");
            developers.remove(developers.get(i));
            i--;
        }
    }

    public boolean hasDeveloper(String p){
        for (PersonComponent developer : developers) {
            if (p.equalsIgnoreCase(developer.getName()))
                return true;
        }
        return false;
    }

    public void details(){
        super.details();
        System.out.println("Number of Devloper(s) : "+getNumOfDeveloper());
    }

    public void hierarchy(int ofset){
        for(int i=0; i<ofset; i++){
            System.out.print("\t");
        }
        System.out.println("- "+name+" ("+getCurrProject()+")");
        for (PersonComponent developer : developers)
            developer.hierarchy(ofset + 1);
    }

}

class Developer extends PersonComponent{
    Developer(String name, String prjt){
        this.name=name;
        this.role="Developer";
        this.currProject=prjt;
        this.numOfProject=1;
    }
}
