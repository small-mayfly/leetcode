package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ID1116_2 {
    private int n;
    private int nowNum;
    Semaphore z, e, o;

    public ID1116_2(int n) {
        this.n = n;
        this.nowNum = 1;
        z = new Semaphore(1);
        e = new Semaphore(0);
        o = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        Integer integer = new Integer(0);
        while (nowNum<n) {
            z.acquire();
            printNumber.accept(integer);
            if(nowNum%2==1){
                o.release();
            }else{
                e.release();
            }
        }
        o.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (nowNum<=n){
            e.acquire();
            if(nowNum<=n){
                printNumber.accept(nowNum++);
            }
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (nowNum<=n){
            o.acquire();
            if(nowNum<=n){
                printNumber.accept(nowNum++);
            }
            z.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        ID1116_2 id1116 = new ID1116_2(3);
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

class IntConsumer{
    public void accept(Integer num){
        System.out.print(num);
    }
}