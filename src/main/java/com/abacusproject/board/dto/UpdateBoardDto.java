package com.abacusproject.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBoardDto {

    private int boardId;
    private String content;
    private String password;

}
