package producerconsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerMain {

  public static void main(String[] args) {
    BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(10);

    new Thread(new Producer(queue)).start();
    new Thread(new Consumer(queue)).start();
  }
}
