abstract class item {
    protected String name;
    protected float price;
    public String name(){
        return name;
    }
    public float price(){
        return price;
    }
}

class Bun extends item{
    Bun(){
        name="Bun";
        price=20;
    }
}
abstract class Extra extends item{
    Extra(){
        name="Extra";
        price=0;
    }
}

class Patty extends Extra{
    Patty(){
        name="Patty";
        price=80;
    }
}

class Cheese extends Extra{
    Cheese(){
        name="Cheese";
        price=30;
    }
}

class BBQ extends Extra{
    BBQ(){
        name="BBQ sauce";
        price=20;
    }
}

class Salad extends Extra{

    Salad(){
        name="salad";
        price=10;
    }
}
