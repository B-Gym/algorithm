package set;

public class IntSetTester {
    public static void main(String[] args) {
        IntSet s1 = new IntSet(20);
        IntSet s2 = new IntSet(20);
        IntSet s3 = new IntSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        s2.remove(25);

        s3.copyFrom(s2);

        // System.out.println(printSet("s1", s1));
        // System.out.println(printSet("s2", s2));
        // System.out.println(printSet("s3", s3));
        // System.out.println();

        System.out.println(printSet("s1", s1));
        System.out.println(printSet("s3", s3));
        s1.retain(s3);
        System.out.println(printSet("s1 ∩ s3", s1));

        System.out.println();
        System.out.println(printSet("s2", s2));
        System.out.println(printSet("s3", s3));
        s3.remove(s2);
        System.out.println(printSet("s3 - s2", s3));

        System.out.println();
        s1.add(7);
        System.out.println(printSet("s1", s1));
        System.out.println(printSet("s2", s2));
        s1.add(s2);
        System.out.println(printSet("s1 ∪ s2", s1));

        // 부분집합, 진부분집합 판별
        IntSet s4 = new IntSet(20);
        IntSet s5 = new IntSet(20);

        s4.add(1);
        s4.add(3);

        s5.add(1);
        s5.add(3);
        s5.add(5);

        System.out.println();
        System.out.println(printSet("s4", s4));
        System.out.println(printSet("s5", s5));
        System.out.println("s4 ⊂ s5 = " + s4.isSubset(s5));
        System.out.println("s5 ⊂ s4 = " + s5.isSubset(s4));
        System.out.println("s4 ⊊ s5 = " + s4.isProperSubsetOf(s5));
        System.out.println("s5 ⊊ s4 = " + s5.isProperSubsetOf(s4));

        System.out.println();
        IntSet differenceCopy = new IntSet(20);
        differenceCopy.differenceOf(s4, s5);
        System.out.println(printSet("s4 - s5", differenceCopy));

        System.out.println();
        IntSet intersectionCopy = new IntSet(20);
        intersectionCopy.intersectionOf(s4, s5);
        System.out.println(printSet("s4 ∩ s5", intersectionCopy));

    }

    static String printSet(String name, IntSet s) {
        return name + " = " + s;
    }
}
