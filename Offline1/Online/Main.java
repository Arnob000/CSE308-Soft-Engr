import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Director d=new Director();
        boolean flag=false,f2=true;
        Builder pcbuilder;
        Burger pc;

        int orderNo=0;
        int pcNo=0;

        while (true){
            pcNo=0;
            System.out.print("Do you want to place an order?\nIf yes then Press 'O'\nIf no then Press 'E'\nEnter: ");
            String st=br.readLine();

            if(st.equalsIgnoreCase("O")){
                List<Burger> pcList=new ArrayList<Burger>();
                orderNo++;
                pcNo=0;
                System.out.println("Order "+orderNo);
                System.out.println("-------------------");

                while (st.equalsIgnoreCase("O")){

                       pcbuilder = new burgerbuilder();
                        d.Build(pcbuilder);
                        flag=true;
                        f2=true;

                    if (flag==false && st.equalsIgnoreCase("E"))
                        System.out.println("You have to select at least one item");
                    else if (st.equalsIgnoreCase("E"))
                        break;
                    
                    else if(flag==false){
                        System.out.println("Enter correctly");
                    }
                    else {
                        f2 = false;
                        System.out.println("Enter correctly");
                    }

                    if(flag & f2==true) {
                        System.out.println("Do you want to add Patty ram?\n(a)Yes\n(b)No\nEnter (Yes/No) : ");
                        st = br.readLine();
                        while (st.equalsIgnoreCase("Yes")) {
                            d.addPatty();
                            System.out.println("Do you want to add another?\n(a)Yes\n(b)No\nEnter (Yes or No):");
                            st = br.readLine();
                        }

                        System.out.println("Do you want to add Cheese?\n(a)Yes\n(b)No\nEnter (Yes or No):");
                        st = br.readLine();
                        while (st.equalsIgnoreCase("Yes")) {
                            d.addCheese();
                            System.out.println("Do you want to add another?\n(a)Yes\n(b)No\n\nEnter (Yes or No):");
                            st = br.readLine();
                        }

                        System.out.println("Do you want to add BBQ sause?\n(a)Yes\n(b)No\nEnter (Yes or No):");
                        st = br.readLine();
                        while (st.equalsIgnoreCase("Yes")) {
                            d.addBBQ();
                            System.out.println("Do you want to add another?\n(a)Yes\n(b)No\n\nEnter (Yes or No):");
                            st = br.readLine();
                        }

                        System.out.println("Do you want to add salad?\n(a)Yes\n(b)No\nEnter (Yes or No):");
                        st = br.readLine();
                        while (st.equalsIgnoreCase("Yes")) {
                            d.addSalad();
                            System.out.println("Do you want to add another?\n(a)Yes\n(b)No\n\nEnter (Yes or No):");
                            st = br.readLine();
                        }

                        pcbuilder=d.getNewPC();
                        pc=pcbuilder.getBurger();
                        pcNo++;
                        System.out.println("\nBurger No "+pcNo);
                        pc.show();
                        pcList.add(pc);

                        System.out.println("Want to add another burger?\n");
                        System.out.println("If you want to exit press 'E'");
                        System.out.print("Enter: ");
                        st = br.readLine();
                        if(st.equalsIgnoreCase("E"))
                            break;
                    }

                }
                System.out.println("Order "+orderNo+" closed");
                System.out.println("-------------------------\n");
                System.out.println("Your Burgers(s)");
                System.out.println("-------------------------");
                Burger p=new Burger();
                float tPrice=0;
                int i=0;
                for(Object o: pcList){
                    i++;
                    System.out.println("PC no "+i);
                    p=(Burger) o;
                    p.show();
                    tPrice=tPrice+p.totalPrice();
                }

                System.out.println("Final Price: "+tPrice+" BDT");
                System.out.println("-------------------------\n\n");

            }
            else if(st.equalsIgnoreCase("E"))
                break;;
        }
    }
}
