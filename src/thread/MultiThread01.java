package thread;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author luckw
 * @date 2020/5/19
 */
public class MultiThread01 {
    int[] arr = {1, 2, 3, 2, 3, 1};
    static Queue<Integer> queue = new LinkedList<>();
    static HashMap<Integer, Integer> map = new HashMap();
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        queue.add(1);
        queue.add(2);
        queue.add(1);
        queue.add(3);
        queue.add(1);
        queue.add(3);

        HashMap<Long, Integer> map = test();
        Set<Map.Entry<Long, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Long, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Integer> next = iterator.next();
            System.out.println(next.getKey() + "        " + next.getValue());
        }

//        Future future = executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                int i;
//                while ((i = get()) > 0) {
//                    try {
//                        Thread.sleep(i * 1000);
//                        System.out.println(Thread.currentThread().getName() + "*****" + i);
//                        map.put(i, i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                begin.countDown();
//            }
//        });
//        Future<HashMap> future1 = executorService.submit(new Callable<HashMap>() {
//            @Override
//            public HashMap call() throws Exception {
//                int i;
//                while ((i = get()) > 0) {
//                    try {
//                        Thread.sleep(i * 1000);
//                        System.out.println(Thread.currentThread().getName() + "*********" + i);
//                        map.put(i, i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                begin.countDown();
//                return map;
//            }
//        });

//        future.get();
//        future1.get();
        //
//        begin.await();
//        return map;

    }

    //Future 阻塞
    public synchronized static int get() {
        if (queue.size() > 0) {
            return queue.poll();
        }
        return -1;
    }

    public static HashMap<Long, Integer> test() throws InterruptedException {
        HashMap<Long, Integer> map = new HashMap<>();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int temp;
                while ((temp = get()) > 0) {
                    try {
                        Thread.sleep(temp * 1000);
                        System.out.println(Thread.currentThread().getName() + "*****" + temp);
                        map.put(System.currentTimeMillis(), temp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                latch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int temp;
                while ((temp = get()) > 0) {
                    try {
                        Thread.sleep(temp * 1000);
                        System.out.println(Thread.currentThread().getName() + "&&&&&&&&&&" + temp);
                        map.put(System.currentTimeMillis(), temp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                latch.countDown();
            }
        }).start();

        latch.await();
        return map;
    }

}
