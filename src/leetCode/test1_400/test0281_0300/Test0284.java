package leetCode.test1_400.test0281_0300;

import java.util.Iterator;

/**
 * @author nimingxiong
 * Created at 2020/4/24 22:00
 */

public class Test0284 implements Iterator<Integer> {

    private Integer cur;
    private Iterator<Integer> iterator;

    public Test0284(Iterator<Integer> iterator) {
        this.iterator = iterator;
        cur = null;
    }

    public Integer peek() {
        if (cur != null) {
            return cur;
        }

        cur = iterator.next();
        return cur;
    }

    @Override
    public Integer next() {
        if (cur != null) {
            int res = cur;
            cur = null;
            return res;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return cur != null || iterator.hasNext();
    }
}
