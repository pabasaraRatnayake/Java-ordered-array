public class OrdDemo {
    public static void main(String[] args) {
        OrdArray x = new OrdArray(10);
        x.insert(4);
        x.insert(9);
        x.insert(10);
        x.insert(1);
        x.insert(24);
        x.insert(8);
        x.display();
        x.delete(10);
        x.display();
    }
}

class OrdArray {
    private long[] a; // ref to array a
    private int nElements; //number of data items

    public OrdArray(int max) {
        this.a = new long[max];
        this.nElements = 0;
    }

    public int size() { // return max size of the array
        return this.a.length;
    }

    public int find(long searchKey) {
        for (int i = 0; i < nElements - 1; i++) {
            if (searchKey == a[i]) {
                return i;
            }
        }
        return -1;
    }

    public void insert(long value) { // put element into arrray
        if (nElements == size()) {
            System.out.println("Array is full. Insertion terminated");
            return;
        }

        for (int i = 0; i < this.nElements - 1; i++) {
            if (this.a[i] > value) {
                for (int j = this.nElements; j >= i; j--) {
                    this.a[j + 1] = this.a[j];
                }
                this.a[i]=value;
                this.nElements++;
                return;
            }
        }
        a[nElements]=value;
        nElements++;
    }

    public boolean delete(long value) {
        int index = find(value);
        if (index == -1) {
            System.out.println("Value is not in the array");
            return false;
        }
        for (int i = index; i < nElements-1; i++) {
            a[i] = a[i + 1];
        }
        nElements--;
        return true;
    }

    void display() { // display array contents
        for (int i = 0; i < nElements; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
