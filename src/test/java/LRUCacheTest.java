import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LRUCacheTest {
  @Test
  public void testLRU_1() {
    LRUCache lruCache = new LRUCache(4);
    lruCache.refer(1);
    lruCache.refer(2);
    lruCache.refer(3);
    lruCache.refer(1);
    lruCache.refer(4);
    lruCache.refer(5);

    List<Integer> expectedList = Arrays.asList(5, 4, 1, 3);

    assertArrayEquals(expectedList.toArray(), lruCache.get().toArray());
  }

  @Test
  public void testLRU_2() {
    LRUCache lruCache = new LRUCache(3);
    lruCache.refer(1);
    lruCache.refer(2);
    lruCache.refer(3);
    lruCache.refer(4);
    lruCache.refer(1);
    lruCache.refer(2);
    lruCache.refer(5);
    lruCache.refer(1);
    lruCache.refer(2);
    lruCache.refer(3);
    lruCache.refer(4);
    lruCache.refer(5);

    List<Integer> expectedList = Arrays.asList(5, 4, 3);

    assertArrayEquals(expectedList.toArray(), lruCache.get().toArray());
  }
}
