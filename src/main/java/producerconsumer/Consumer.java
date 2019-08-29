package producerconsumer;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {
  private final BlockingDeque<Integer> queue;

  public Consumer(BlockingDeque<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Integer take = queue.take();
        process(take);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void process(Integer take) throws InterruptedException {
    System.out.println("[Consumer] Take : " + take);
    Thread.sleep(500);
  }
}
