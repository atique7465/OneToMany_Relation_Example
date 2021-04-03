package com.atique.orm.Model;

import com.atique.orm.Enums.BookType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDetail {
    @NotNull
    private String bookName;

    @NotNull
    private BookType bookType;

    @NotNull
    private Integer cnt;
}
