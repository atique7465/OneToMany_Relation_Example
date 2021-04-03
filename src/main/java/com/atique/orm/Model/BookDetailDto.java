package com.atique.orm.Model;

import com.atique.orm.Enums.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDto {
    private Long id;
    private String bookName;
    private BookType bookType;
    private Integer cnt;
}
