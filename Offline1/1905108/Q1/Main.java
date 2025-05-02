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
        PCBuilder pcbuilder;
        PC pc;
        String st;
        int orderNo=0;
        int pcNo=0;

        while (true){
            pcNo=0;
            System.out.print("Do you want to place an order?\nIf yes then Press 'O'\nIf no then Press 'E'\nEnter: ");
            String order=br.readLine();

            if(order.equalsIgnoreCase("O")){
                List<PC> pcList=new ArrayList<PC>();
                orderNo++;
                pcNo=0;
                System.out.println("Order "+orderNo);
                System.out.println("-------------------");
                System.out.println("Which type of pc you want to buy?\n(a)pc1\n(b)pc2\n(c)pc3\n(d)Gaming\n\nEnter name: ");

                while (true){
                    st = br.readLine();

                    if(st.equalsIgnoreCase("pc1")) {
                        pcbuilder = new pc1builder();
                        d.Build(pcbuilder);
                        flag=true;
                        f2=true;
                    } else if (st.equalsIgnoreCase("pc2")) {
                        pcbuilder = new pc2builder();
                        d.Build(pcbuilder);
                        flag=true;
                        f2=true;
                    }
                    else if (st.equalsIgnoreCase("pc3")) {
                        pcbuilder = new pc3builder();
                        d.Build(pcbuilder);
                        flag=true;
                        f2=true;
                    }
                    else if (st.equalsIgnoreCase("gaming")) {
                        pcbuilder = new pc4builder();
                        d.Build(pcbuilder);
                        flag=true;
                        f2=true;
                    }
                    else if (flag==false && st.equalsIgnoreCase("E"))
                        System.out.println("You have to select at least one item");
                    else if (st.equalsIgnoreCase("E"))
                        break;
                    else if(st.equalsIgnoreCase("O"))
                        System.out.println("An order is currently open");
                    else if(flag==false){
                        System.out.println("Enter correctly");
                    }
                    else {
                        f2 = false;
                        System.out.println("Enter correctly");
                    }

                    if(flag & f2==true) {
                        System.out.println("Do you want to add 8 GB DDR4 ram?\n(a)Yes\n(b)No\nEnter (Yes/No) : ");
                        st = br.readLine();
                        while (st.equalsIgnoreCase("Yes")) {
                            System.out.println("Which type?\n(a)2666 MHz\n(b)3200 MHz\nEnter (a or b):");
                            st = br.readLine();
                            if (st.equalsIgnoreCase("a"))
                                d.addRam("v1");
                            else if (st.equalsIgnoreCase("b")) {
                                d.addRam("v2");
                            } else if (st.equalsIgnoreCase("No")) {
                                break;
                            }
                            System.out.println("Do you want to add another?\n(a)Yes\n(b)No\nEnter (Yes or No):");
                            st = br.readLine();
                        }

                        System.out.println("Do you want to add Graphics Card?\n(a)Yes\n(b)No\nEnter (Yes or No):");
                        st = br.readLine();
                        while (st.equalsIgnoreCase("Yes")) {
                            System.out.println("Which type?\n(a)2 GB\n(b)4 GB\nEnter (a or b):");
                            st = br.readLine();
                            if (st.equalsIgnoreCase("a"))
                                d.addGCard("v1");
                            else if (st.equalsIgnoreCase("b")) {
                                d.addGCard("v2");
                            } else if (st.equalsIgnoreCase("No")) {
                                break;
                            }
                            System.out.println("Do you want to add another?\n(a)Yes\n(b)No\n\nEnter (Yes or No):");
                            st = br.readLine();
                        }

                        pcbuilder=d.getNewPC();
                        pc=pcbuilder.getPC();
                        pcNo++;
                        System.out.println("\nPC No "+pcNo);
                        pc.show();
                        pcList.add(pc);

                        System.out.println("Want to add another pc?\n(a)pc1\n(b)pc2\n(c)pc3\n(d)Gaming\n");
                        System.out.println("If you want to exit press 'E'");
                        System.out.print("Enter: ");
                    }

                }
                System.out.println("Order "+orderNo+" closed");
                System.out.println("-------------------------\n");
                System.out.println("Your PC(s)");
                System.out.println("-------------------------");
                PC p=new PC();
                float tPrice=0;
                int i=0;
                for(Object o: pcList){
                    i++;
                    System.out.println("PC no "+i);
                    p=(PC)o;
                    p.show();
                    tPrice=tPrice+p.totalPrice();
                }

                System.out.println("Final Price: "+tPrice+" BDT");
                System.out.println("-------------------------\n\n");

            }
            else if(order.equalsIgnoreCase("E"))
                break;;
        }
    }
}
