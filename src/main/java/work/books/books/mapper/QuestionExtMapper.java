package work.books.books.mapper;

import work.books.books.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int inCommentCount(Question record);

}