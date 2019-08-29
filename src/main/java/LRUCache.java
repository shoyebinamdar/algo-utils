import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *  LRUCache :
 *  As the name suggest it is an paging algorithm which uses Least Recently used cache mechanism.
 *  i.e. we will have a cache with size 'n' and it can store 'n' number of elements/pages in it.
 *  So, whenever we do a lookup in our cache for a particular page/element, the cache will return us the page/element, and we call it as 'cache hit'
 *  In case of cache hit, apart from returning the page/element, cache also updates itself marking the returned element as the most recently used.
 *  If cache doesn't contain an page/element (we call it a 'cache miss'), then it just adds it in and mark it as most recently used.
 *
 *  Algorithm :
 *
 *  For implementing LRU we have used,
 *  queue : for maintaining the order of elements, also it helps in easy removal and insertion.
 *          Insertion happens from the front(MRU) and removal happens from the end(LRU)
 *  map   : acts as a reference for the pages/elements which are present in queue.
 *  size  : size of our cache
 */

public class LRUCache {
    private int size;
    private Deque<Integer> queue;
    private Set<Integer> set;

  public LRUCache(int size) {
    this.size = size;
    queue = new LinkedList<>();
    set = new HashSet<>();
  }

  public void refer(int x) {
    if (!set.contains(x)) {
      if (queue.size() == size) {
        int last = queue.removeLast();
        set.remove(last);
      }
    } else {
      queue.removeLastOccurrence(x);
    }

    set.add(x);
    queue.push(x);
  }

  public List<Integer> get() {
    return queue.stream().collect(Collectors.toList());
  }
}
