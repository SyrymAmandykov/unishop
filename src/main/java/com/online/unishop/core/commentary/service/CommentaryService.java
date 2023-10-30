package com.online.unishop.core.commentary.service;

import com.online.unishop.core.tovar.dto.TovarDto;

public interface CommentaryService {

    void addNewComment(String text, Long tovarDtoId,Long usersDtoId);


}
