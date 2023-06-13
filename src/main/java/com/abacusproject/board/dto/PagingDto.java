package com.abacusproject.board.dto;

import com.abacusproject.board.bean.Pagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingDto {

    private int page;
    private int recordSize;
    private int pageSize;
    private String keyword;
    private String searchType;
    private String orderBy;

    private Pagination pagination;

    public PagingDto(int page, int recordSize, int pageSize, String keyword, String searchType, String orderBy) {
        this.page = page;
        this.recordSize = recordSize;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.searchType = searchType;
        this.orderBy = orderBy;
    }
}
