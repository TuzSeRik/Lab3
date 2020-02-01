import java.util.Objects;

public class LunarShorty extends Person {


    private int power;


    public LunarShorty() {
    }

    LunarShorty(String name) {
        super(name);
    }

    public LunarShorty(String name, Status status) {
        super(name, status);
    }


    private int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }


    private LunarShorty checkPower(LunarShorty[] shorties) {
        int maxPower = 0;
        LunarShorty laughiest = null;

        for (LunarShorty shorty : shorties) {
            if (shorty.getPower() > maxPower) {
                maxPower = shorty.getPower();
                laughiest = shorty;
            }
        }
        return laughiest;
    }

    void Buzz(LunarShorty[] shorties) {
        if (!checkPower(shorties).getName().equals(this.getName())) {
            this.setStatus(Status.BUZZING);
            System.out.println(this.getName() + " одобрительно загудел в сторону " + checkPower(shorties).getName());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LunarShorty)) return false;
        if (!super.equals(o)) return false;
        LunarShorty that = (LunarShorty) o;
        return getPower() == that.getPower();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPower());
    }

    @Override
    public String toString() {
        return "LunarShorty{" +
                "power=" + power +
                '}';
    }


    @Override
    public void Fight(Person... persons) {
        int l;
        StringBuilder end = new StringBuilder();

        this.setStatus(Status.FIGHTING);
        l = persons.length;
        for (int i = 0; i < l; i++) {
            persons[i].setStatus(Status.FIGHTING);
            end.append(persons[i].getName()).append(" ");
        }
        System.out.println(this.getName() + " начал драку с " + end);
    }

    @Override
    public void Laugh() {
        this.setPower((int) Math.round(Math.random() * 100));
        if (getStatus() == Status.REPAIRING) {
            setPower(100);
        }
        this.setStatus(Status.LAUGHING);
        System.out.println(getName() + " засмеялся с силой " + getPower());
    }

    @Override
    public void Repair(Object object) {
        if ((object instanceof Repairable)&(((Cloth)object).isBroken())) {
            this.setStatus(Status.REPAIRING);
            ((Cloth) object).Repair();
            System.out.println(this.getName() + " ремонтировал " + ((Cloth) object).getName());
        } else {
            System.out.println(this.getName() + " не мог отремонтировать " + object.toString());
        }
    }

    @Override
    public void TryToEat(Furnace furnace){
        if(furnace.getFood() instanceof Eatable){
            if(((Food) furnace.getFood()).getQuantity()<=0){
                System.out.println(((Food) furnace.getFood()).getName()+" закончилась.");
            }
            else {
                ((Food) furnace.getFood()).changeQuantity();
                System.out.println(this.getName()+" выхватил себе "+((Food) furnace.getFood()).getName());
            }
        }
        else{
            System.out.println("Да не стал никто это есть. Оно же несъедоно!");
        }
    }
}
//+