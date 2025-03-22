import java.util.ArrayList;
import java.util.Collections;

public class Stack {
    private ArrayList<String> data;

    public Stack(ArrayList<String> data){
        this.data = new ArrayList<>();
    }
    public void push(String item){
        this.data.add(item);
    }
    public String pop(){
        return this.data.remove(data.size() - 1);
    }
    public String peek(){
        return this.data.get(data.size() - 1);
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
