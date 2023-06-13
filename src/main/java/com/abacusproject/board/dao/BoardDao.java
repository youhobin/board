package com.abacusproject.board.dao;

import com.abacusproject.board.bean.BoardBean;
import com.abacusproject.board.bean.BoardListBean;
import com.abacusproject.board.dto.CreateBoardRequest;
import com.abacusproject.board.dto.PagingDto;
import com.abacusproject.board.dto.UpdateBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    void create(CreateBoardRequest createBoardRequest);

    BoardBean getBoard(int boardId);

    String getPassword(int boardId);

    void updateBoard(UpdateBoardDto updateBoardDto);

    void deleteBoard(int boardId);

    void updateViewCount(int boardId);

    List<BoardListBean> findAllByViewCount(PagingDto pagingDto);

    int count(PagingDto pagingDto);

    List<BoardListBean> findAll(PagingDto pagingDto);
}
