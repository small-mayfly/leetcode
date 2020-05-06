package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ID1116 {
    private int n;
    private int nowNum;
    private Lock lock;
    private boolean flag;
    Condition zeroLock;
    Condition evenLock;
    Condition oddLock;

    public ID1116(int n) {
        this.n = n;
        this.nowNum = 1;
        lock = new ReentrantLock();
        zeroLock = lock.newCondition();
        evenLock = lock.newCondition();
        oddLock = lock.newCondition();
        flag = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            Integer integer = new Integer(0);
            while (nowNum<=n){
                printNumber.accept(integer);
                flag = false;
                if(nowNum%2==1){
                    oddLock.signalAll();
                }else{
                    evenLock.signalAll();
                }
                zeroLock.await();
            }
            oddLock.signalAll();
            evenLock.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (nowNum<=n){
                if(flag){
                    evenLock.await();
                    continue;
                }
                printNumber.accept(nowNum++);
                flag = true;
                zeroLock.signalAll();
                evenLock.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (nowNum<=n){
                if(flag){
                    oddLock.await();
                    continue;
                }
                printNumber.accept(nowNum++);
                flag = true;
                zeroLock.signalAll();
                oddLock.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        ID1116 id1116 = new ID1116(5);
        Runnable zero = new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = new IntConsumer();
                try {
                    id1116.zero(intConsumer);
                } catch (InterruptedException e) {

                }
            }
        };
        Runnable even = new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = new IntConsumer();
                try {
                    id1116.even(intConsumer);
                } catch (InterruptedException e) {

                }
            }
        };
        Runnable odd = new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = new IntConsumer();
                try {
                    id1116.odd(intConsumer);
                } catch (InterruptedException e) {

                }
            }
        };
        service.execute(zero);
        service.execute(even);
        service.execute(odd);
        service.shutdown();
    }
}
