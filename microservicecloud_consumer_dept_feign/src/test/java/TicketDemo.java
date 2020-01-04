import java.util.concurrent.atomic.AtomicInteger;

public class TicketDemo {

    public static void main(String[] args) {

        //指定一个任务，可以使用Runnable接口的方式，
        Runnable runnable = () ->{
            //主要有票就一直买
          while(TicketTask.ticketNum >0){
              System.out.println(Thread.currentThread().getName()+"卖出了一张票，剩余"+--TicketTask.ticketNum);
          }
        };

        Runnable runnableSynchori = () ->{
            //主要有票就一直买
            synchronized (TicketDemo.class) {
                while (TicketTask.ticketCount.get() > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余" + TicketTask.ticketCount.decrementAndGet());
                }
            }
        };

//        new Thread(runnableSynchori).start();
////        new Thread(runnableSynchori).start();
////        new Thread(runnableSynchori).start();
////        new Thread(runnableSynchori).start();



        for (int i = 0; i <10 ; i++) {
            new Thread(() ->{
                SingleDemo1.getSingleDemo1();
            }).start();
        }
    }

}

class TicketTask{
    public static int ticketNum = 100;
    public static AtomicInteger ticketCount = new AtomicInteger(100);
}


class SingleDemo{

    private SingleDemo(){
        System.out.println("创建了");
    };

    private static SingleDemo singleDemo ;

    public static SingleDemo getSingleDemo() {
        if( singleDemo == null){
            singleDemo = new SingleDemo();
        }
        return singleDemo;
    }
}

class SingleDemo1{

    private SingleDemo1(){
        System.out.println("饿汉式没有问题");
    };

    private static SingleDemo1 singleDemo1 = new SingleDemo1();

    public static SingleDemo1 getSingleDemo1() {
        return singleDemo1;
    }
}