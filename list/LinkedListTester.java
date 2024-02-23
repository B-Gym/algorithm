package list;

import java.util.Comparator;

class Customer {
    public Integer no;
    public String name;

    Customer(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    Customer() {
    }

    public String toString() {
        return String.format("[ %d ] %s", no, name);
    }

    // no순으로 정렬
    public static final Comparator<Customer> NO_ORDER = new NoOrderComparator();

    private static class NoOrderComparator implements Comparator<Customer> {
        public int compare(Customer c1, Customer c2) {
            return (c1.no > c2.no) ? 1 : (c1.no < c2.no) ? -1 : 0;
        }
    }

    // name순으로 정렬
    public static final Comparator<Customer> NO_NAME = new NoNameComparator();

    private static class NoNameComparator implements Comparator<Customer> {
        public int compare(Customer c1, Customer c2) {
            return c1.name.compareTo(c2.name);
        }
    }
}

public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<Customer> list = new LinkedList<Customer>();

        Customer ptr;
        Customer data;

        // list.addFirst(new Customer(1, "kimgoat"));
        list.addLast(new Customer(1, "kimgoat"));
        list.addLast(new Customer(2, "kimgoat"));
        list.addLast(new Customer(3, "kimgoat"));
        list.addLast(new Customer(4, "kimgoat"));
        list.addLast(new Customer(5, "kimgoat"));
        list.addLast(new Customer(6, "kimgoat"));
        list.dump();

        System.out.println();
        list.removeFirst();
        list.dump();

        Customer temp = new Customer(3, "kimgoat");

        ptr = list.serach(temp, Customer.NO_ORDER);
        if (ptr == null)
            System.out.println("그 번호의 데이터 없음");
        else
            System.out.println("검색 성공: " + ptr);

        Customer temp2 = new Customer(3, "kimgoat");

        // ptr = list.serach(temp2, Customer.NO_NAME);
        ptr = list.serach(temp2, (o1, o2) -> {
            if (o1 instanceof Customer && o2 instanceof Customer) {
                Customer c1 = (Customer) o1;
                Customer c2 = (Customer) o2;
                return c1.name.compareTo(c2.name);
            }
            return -1;
        });
        if (ptr == null)
            System.out.println("그 이름의 데이터 없음");
        else
            System.out.println("검색 성공: " + ptr);

    }
}
