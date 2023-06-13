package com.abacusproject.board.common.errorcode;

import lombok.Getter;

@Getter
public enum ErrorCode {

    WRONG_PASSWORD(400, "잘못된 비밀번호입니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
