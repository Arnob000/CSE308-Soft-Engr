import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int Operational=0;
    private static final int PartiallyDown=1;
    private static final int FullyDown=2;

    public static void main(String[] args) throws IOException {
        ABCserver abc =new ABCserver(Operational);
        premiumUser a =new premiumUser(abc);
        regularUser b=new regularUser(abc);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st;
        int state;
        while(true){
            System.out.println("\nABC Server");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("0. Operational");
            System.out.println("1. Partially Down");
            System.out.println("2. Fully Down");
            System.out.println("3. Exit");
            System.out.print("Enter state : ");
            st=br.readLine();
            System.out.println("---------------------------------------------------------------------------");
            state=Integer.parseInt(st);
            if(state>=0 && state<=2)
                abc.setState(state);
            else
                break;
        }
    }
}
