package com.abacusproject.board.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateBoardRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String writer;

    @NotNull
    private String password;
}
