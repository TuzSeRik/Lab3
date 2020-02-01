class Human extends Person {


    Human(String name){
        super(name);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    void Fight(Person... persons){
        throw new Error("Незнайка не может драться!");
    }

    @Override
    void Laugh(){
        throw new Error("Незнайка не может смеяться!");
    }

    @Override
    void Repair(Object object){
        throw  new Error("Незнайка не может ничего ремонтировать!");
    }

    @Override
    void TryToEat(Furnace furnace){
        if(furnace.getFood() instanceof Eatable){
            if(((Food) furnace.getFood()).getQuantity()>0){
                System.out.println(this.getName()+" не мог добраться до еды печке.");
            }
            else{
                System.out.println(this.getName()+" только потянулся к печке, а там уже ничего не было.");
            }
        }
        else{
            System.out.println("Это нельзя есть.");
        }
    }
}
//+