package Animals;

public class Cat extends Animal{
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("I am %s and my favourite food is %s", this.getName(), this.getFavouriteFood()));
        stringBuilder.append("\n");
        stringBuilder.append("MEEOW");
        return stringBuilder.toString();
    }
}
