

public class BinaryHeap {

    private int[] data;
    private int maxsize = 10;
    private int size;

    public BinaryHeap() {
        data = new int[maxsize];
        size = 0;
    }

    public void add(int item){
        if(size >= data.length)
            grow_array();
        data[size++] = item;
        int current = size - 1;
        int parent = (current-1)/2;

        while(data[current] < data[parent] && current != 0)
        {
            swap(data, current, parent);
            current = parent;
            parent = (parent-1)/2;
        }
    }

    public int remove(){
        swap(data,0,size-1);
        --size;
        if(size > 0)
            shiftdown(0);
        return data[size];
    }

    public void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    private void shiftdown(int num){
        int smallest;
        while(hasLeftChild(num)) {
            smallest = left(num);
            if(hasRightChild(num) && right(num) < left(num))
                smallest = right(num);
            if(data[num] <= data[smallest]) {
                return;
            } else {
                swap(data, num, smallest);
            }
            num = smallest;
        }
    }

    private int right(int pos) {
        return 2 * pos + 2;
    }

    private int left(int pos) {
        return 2 * pos + 1;
    }

    private boolean hasLeftChild(int pos) {
        return left(pos) < size;
    }

    private boolean hasRightChild(int pos) {
        return right(pos) < size;
    }

    private void grow_array() {
        int[] temp = new int[data.length*2];
        for(int i = 0; i < data.length;i++)
            temp[i] = data[i]; // System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }


}
