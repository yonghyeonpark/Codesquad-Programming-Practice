import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Heap heap = new Heap();
        heap.init(64);
        heap.setSize("short", 4);
        heap.setSize("int", 8);
        heap.setSize("String", 16);

        int pointer1 = heap.malloc("short", 3);
        int pointer2 = heap.malloc("int", 2);
        int pointer3 = heap.malloc("String", 1);
        System.out.println(pointer1);
        System.out.println(pointer2);
        System.out.println(pointer3);
        System.out.println();

        System.out.println(Arrays.toString(heap.usage()));
        System.out.println(Arrays.toString(heap.heapDump()));
        System.out.println();

        heap.free(pointer1);
        System.out.println(Arrays.toString(heap.usage()));
        System.out.println(Arrays.toString(heap.heapDump()));
        System.out.println();

        heap.malloc("short", 1);
        System.out.println(Arrays.toString(heap.usage()));
        System.out.println(Arrays.toString(heap.heapDump()));
    }
}
