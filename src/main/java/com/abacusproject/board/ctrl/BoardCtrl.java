package com.abacusproject.board.ctrl;

import com.abacusproject.board.dto.*;
import com.abacusproject.board.svc.BoardSvc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BoardCtrl {

    private final BoardSvc boardSvc;

    @PostMapping("/board")
    public ResponseEntity<Object> createBoard(@RequestBody @Validated CreateBoardRequest createBoardRequest) {
        return boardSvc.createBoard(createBoardRequest);
    }

    @GetMapping("/board/{boardId}") // pathVariable int 혹은 String 어떤 것이 좋을지.
    public ResponseEntity<Object> getBoard(@PathVariable("boardId") int boardId) {
        return boardSvc.getBoard(boardId);
    }

    @GetMapping("/boardList")
    public ResponseEntity<Object> getBoardListWithPaging(@RequestParam int page,
                                                         @RequestParam int recordSize,
                                                         @RequestParam int pageSize,
                                                         @RequestParam(required = false) String searchType,
                                                         @RequestParam(required = false) String keyword,
                                                         @RequestParam String orderBy) {
        PagingDto pagingDto = new PagingDto(page, recordSize, pageSize, keyword, searchType, orderBy);
        return boardSvc.getBoardListWithPaging(pagingDto);
    }

    @GetMapping("/boardList/viewCount")
    public ResponseEntity<Object> getBoardListByViewCount2(@RequestParam int page,
                                                           @RequestParam int recordSize,
                                                           @RequestParam int pageSize,
                                                           @RequestParam(required = false) String searchType,
                                                           @RequestParam(required = false) String keyword,
                                                           @RequestParam String orderBy) {
        PagingDto pagingDto = new PagingDto(page, recordSize, pageSize, keyword, searchType, orderBy);
        return boardSvc.getBoardListByViewCount(pagingDto);
    }

    @PutMapping("/board/{boardId}")
    public ResponseEntity<Object> updateBoard(@PathVariable("boardId") int boardId, @RequestBody UpdateBoardDto updateBoardDto) {
        return boardSvc.updateBoard(boardId, updateBoardDto);
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<Object> deleteBoard(@PathVariable("boardId") int boardId, @RequestBody DeleteBoardDto deleteBoardDto) {
        return boardSvc.deleteBoard(boardId, deleteBoardDto);
    }

}
