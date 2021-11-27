package CommunicationExer1;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-01 13:10
 */
class Clerk{// 店员
    private int something = 0;
    public synchronized void buySomething() {
        if(something > 0){
            System.out.println(Thread.currentThread().getName() + "开始购买第" + something + "个商品");
            something--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void makeSomething() {
        if(something < 20){
            something++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + something + "个商品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer extends Thread{// 消费者
    Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.buySomething();
        }
    }
}
class Productor extends Thread{// 生产者
    Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.makeSomething();
        }
    }
}

public class ProductExer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Customer c1 = new Customer(clerk);
        Productor p1 = new Productor(clerk);

        c1.setName("消费者1");
        p1.setName("生产者1");

        c1.start();
        p1.start();

    }
}
