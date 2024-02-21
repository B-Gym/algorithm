package set;

public class IntSet {
    private int max;
    private int num;
    private int[] set;

    public IntSet(int capacity) {
        num = 0;
        max = capacity;

        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int indexOf(int n) {
        for (int i = 0; i < num; i++) {
            if (set[i] == n)
                return i;
        }
        return -1;
    }

    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public boolean add(int n) {
        if (num >= max || contains(n) == true) {
            return false;
        } else {
            set[num++] = n;
            return true;
        }
    }

    public boolean remove(int n) {
        int idx;
        if (num <= 0 || (idx = indexOf(n)) == -1) {
            return false;
        } else {
            set[idx] = set[--num];
            return true;
        }
    }

    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num;
        for (int i = 0; i < n; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num;
        for (int i = 0; i < n; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    public boolean equalTo(IntSet s) {
        if (num != s.num)
            return false;

        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++)
                if (set[i] == s.set[j])
                    break;
            if (j == s.num)
                return false;
        }
        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("{ ");
        for (int i = 0; i < num; i++) {
            sb.append(set[i] + " ");
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean isEmpty() {
        return (num == 0) ? true : false;
    }

    public boolean isFull() {
        return (num == max) ? true : false;
    }

    public void clear() {
        num = 0;
    }

    // 집합 s와의 합집합
    public boolean add(IntSet s) {
        int n = num;
        for (int i = 0; i < s.num; i++) {
            this.add(s.set[i]);
        }
        return (num != n) ? true : false;
    }

    // 집합 s와의 교집합
    public boolean retain(IntSet s) {
        int n = 0;
        int[] temp = new int[num];
        for (int i = 0; i < num; i++)
            for (int j = 0; j < s.num; j++)
                if (set[i] == s.set[j]) {
                    temp[n++] = set[i];
                }

        num = 0;
        for (int i = 0; i < n; i++) {
            set[num++] = temp[i];
        }

        return num != 0 ? true : false;
    }

    // 집합 s와의 차집합
    public boolean remove(IntSet s) {
        int n = num;
        IntSet temp = new IntSet(num);

        temp.copyFrom(this);
        temp.retain(s);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < temp.num; j++) {
                if (set[i] == temp.set[j]) {
                    this.remove(set[i]);
                }
            }
        }

        return (n != num) ? true : false;
    }

    // 집합 s의 부분집합인지 확인
    public boolean isSubset(IntSet s) {
        IntSet temp = new IntSet(num);
        temp.copyFrom(this);
        temp.retain(s);
        return (temp.num == num) ? true : false;
    }

    // 집합 s의 진부분집합인지 확인
    public boolean isProperSubsetOf(IntSet s) {
        return (isSubset(s)) ? ((num != s.num) ? true : false) : false;
    }

    public void intersectionOf(IntSet s1, IntSet s2) {
        IntSet temp = new IntSet(s1.num);
        temp.copyFrom(s1);
        temp.retain(s2);
        this.copyFrom(temp);
    }

    public void differenceOf(IntSet s1, IntSet s2) {
        IntSet temp = new IntSet(s1.num);
        temp.copyFrom(s1);
        temp.remove(s2);
        this.copyFrom(temp);

    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }
}
