package com.online.unishop.useCase.commentary.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeleteCommentaryInput {
    private Long commentId;
    private String content;
}
