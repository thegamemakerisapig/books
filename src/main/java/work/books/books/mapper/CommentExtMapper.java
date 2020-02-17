package work.books.books.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import work.books.books.model.Comment;
import work.books.books.model.CommentExample;
import work.books.books.model.Question;

import java.util.List;

public interface CommentExtMapper {
    int inCommentCount(Comment comment);
}