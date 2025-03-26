public class Robot implements Identifiable{
    private String model;
    private String id;


    public Robot(String id, String model){
        this.model = model;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
