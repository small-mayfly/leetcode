package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    public ReentrantLock lock;
    public Condition firstC, secondC;
    public int flag;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.firstC = lock.newCondition();
        this.secondC = lock.newCondition();
        flag = 0;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag!=0){
                    firstC.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag++;
                secondC.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag!=1){
                    secondC.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag--;
                firstC.signal();
            }finally {
                lock.unlock();
            }

        }
    }
}


public class ID1115 {
}
