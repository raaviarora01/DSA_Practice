package Set;

import java.util.TreeSet;

public class TreeSetImplementation {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(40);
        set.add(10);
        set.add(50);
        set.add(20);
        set.add(30);

        // sorted set
        System.out.println(set);

        // smallest
        System.out.println(set.first());

        // largest
        System.out.println(set.last());

        // lower than 30
        System.out.println(set.lower(30));

        // higher than 30
        System.out.println(set.higher(30));

        // floor of 25
        System.out.println(set.floor(25));

        // ceiling of 25
        System.out.println(set.ceiling(25));
    }
}
