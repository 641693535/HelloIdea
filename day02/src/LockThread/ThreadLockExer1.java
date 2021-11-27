package LockThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-03-30 17:11
 */
class Account {

    private double balance = 0;
    private ReentrantLock lock = new ReentrantLock();
    public void deposit(double amt) {
        if (amt > 0) {
            try {
                lock.lock();
                balance += amt;
                    Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "：存钱成功！当前账户余额为：" + balance);

            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }finally{
                lock.unlock();
            }
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

class ThreadLockExer1 {
    public static void main(String[] args) {
        Account acct = new Account();
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}