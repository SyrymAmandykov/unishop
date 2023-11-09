package com.online.unishop.useCase.commentary.delete;

import com.online.unishop.core.commentary.service.CommentaryService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCommentary extends UseCaseAbstract<DeleteCommentaryInput,Object> {

    private final CommentaryService commentaryService;

    @Override
    protected Object doLogic(DeleteCommentaryInput deleteCommentaryInput) {

        if (deleteCommentaryInput.getContent().contains("хуевый,конченный,ебанутый,хуевые,ебанутые,конченные")){
            commentaryService.deleteComment(deleteCommentaryInput.getCommentId());

        }
        return null;
    }
}
