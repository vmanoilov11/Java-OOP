package randomArrayList;


public class Main {
    public static void main(String[] args) {
        RandomArrayList myList = new RandomArrayList();
        myList.getRandomElement();
    }
}

package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList{
    public Object getRandomElement(){
        Random myIndex = new Random();
        int index = myIndex.nextInt(super.size());
        Object object = super.get(index);
        super.remove(object);
        return object;
    }
}
