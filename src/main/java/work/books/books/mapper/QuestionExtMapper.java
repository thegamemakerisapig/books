package work.books.books.mapper;

import work.books.books.dto.QuestionQueryDTO;
import work.books.books.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);

    int inCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}