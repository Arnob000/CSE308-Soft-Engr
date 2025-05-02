import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm =new VendingMachine(2);
        Scanner scn=new Scanner(System.in);
        int amount=0;

        while(true){
                System.out.print("\nEnter Amount: ");
                amount = Integer.parseInt(scn.nextLine());

                if(amount>0)
                    vm.insertMoney(amount);

                vm.returnExtraMoney();
                System.out.print("\nWant to cancel purchase?\n1.Yes\n2.No\nEnter: ");
                if (Integer.parseInt(scn.nextLine()) == 1) {
                    vm.returnMoney();
                }
                vm.dropProduct();


                if(vm.getOutOfProductState()==vm.getState()){
                    System.out.print("Enter quantity: ");
                    amount=Integer.parseInt(scn.nextLine());
                    vm.refill(amount);
                }

//            System.out.print("Quit?\n1.Yes\n2.No\nEnter: ");
//            if(Integer.parseInt(scn.nextLine())==1)
//                break;
        }
    }
}
