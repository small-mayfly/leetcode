package zhousai.doublecom.c20;

import java.util.ArrayList;

/**
 * 这道题没什么说的，就是实现一个类
 */
class Cashier{

    int nowIndex;   // 用来记录顾客的序号
    int n;   // 记录打折的顾客编号
    double discount;   // 记录折扣
    ArrayList<Integer> products;   // 用来记录所有的商品索引值
    int[] prices;   // 用来记录商品的价格

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.nowIndex = 1;
        this.n = n;
        this.discount = discount;
        this.products = new ArrayList<>();
        for (int product : products) {
            this.products.add(product);
        }
        this.prices = prices;
    }

    /**
     * 计算顾客所买商品共花了多少钱，首先获取商品所在位置的索引，然后按照索引找到商品价格，之后计算总价
     * @param product
     * @param amount
     * @return
     */
    public double culAmount(int[] product, int[] amount){
        int result = 0;
        int tindex;
        for(int i=0;i<product.length;i++){
            tindex = this.products.indexOf(product[i]);
            result += (this.prices[tindex]*amount[i]);
        }
        return result*1.0;
    }

    public double getBill(int[] product, int[] amount) {
        double result = culAmount(product, amount);
        if(this.nowIndex == this.n){   // 如果是幸运顾客则给与折扣价
            this.nowIndex = 1;
            result = (result - (discount * result) / 100.0);
        }else {
            this.nowIndex++;
        }
        return result;
    }
}

public class SecondClass {
    public static void main(String[] args) {
        int[] products = {1,2,3,4,5,6,7, 10};
        int[] prices = {100,200,300,400,300,200,100, 1000};
        Cashier obj = new Cashier(3,50, products, prices);
        int[] product = {1,2};
        int[] amount = {1,2};
        System.out.println(obj.getBill(product,amount));
        int[] product1 = {3,7};
        int[] amount1 = {10,10};
        System.out.println(obj.getBill(product1,amount1));
        int[] product2 = {1,2,3,4,5,6,7};
        int[] amount2 = {1,1,1,1,1,1,1};
        System.out.println(obj.getBill(product2,amount2));
        int[] product3 = {4};
        int[] amount3 = {10};
        System.out.println(obj.getBill(product3,amount3));
        int[] product4 = {7,3};
        int[] amount4 = {10,10};
        System.out.println(obj.getBill(product4,amount4));
        int[] product5 = {7,5,3,1,6,4,2};
        int[] amount5 = {10,10,10,9,9,9,7};
        System.out.println(obj.getBill(product5,amount5));
        int[] product6 = {2,3,5};
        int[] amount6 = {5,3,2};
        System.out.println(obj.getBill(product6,amount6));
        int[] product7 = {10};
        int[] amount7 = {2};
        System.out.println(obj.getBill(product7,amount7));

    }
}
