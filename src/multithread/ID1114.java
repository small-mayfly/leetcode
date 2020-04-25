package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用三个condition实现
 * 使用flag标识当前哪个线程应该执行，如果不应该执行则等待
 */
class Foo {

    public ReentrantLock lock;
    public Condition firstC, secondC, thridC;
    public int flag;

    public Foo() {
        this.lock = new ReentrantLock();
        this.firstC = lock.newCondition();
        this.secondC = lock.newCondition();
        this.thridC = lock.newCondition();
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=1){
                firstC.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            secondC.signal();
        }finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=2){
                secondC.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            thridC.signal();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=3){
                thridC.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            firstC.signal();
        }finally {
            lock.unlock();
        }
    }
}

public class ID1114 {

}
