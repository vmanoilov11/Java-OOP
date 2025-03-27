package Animals;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("I am %s and my favourite food is %s", this.getName(), this.getFavouriteFood()));
        stringBuilder.append("\n");
        stringBuilder.append("DJAAF");
        return stringBuilder.toString();
    }
}
