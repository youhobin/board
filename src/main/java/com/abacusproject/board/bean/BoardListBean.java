package com.abacusproject.board.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListBean {

    private int boardId;
    private String title;
    private String writer;
    private int viewCount;

}
