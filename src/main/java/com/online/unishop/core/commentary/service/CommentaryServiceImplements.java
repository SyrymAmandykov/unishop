package com.online.unishop.core.commentary.service;

import com.online.unishop.core.commentary.dto.CommentDto;
import com.online.unishop.core.commentary.model.CommentaryModel;
import com.online.unishop.core.commentary.model.CommentaryModelRepository;
import com.online.unishop.core.tovar.model.TovarModel;
import com.online.unishop.core.tovar.model.TovarModelRepository;
import com.online.unishop.core.user.model.UsersModel;
import com.online.unishop.core.user.model.UsersModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentaryServiceImplements implements CommentaryService {

    private final CommentaryModelRepository commentaryModelRepository;
    private final UsersModelRepository usersModelRepository; // обьявляем что мы будем обращаться в бд юзеров
    private final TovarModelRepository tovarModelRepository;

    @Override
    /*Добавляем новый коммент,для этого в параметрах передаем id а бд сам сгенерит потому что в модельке
    мы это прописали
    в параметрах есть userId и tovarId,это нам нужно чтобы при добавлении коммента понимать под каким товаром
    и какой именно юзер добавляет
    для этого джаве мы даем понять что от обьектов TovarModel/UsersModel нам нужны их айдишки только,
    далее в строке 38 в бд  CommentaryModel
    мы создаем новый коммент
    */
    public void addNewComment(String title, String text, Long userId, Long tovarId) {

        TovarModel tovarModel = tovarModelRepository
                .findById(tovarId)
                .orElseThrow();
        UsersModel usersModel = usersModelRepository
                .findById(userId)
                .orElseThrow();
        commentaryModelRepository.save(
                new CommentaryModel(
                        null,
                        title,
                        text,
                        tovarModel,
                        usersModel
                )
        );
    }

    @Override
    public List<CommentDto> getAllCommentsByTovarId(Long tovarId) {
        return commentaryModelRepository
                .findAllByTovarModelId(tovarId)
                .stream()
                .map(CommentaryModel::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long id) {
        commentaryModelRepository.deleteById(id);
    }
}
