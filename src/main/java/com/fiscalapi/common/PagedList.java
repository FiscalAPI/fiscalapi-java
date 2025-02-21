package com.fiscalapi.common;

import java.util.List;

public class PagedList<T> {
    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private long totalCount;

    public List<T> getItems() { return items; }
    public void setItems(List<T> items) { this.items = items; }

    public int getPageNumber() { return pageNumber; }
    public void setPageNumber(int pageNumber) { this.pageNumber = pageNumber; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public long getTotalCount() { return totalCount; }
    public void setTotalCount(long totalCount) { this.totalCount = totalCount; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PagedList{");
        sb.append("items=").append(items);
        sb.append(", pageNumber=").append(pageNumber);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", totalCount=").append(totalCount);
        sb.append('}');
        return sb.toString();
    }
}
