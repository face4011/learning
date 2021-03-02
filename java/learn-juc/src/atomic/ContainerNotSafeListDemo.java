package atomic;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeListDemo {


    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(); // java.util.ConcurrentModificationException
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

    // java.util.ConcurrentModificationException

}
