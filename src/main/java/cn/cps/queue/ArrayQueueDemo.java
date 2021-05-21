package cn.cps.queue;

import java.util.Scanner;

/**
 * @Author: Cai Peishen
 * @Date: 2021/5/20 10:26
 * @Description: 使用数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }

    // 使用数组模拟队列-编写一个ArrayQueue类
    static class ArrayQueue {
        private int maxSize; // 表示数组的最大容量
        private int front; // 队列头
        private int rear; // 队列尾
        private int[] arr; // 该数据用于存放数据, 模拟队列


        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[maxSize];
            this.front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置.
            this.rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return rear == maxSize-1;
        }

        public void addQueue(int num) {
            if (isFull()) {
                System.out.println("队列已满...");
                return;
            }
            rear++;
            arr[rear] = num;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            }
            front++; // front后移
            return arr[front];
        }

        // 显示队列的所有数据
        public void showQueue() {
            // 遍历
            if (isEmpty()) {
                System.out.println("队列空的，没有数据~~");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        // 显示队列的头数据， 注意不是取出数据
        public int headQueue() {
            // 判断
            if (isEmpty()) {
                throw new RuntimeException("队列空的，没有数据~~");
            }
            return arr[front + 1];
        }
    }

}


