import java.util.ArrayList;
import java.util.List;

public class Burger {
    private List<item> items;

    public  Burger(){
        items=new ArrayList<item>();
    }

    public void addItem(item i){
        items.add(i);
    }

    public float totalPrice(){
        float totPrice=0;

        for(item i: items){
            totPrice=totPrice+i.price();
        }
        return totPrice;
    }

    public void show(){
        System.out.println("-------------------------");
        for(item i: items){
            System.out.print(i.name()+" "+i.price()+" BDT\n");
        }
        System.out.println("-------------------------");
        System.out.print("Total price: "+totalPrice()+" BDT\n");
        System.out.println("-------------------------");
        System.out.println();
    }
}
