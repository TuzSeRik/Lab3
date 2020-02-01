import java.util.Objects;

public class Food implements Eatable {
    private String name;
    private int quantity;
    private Dump causedDump;


    Food(String name, int quantity){
        setName(name);
        setQuantity(quantity);
        causedDump = new Dump();
    }


    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getQuantity() {
        return quantity;
    }

    void changeQuantity() {
        quantity--;
        incDump();
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public void makeDump(){
        causedDump = new Dump();
    }

    @Override
    public void incDump(){
        causedDump.changeSize();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return getQuantity() == food.getQuantity() &&
                getName().equals(food.getName()) &&
                causedDump.equals(food.causedDump);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), causedDump);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", causedDump=" + causedDump +
                '}';
    }
}
//+