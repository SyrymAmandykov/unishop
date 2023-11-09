package com.online.unishop.core.commentary.service;

import com.online.unishop.core.commentary.dto.CommentDto;

import java.util.List;

public interface CommentaryService {

    void addNewComment(String title, String text, Long userId, Long tovarId);

    List<CommentDto> getAllCommentsByTovarId(Long tovarId);

    void deleteComment(Long id);

    //CommentDto getUserIdByCommentaryId(Long id);

}
