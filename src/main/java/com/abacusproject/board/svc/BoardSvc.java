package com.abacusproject.board.svc;

import com.abacusproject.board.bean.*;
import com.abacusproject.board.common.errorcode.ErrorCode;
import com.abacusproject.board.common.exception.CustomException;
import com.abacusproject.board.dao.BoardDao;
import com.abacusproject.board.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardSvc {

    private final BoardDao boardDao;

    private final int COUNT_PER_PAGE = 5;

    @Transactional
    public ResponseEntity<Object> createBoard(CreateBoardRequest createBoardRequest) {
        BoardResBean boardResBean = new BoardResBean();
        boardDao.create(createBoardRequest);
        return new ResponseEntity<Object>(boardResBean, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Object> getBoard(int boardId) {
        BoardResBean boardResBean = new BoardResBean();
        boardDao.updateViewCount(boardId);
        BoardBean board = boardDao.getBoard(boardId);
        boardResBean.setResult(board);
        return new ResponseEntity<Object>(boardResBean, HttpStatus.OK);
    }

    public ResponseEntity<Object> getBoardListWithPaging(PagingDto pagingDto) {
        BoardResBean boardResBean = new BoardResBean();

        int count = boardDao.count(pagingDto);
        if (count < 1) {
            PagingResponse<Object> response = new PagingResponse<>(Collections.emptyList(), null);
            boardResBean.setResult(response);
            return new ResponseEntity<>(boardResBean, HttpStatus.OK);
        }

        Pagination pagination = new Pagination(count, pagingDto);
        pagingDto.setPagination(pagination);

        List<BoardListBean> boardList = boardDao.findAll(pagingDto);
        PagingResponse<BoardListBean> response = new PagingResponse<>(boardList, pagination);
        boardResBean.setResult(response);
        return new ResponseEntity<>(boardResBean, HttpStatus.OK);
    }

    public ResponseEntity<Object> getBoardListByViewCount(PagingDto pagingDto) {
        BoardResBean boardResBean = new BoardResBean();

        int count = boardDao.count(pagingDto);
        if (count < 1) {
            PagingResponse<Object> response = new PagingResponse<>(Collections.emptyList(), null);
            boardResBean.setResult(response);
            return new ResponseEntity<>(boardResBean, HttpStatus.OK);
        }

        Pagination pagination = new Pagination(count, pagingDto);
        pagingDto.setPagination(pagination);

        List<BoardListBean> boardList = boardDao.findAllByViewCount(pagingDto);
        PagingResponse<BoardListBean> response = new PagingResponse<>(boardList, pagination);
        boardResBean.setResult(response);

        return new ResponseEntity<>(boardResBean, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Object> updateBoard(int boardId, UpdateBoardDto updateBoardDto) {
        BoardResBean boardResBean = new BoardResBean();

        String password = boardDao.getPassword(boardId);

        if (!updateBoardDto.getPassword().equals(password)) {
            throw new CustomException(ErrorCode.WRONG_PASSWORD);
        }

        boardDao.updateBoard(updateBoardDto);
        return new ResponseEntity<>(boardResBean, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Object> deleteBoard(int boardId, DeleteBoardDto deleteBoardDto) {
        BoardResBean boardResBean = new BoardResBean();

        String password = boardDao.getPassword(boardId);

        if (!deleteBoardDto.getPassword().equals(password)) {
            throw new CustomException(ErrorCode.WRONG_PASSWORD);
        }
        boardDao.deleteBoard(deleteBoardDto.getBoardId());
        return new ResponseEntity<>(boardResBean, HttpStatus.OK);
    }
}
