package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTest {

    private ArrayList<String> arrayList1;
    private ArrayList<String> arrayList2;
    private ArrayList<String> arrayList3;

    private HashMap<String, Integer> hashMap1;
    private HashMap<String, Integer> hashMap2;
    private HashMap<String, Integer> hashMap3;
    private HashMap<String, Integer> hashMap4;

    private TreeSet<String> treeSet1;
    private TreeSet<String> treeSet2;
    private TreeSet<String> treeSet3;
    private TreeSet<String> treeSet4;
    private SortedSet<String> sortedSet;

    @BeforeEach
    public void setUp() {
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>(5);
        arrayList3 = new ArrayList<>(Arrays.asList("1", "2", "3"));

        hashMap1 = new HashMap<>();
        hashMap1.put("1", 1);
        hashMap2 = new HashMap<>(5);
        hashMap3 = new HashMap<>(5, 0.5f);
        hashMap4 = new HashMap<>(hashMap1);

        treeSet1 = new TreeSet<>();
        treeSet2 = new TreeSet<>(String::compareTo);
        treeSet3 = new TreeSet<>(arrayList3);
        sortedSet = treeSet3;
        treeSet4 = new TreeSet<>(sortedSet);
    }

    @Test
    public void collectionTest() {
        arrayList1.addAll(arrayList3);
        arrayList1.add("4");
        System.out.println(arrayList1);
        Assertions.assertTrue(arrayList1.contains("2"));
        Assertions.assertFalse(arrayList1.contains("7"));
        Assertions.assertFalse(arrayList1.isEmpty());

        arrayList1.remove("2");
        System.out.println(arrayList1);
        Assertions.assertFalse(arrayList1.contains("2"));
        Assertions.assertTrue(arrayList1.containsAll(Arrays.asList("1", "3")));
        Assertions.assertEquals(3, arrayList1.size());

        arrayList1.removeAll(Arrays.asList("1", "3"));
        Assertions.assertFalse(arrayList1.containsAll(Arrays.asList("1", "3")));

        arrayList1.clear();
        Assertions.assertTrue(arrayList1.isEmpty());
    }

    @Test
    public void arrayListTest() {
        arrayList1.addAll(0, arrayList3);
        arrayList1.add(1, "4");
        arrayList1.add(arrayList1.size(), "5");

        System.out.println(arrayList1);

        Assertions.assertTrue(arrayList1.contains("4"));
        Assertions.assertEquals("5", arrayList1.get(4));
        Assertions.assertEquals(5, arrayList1.size());

        arrayList1.remove(1);
        System.out.println(arrayList1);
        Assertions.assertEquals("2", arrayList1.get(1));

        arrayList1.set(2, "7");
        System.out.println(arrayList1);
        Assertions.assertEquals("7", arrayList1.get(2));
        Assertions.assertEquals(3, arrayList1.indexOf("5"));
        Assertions.assertEquals(4, arrayList1.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> arrayList1.get(8));
    }

    @Test
    public void hashMapTest() {
        hashMap1.put("2", 2);
        hashMap4.putAll(hashMap1);
        System.out.println(hashMap1);
        System.out.println(hashMap4);

        hashMap1.clear();
        System.out.println(hashMap1);

        Assertions.assertFalse(hashMap4.isEmpty());
        Assertions.assertTrue(hashMap1.isEmpty());
        Assertions.assertTrue(hashMap4.containsKey("1"));
        Assertions.assertTrue(hashMap4.containsValue(2));
        Assertions.assertFalse(hashMap4.containsValue(5));

        hashMap4.put("3", 3);
        hashMap4.replace("1", 8);
        Assertions.assertEquals(8, hashMap4.get("1"));
        Assertions.assertEquals(3, hashMap4.size());
    }

    @Test
    public void treeSetTest() {
        treeSet1.add("a");
        treeSet1.add("b");
        treeSet1.add("c");
        treeSet1.add("d");

        Assertions.assertEquals("a", treeSet1.first());
        Assertions.assertTrue(treeSet1.contains("c"));
        Assertions.assertFalse(treeSet1.contains("ccc"));

        System.out.println(treeSet1.tailSet("c"));
        System.out.println(treeSet1.headSet("c"));
        Assertions.assertTrue(treeSet1.tailSet("c").contains("d"));
        Assertions.assertTrue(treeSet1.headSet("c").contains("a"));
        Assertions.assertEquals("d", treeSet1.last());

        treeSet1.remove("c");
        Assertions.assertFalse(treeSet1.contains("c"));
        Assertions.assertEquals(3, treeSet1.size());
    }
}
