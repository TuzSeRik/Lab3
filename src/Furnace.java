import java.util.Objects;

public class Furnace {
    private Object food;

    Furnace(String name, int quantity){
        food = new Food(name,quantity);
    }


    Object getFood() {
        return food;
    }

    public void setFood(Object food) {
        this.food = food;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Furnace)) return false;
        Furnace furnace = (Furnace) o;
        return getFood().equals(furnace.getFood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFood());
    }

    @Override
    public String toString() {
        return "Furnace{" +
                "food=" + food +
                '}';
    }
}
//+