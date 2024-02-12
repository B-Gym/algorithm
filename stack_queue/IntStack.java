package stack_queue;

public class IntStack {
    private int capacity;
    private int pointer;
    private int[] stk;

    IntStack(int capacity) {
        this.capacity = capacity;
        pointer = 0;

        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (pointer >= capacity)
            throw new OverflowIntStackException();
        return stk[pointer++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (pointer <= 0)
            throw new EmptyIntStackException();
        return stk[--pointer];
    }

    public int peek() throws EmptyIntStackException {
        if (pointer <= 0)
            throw new EmptyIntStackException();
        return stk[pointer - 1];
    }

    public int indexOf(int x) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    public void clear() {
        pointer = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return pointer;
    }

    public boolean isFull() {
        return pointer >= capacity;
    }

    public void dump() {
        if (pointer <= 0)
            System.out.println("Stack is Empty");
        else {
            for (int i = 0; i < pointer; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

    public class EmptyIntStackException extends RuntimeException {
        EmptyIntStackException() {
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        OverflowIntStackException() {
        }
    }

    public static void main(String[] args) {
        IntStack stk = new IntStack(10);
        stk.push(0);
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        stk.dump();
        System.out.println("stack size: " + stk.size());

        stk.pop();
        stk.pop();
        stk.pop();

        stk.dump();
        System.out.println("stack size: " + stk.size());

        stk.clear();

        stk.dump();
        System.out.println("stack size: " + stk.size());

        stk.push(5);
        stk.push(4);
        stk.push(3);

        stk.dump();
        System.out.println("stack size: " + stk.size());

    }
}