package work.books.books;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.books.books.mapper")
public class BooksApplication {

    public static void main(String[] args) { SpringApplication.run(BooksApplication.class, args); }

}
