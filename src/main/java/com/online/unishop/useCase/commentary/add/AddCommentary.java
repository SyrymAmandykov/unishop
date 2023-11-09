package com.online.unishop.useCase.commentary.add;

import com.online.unishop.core.commentary.service.CommentaryService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddCommentary extends UseCaseAbstract<AddCommentaryInput,Object> {

    private final CommentaryService commentaryService;
    @Override
    protected Object doLogic(AddCommentaryInput addCommentaryInput) {

        if (addCommentaryInput.getTitle().isEmpty())
            throw new IllegalArgumentException("The title cannot be empty");

        if (addCommentaryInput.getUsersDto().getId() == null)
            throw new IllegalArgumentException("User id cannot be empty");

        if (addCommentaryInput.getTovarDto().getId() == null)
            throw new IllegalArgumentException("Tovar id cannot be empty");

        commentaryService.addNewComment(
                addCommentaryInput.getTitle(),
                addCommentaryInput.getText(),
                addCommentaryInput.getUsersDto().getId(),
                addCommentaryInput.getTovarDto().getId()
        );
        return null;
    }
}
