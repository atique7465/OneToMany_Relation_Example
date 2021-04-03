package com.atique.orm.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriterInfo {
    @NotNull
    private Long readerId;

    @NotNull
    private String writerName;

    private String writerAddress;

    @NotNull
    private List<BookDetail> bookList;
}
