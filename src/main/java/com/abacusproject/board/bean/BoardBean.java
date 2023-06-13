package com.abacusproject.board.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBean {

    private int boardId;
    private String title;
    private String content;
    private String writer;
    private int viewCount;

}
