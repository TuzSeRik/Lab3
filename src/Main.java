public class Main {
    public static void main(String[] args){
        Cloth cloth = new Cloth("Рубаха");
        Furnace furnace = new Furnace("Картошка", 100);
        Human human = new Human("Незнайка");
        LunarShorty[] shorties = new LunarShorty[10];

        shorties[0] = new LunarShorty("1");
        shorties[1] = new LunarShorty("2");
        shorties[2] = new LunarShorty("3");
        shorties[3] = new LunarShorty("4");
        shorties[4] = new LunarShorty("5");
        shorties[5] = new LunarShorty("6");
        shorties[6] = new LunarShorty("7");
        shorties[7] = new LunarShorty("8");
        shorties[8] = new LunarShorty("9");
        shorties[9] = new LunarShorty("10");


        shorties[0].Repair(cloth);
        for (LunarShorty shorty1 : shorties) {
            shorty1.Laugh();
        }

        for (LunarShorty shorty1 : shorties) {
            shorty1.Buzz(shorties);
        }

        for (int i = ((Food) furnace.getFood()).getQuantity(); i>0; i-- ){
            shorties[i%10].TryToEat(furnace);
        }
        shorties[1].Fight(shorties[4], shorties[7], shorties[8]);
        human.TryToEat(furnace);
    }
}
//+