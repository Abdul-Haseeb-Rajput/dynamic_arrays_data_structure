public class App {
    public static void main(String[] args) throws Exception {
        DynamicArrays<Integer> arr = new DynamicArrays<>(5);
        arr.add(5);
        arr.add(1);
        arr.add(34);
        arr.add(1);
        arr.print();
        arr.add(9);
        arr.print();
        arr.add(12);
        arr.print();
        System.out.println(arr.get(2));
        arr.setAt(35, 2);
        arr.print();
        System.out.println(arr.get(2));

    }
}
