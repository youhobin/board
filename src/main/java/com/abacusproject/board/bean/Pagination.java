package com.abacusproject.board.bean;

import com.abacusproject.board.dto.PagingDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {

    private int totalRecordCount; // 전체 데이터 수
    private int totalPageCount; // 전체 페이지 수
    private int startPage; // 첫 페이지 번호
    private int endPage; // 끝 페이지 번호
    private int limitStart; // Limit 시작 위치, DB LIMIT
    private boolean existPrevPage; // 이전 페이지 존재 여부
    private boolean existNextPage; // 다음 페이지 존재 여부

    public Pagination(int totalRecordCount, PagingDto pagingDto) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(pagingDto);
        }
    }

    private void calculation(PagingDto pagingDto) {
        totalPageCount = ((totalRecordCount - 1) / pagingDto.getRecordSize()) + 1;

        if (pagingDto.getPage() > totalPageCount) {
            pagingDto.setPage(totalPageCount);
        }

        startPage = ((pagingDto.getPage() - 1) / pagingDto.getPageSize()) * pagingDto.getPageSize() + 1;

        endPage = startPage + pagingDto.getPageSize() - 1;

        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        limitStart = (pagingDto.getPage() - 1) * pagingDto.getRecordSize();

        existPrevPage = startPage != 1;

        existNextPage = (endPage * pagingDto.getRecordSize()) < totalRecordCount;
    }

}
