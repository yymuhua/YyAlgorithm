package page;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author yymuhua
 * @create 2020-04-20 13:06
 */
public class Pager<T> implements Iterator<List<T>> {

    /**
     * 每页多少个数据
     */
    private long itemsPerPage;

    /**
     * 页数，由 itemsPerPage 和 totalItems 算出。
     */
    private long totalPages;

    /**
     * 数据总量。 在构造时传入，一般由DAO中 "select count(*)" 的方法调用获得。
     */
    private long totalItems;

    /**
     * 目前的页面下标 - 1，用于迭代器迭代的游标，用于内部计算。
     */
    private long cursor;

    /**
     * 目前的页面下标。
     */
    private long currentPage;

    /**
     * 封装的翻页操作实体的 offset 参数。
     */
    private long offset;

    /**
     * 封装的翻页操作实体的 limit 参数，绝大多数情况下等于 itemsPerPage。
     */
    private long limit;

    /**
     * 当前页面的数据
     */
    private List<T> currentItems;

    /**
     * 翻页操作实体的封装接口。
     */
    private Method<T> query;

    public Pager(long itemsPerPage, long totalItems, Method<T> query) {

        validateItemsPerPage(itemsPerPage);
        validateTotalItems(totalItems);

        this.itemsPerPage = itemsPerPage;
        this.totalItems = totalItems;
        this.query = query;

        totalPages = (totalItems + itemsPerPage - 1) / itemsPerPage;
        offset = 0;
        limit = itemsPerPage;
        currentPage = 1;
        cursor = 0;

        currentItems = query.query(limit, offset);
    }

    public List<T> getCurrentItems() {
        return currentItems;
    }

    @Override
    public boolean hasNext() {
        return cursor != totalPages;
    }

    @Override
    public List<T> next() {
        return page(++cursor);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public List<T> first() {
        cursor = 0;
        return next();
    }

    public List<T> last() {
        cursor = totalPages - 1;
        return next();
    }

    public List<T> page(long pageNumber) {

        if (pageNumber > totalPages) {
            throw new NoSuchElementException("页面越界");
        } else if (pageNumber < 1) {
            throw new NoSuchElementException("pageNumber不能小于1");
        }

        if (currentPage == pageNumber) {
            return (currentItems);
        }

        if (currentPage == 0 && pageNumber == 1) {
            return (currentItems);
        }

        setOffset(pageNumber);
        currentItems = query.query(limit, offset);
        currentPage = pageNumber;
        return (currentItems);
    }

    private void setOffset(long pageNumber) {
        offset = (pageNumber - 1) * itemsPerPage;
    }

    private void validateTotalItems(long totalItems) {
        if (totalItems < 0) {
            throw new IllegalArgumentException("totalItems不能小于零");
        }
    }

    private void validateItemsPerPage(long itemsPerPage) {
        if (itemsPerPage < 0) {
            throw new IllegalArgumentException("itemsPerPage不能小于零");
        }

        if (itemsPerPage == 0) {
            throw new IllegalArgumentException("itemsPerPage不能等于零");
        }
    }
    /* --- properties --- */
    /**
     * Properties 对外部类属性的封装。
     */
    public class Properties {
        public long getItemsPerPage() {
            return itemsPerPage;
        }

        public long getTotalPages() {
            return totalPages;
        }

        public long getTotalItems() {
            return totalItems;
        }

        public long getCurrentPage() {
            return currentPage;
        }

        public long getOffset() {
            return offset;
        }

        public long getLimit() {
            return limit;
        }

        public List<T> getCurrentItems() {
            return currentItems;
        }

        public Method<T> getQuery() {
            return query;
        }
    }
}