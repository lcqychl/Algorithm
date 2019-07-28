package dataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yyj on 2019/03/20.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class ListDel {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        removeFromList(list, t -> t == 3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public interface Filter<T> {
        boolean filter(T t);
    }

    public static <T> void removeFromList(List<T> list, Filter<T> f) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (f.filter(t))
                iterator.remove();
        }
    }

    public static synchronized <T> void removeFromList2(List<T> list, Filter<T> f) {
        removeFromList(list, f);
    }
}
