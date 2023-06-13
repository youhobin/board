package com.abacusproject.board.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPageBean {

    private int pageSize; // 출력할 데이터 개수
    private int startPage; // 현재 페이지 번호

}
