package page;

import java.util.List;

/**
 * @author yymuhua
 * @create 2020-04-20 13:05
 */
public interface Method<T> {
    List<T> query(long limit, long offset);
}
