import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo extends Thread {


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "线程开启了");
    }

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println("name" + name);
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        TheandTest theandTest = new TheandTest();
        Thread thread = new Thread(theandTest);
        thread.start();
        try {
            thread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(() -> {
            System.out.println("xianchegn ");
        });
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("123");
    }

    @Test
    public void test4() {
        new Thread(() -> {
            testA();
        }).start();

        new Thread(() -> {
            testB();
        }).start();

    }


    public void testA() {


        synchronized (this) {
            try {
                System.out.println("A线程开始等待。。。"+Thread.currentThread().getName());
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待的线程被唤醒了"+Thread.currentThread().getName());
        }

    }

    public void testB() {

        synchronized (this) {
           System.out.println("前方线程礼让，我们赶快执行"+Thread.currentThread().getName());
           notify();
           System.out.println("唤醒了等待的线程"+Thread.currentThread().getName());
        }

    }


    @Test
    public void test() {
//        ConcurrentHashMap
        Thread thread = new Thread();

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        int m;
        int j = 0;
        for (; ; ) {
            j++;
            int i = new String("" + j).hashCode();
            m = 15 & i;
            if (m > 15) {
                System.out.println("大雨了");
            } else {
                System.out.println(i + "小与" + m);
            }
        }
    }

    @Test
    public void test1() {
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add(null);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.remove(1);
        linkedList.add("1");

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 双向链表结构
 * LinkedList中，使用Node这个类来描述一个节点
 * 节点中包括要存储的数据、上一个节点Node，下一个节点Node，所以是双向链表
 *
 * @param <E>
 */
//class Node<E>{
//    E item;        //存放的泛型
//    Node<E> pro;   //上一个Node
//    Node<E> next;  //下一个Node
//
//    //构造
//    Node(Node<E> pro,E item,Node<E> next){
//        this.item= item;
//        this.pro =pro;
//        this.next=next;
//    }
//}

/**
 * 数组加链表结构：所有的节点使用对象Node来表示
 *
 * @param <K>
 * @param <V>
 */
class Node<K, V> {
    final int hash; //是根据key算出的hash值。
    final K k;      //存储的key
    V v;
    Node<K, V> next;

    Node(int hash, K k, V v, Node<K, V> node) {
        this.hash = hash;
        this.k = k;
    }


}