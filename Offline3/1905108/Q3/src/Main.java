import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<CompanyComponent> softwareCompanies=new ArrayList<>();
        CompanyComponent s;
        Scanner scn=new Scanner(System.in);
        String str="";
        String prjt="";
        boolean flag=false;
        boolean com=false;
//Creating Company and other component
        while(true){
            System.out.println("A new Software Company?(Y?/N)");
            System.out.print("Enter: ");
            str=scn.nextLine();
            if(str.equalsIgnoreCase("Y")){
                System.out.print("Give Company's name: ");
                str=scn.nextLine();
                s=new SoftwareCompany(str);
                softwareCompanies.add(s);
                while (true){
                    System.out.println("\nOpen a project?(Y/N)");
                    System.out.print("Enter: ");
                    str=scn.nextLine();
                    if(str.equalsIgnoreCase("Y")){
                        System.out.print("Give Project's name: ");
                        prjt=scn.nextLine();
                        System.out.print("Give Project Manager's name: ");
                        str=scn.nextLine();
                        PersonComponent p=new ProjectManager(str,prjt);
                        flag=s.addProjectManager(p);
                        while (flag){
                            System.out.println("Add Developer?(Y/N)");
                            System.out.print("Enter: ");
                            str=scn.nextLine();
                            if(str.equalsIgnoreCase("Y")) {
                                boolean f=false;
                                System.out.print("Give Developer's name: ");
                                str = scn.nextLine();
                                PersonComponent d = new Developer(str, prjt);
                                f=s.addDeveloper(d, p);
                                System.out.println();
                                if(f)
                                    d.details();
                                System.out.println();
                            }
                            else break;
                        }
                        if(flag) {
                            System.out.println("\nDetails of Project Manager of Project " + prjt);
                            p.details();
                            System.out.println("\nHierarchy of project " + prjt);
                            p.hierarchy(0);
                        }
                    }
                    else break;
                }
                System.out.println("\nDetails of the company:");
                s.details();
                System.out.println();
                System.out.println("Hierarchy of the company:");
                s.hierarchy(0);
            }
            else break;
        }

        while(true){
            com=false;
            System.out.println("\nCompanies:");
            System.out.println("--------------------------");
            for(CompanyComponent softwareCompany:softwareCompanies){
                System.out.println(softwareCompany.getName());
            }
            System.out.println();

            System.out.println("See details of a company?(Y/N)");
            System.out.print("Enter: ");
            str = scn.nextLine();
            if (str.equalsIgnoreCase("Y")) {
                System.out.print("Give Company's name: ");
                str = scn.nextLine();
                for (CompanyComponent softwareCompany : softwareCompanies) {
                    if (softwareCompany.getName().equalsIgnoreCase(str)) {
                        softwareCompany.details();
                        com=true;
                    }
                }
                if(!com)
                    System.out.println("No such company!");
            }
            else break;
        }

        while(true){
            com=false;
            System.out.println("\nCompanies:");
            System.out.println("--------------------------");
            for(CompanyComponent softwareCompany:softwareCompanies){
                System.out.println(softwareCompany.getName());
            }
            System.out.println();

            System.out.println("See hierarchy of a company?(Y/N)");
            System.out.print("Enter: ");
            str = scn.nextLine();
            if (str.equalsIgnoreCase("Y")) {
                System.out.print("Give Company's name: ");
                str = scn.nextLine();
                for (CompanyComponent softwareCompany : softwareCompanies) {
                    if (softwareCompany.getName().equalsIgnoreCase(str)) {
                        softwareCompany.hierarchy(0);
                        com=true;
                    }
                }
                if(!com)
                    System.out.println("No such company!");
            }
            else break;
        }
//Removing Company
        while(true){
            com=false;
            System.out.println("\nCompanies:");
            System.out.println("--------------------------");
            for(CompanyComponent softwareCompany:softwareCompanies){
                System.out.println(softwareCompany.getName());
            }
            System.out.println();

            System.out.println("Remove a company?(Y/N)");
            str = scn.nextLine();
            if (str.equalsIgnoreCase("Y")) {
                System.out.print("Give Company's name: ");
                str = scn.nextLine();
                for (CompanyComponent softwareCompany : softwareCompanies) {
                    if (softwareCompany.getName().equalsIgnoreCase(str)) {
                        com=true;
                        System.out.println("Company "+str+" removed");
                        softwareCompany.removeAll();
                        softwareCompanies.remove(softwareCompany);
                        break;
                    }
                }
                if(!com)
                    System.out.println("No such company!");
            }
            else break;
        }
//Removing Project Manager
        while(true){
            com=false;
            System.out.println("\nCompanies:");
            System.out.println("--------------------------");
            for(CompanyComponent softwareCompany:softwareCompanies){
                System.out.println(softwareCompany.getName());
            }
            System.out.println();

            System.out.println("Remove a Project Manager?(Y/N)");
            str = scn.nextLine();
            if (str.equalsIgnoreCase("Y")) {
                System.out.print("Give Company's name: ");
                str = scn.nextLine();
                for (CompanyComponent softwareCompany : softwareCompanies) {
                    if (softwareCompany.getName().equalsIgnoreCase(str)) {
                        com=true;
                        System.out.println("Hierarchy:");
                        softwareCompany.hierarchy(0);
                        System.out.print("Give Project Manager's name: ");
                        prjt = scn.nextLine();
                        softwareCompany.removeProjectManager(prjt);
                        System.out.println("Hierarchy:");
                        softwareCompany.hierarchy(0);
                        break;
                    }
                }
                if(!com)
                    System.out.println("No such company!");
            }
            else break;
        }
//Removing Developer
        while(true){
            com=false;
            System.out.println("\nCompanies:");
            System.out.println("--------------------------");
            for(CompanyComponent softwareCompany:softwareCompanies){
                System.out.println(softwareCompany.getName());
            }
            System.out.println();

            System.out.println("Remove a Developer?(Y/N)");
            str = scn.nextLine();
            if (str.equalsIgnoreCase("Y")) {
                System.out.print("Give Company's name: ");
                str = scn.nextLine();
                for (CompanyComponent softwareCompany : softwareCompanies) {
                    if (softwareCompany.getName().equalsIgnoreCase(str)) {
                        com=true;
                        System.out.println("Hierarchy:");
                        softwareCompany.hierarchy(0);
                        System.out.print("Give Developer's name: ");
                        prjt = scn.nextLine();
                        softwareCompany.removeDeveloper(prjt);
                        System.out.println("Hierarchy:");
                        softwareCompany.hierarchy(0);
                        break;
                    }
                }
                if(!com)
                    System.out.println("No such company!");
            }
            else break;
        }

    }
}
