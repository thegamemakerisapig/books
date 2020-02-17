package work.books.books.dto;

import lombok.Data;
import work.books.books.model.User;

@Data
public class NotificationDTO {
    private Long id;
    //private Long notifier;
    //private Long receiver;
    //private Integer type;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
