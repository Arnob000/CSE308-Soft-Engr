import java.util.ArrayList;
import java.util.List;

abstract class CompanyComponent{
    protected String name;
    protected String role;
    protected String currProject;
    protected int numOfProject;
    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }
    public String getCurrProject(){
        return currProject;
    }
    public int getNumOfDeveloper(){
        return 0;
    }
    public boolean hasDeveloper(String p){
        return false;
    }
    public int getNumOfProject(){
        return numOfProject;
    }

    public boolean addProjectManager(CompanyComponent p){return false;}
    public void removeProjectManager(String p){}
    public boolean addDeveloper(PersonComponent d, PersonComponent p){return false;}
    public void removeDeveloper(String name){}
    public void removeAll(){}
    public abstract void details();
    public void hierarchy(int ofset){
        for(int i=0; i<ofset; i++){
            System.out.print("\t");
        }
        System.out.println("- "+name);
    }
}

class SoftwareCompany extends CompanyComponent {
    private final List<CompanyComponent> projectManagers;

    SoftwareCompany(String name){
        this.name=name;
        this.role="Software Company";
        this.currProject="";
        this.numOfProject=0;
        projectManagers=new ArrayList<>();
    }

    public int getNumOfProject(){
        return projectManagers.size();
    }

    public int getNumOfDeveloper(){
        int n=0;
        for(int i=0; i<projectManagers.size(); i++){
            n+=projectManagers.get(i).getNumOfDeveloper();
        }
        return n;
    }

    public boolean addProjectManager(CompanyComponent p){
        boolean flag=true;
        currProject=p.getCurrProject();
        CompanyComponent a=new ProjectManager("","");
        for (CompanyComponent projectManager : projectManagers) {
            if (p.getName().equalsIgnoreCase(projectManager.getName())) {
                a = projectManager;
                flag = false;
            }
        }
        if(flag) {
            projectManagers.add(p);
            return true;
        }
        else {
            System.out.println(p.getName() + " is already in project " + a.getCurrProject());
            return false;
        }
    }

    public void removeProjectManager(String p){
        boolean flag=false;
        for(int i=0; i<projectManagers.size(); i++) {
            if (projectManagers.get(i).getName().equalsIgnoreCase(p)) {
                flag = true;
                projectManagers.get(i).removeAll();
                System.out.println(projectManagers.get(i).getName() + " removed");
                projectManagers.remove(projectManagers.get(i));
            }
        }
        if(!flag)
            System.out.println("No such Project Manager!");
    }

    public boolean addDeveloper(PersonComponent d, PersonComponent p){
        boolean flag=true;
        CompanyComponent a=new ProjectManager("","");
        for (CompanyComponent projectManager : projectManagers) {
            if (projectManager.hasDeveloper(d.getName())) {
                a = projectManager;
                flag = false;
            }
        }
        if(flag){
            p.addDeveloper(d,p);
            return true;
        }
        else {
            System.out.println(d.getName() + " is already in project " + a.getCurrProject());
            return false;
        }

    }

    public void removeDeveloper(String name){
        boolean flag=false;
        for (CompanyComponent projectManager : projectManagers) {
            if (projectManager.hasDeveloper(name)) {
                flag = true;
                projectManager.removeDeveloper(name);
            }
        }
        if(!flag)
            System.out.println("No such Developer!");
    }

    public void removeAll(){
        for(int i=0; i<projectManagers.size(); i++){
            projectManagers.get(i).removeAll();
            System.out.println(projectManagers.get(i).getName()+" removed");
            projectManagers.remove(projectManagers.get(i));
            i--;
        }
    }

    @Override
    public boolean hasDeveloper(String p) {
        for(CompanyComponent projectManager: projectManagers){
            if(projectManager.hasDeveloper(p))
                return true;
        }
        return false;
    }

    public void details(){
        System.out.println("\nName: "+name);
        System.out.println(getRole());
        System.out.println("Number of Project(s): "+getNumOfProject());
        System.out.println("Number of Project Manager(s) : "+getNumOfProject());
        System.out.println("Number of Devloper(s) : "+getNumOfDeveloper());
        System.out.println();
    }
    public void hierarchy(int ofset){
        super.hierarchy(ofset);
        for (CompanyComponent projectManager : projectManagers) {
            projectManager.hierarchy(ofset+1);
        }
    }

}
