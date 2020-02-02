package work.books.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.books.books.enums.CommentTypeEnum;
import work.books.books.exception.CustomizeErrorCode;
import work.books.books.exception.CustomizeException;
import work.books.books.mapper.CommentMapper;
import work.books.books.mapper.QuestionExtMapper;
import work.books.books.mapper.QuestionMapper;
import work.books.books.model.Comment;
import work.books.books.model.Question;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;


    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            } else {
                commentMapper.insert(comment);
            }
        } else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            } else {
                commentMapper.insert(comment);
                question.setCommentCount(1);
                questionExtMapper.inCommentCount(question);
            }
        }
    }
}
