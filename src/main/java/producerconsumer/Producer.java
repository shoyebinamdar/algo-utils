package producerconsumer;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {
    private final BlockingDeque<Integer> queue;

  public Producer(BlockingDeque<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      process();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void process() throws InterruptedException {
    for (int i = 1; i <= 20; i++) {
      System.out.println("[Producer] Put : " + i);
      queue.put(i);
      System.out.println("[Producer] Queue Available Capacity : " + queue.remainingCapacity());
      Thread.sleep(100);
    }
  }
}
