package com.online.unishop.core.commentary.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaryModelRepository extends JpaRepository<CommentaryModel,Long> {
    List<CommentaryModel> findAllCommentsByTovarId(Long tovarId);
}
