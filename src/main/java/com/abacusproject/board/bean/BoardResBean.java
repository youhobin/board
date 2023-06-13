package com.abacusproject.board.bean;

import com.abacusproject.board.resource.BoardResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResBean {

    int code = BoardResource.SUC_CD;
    int status = BoardResource.SUC_STATUS;
    String desc = BoardResource.SUC_DESC;
    Object result;

}
