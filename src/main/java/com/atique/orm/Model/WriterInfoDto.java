package com.atique.orm.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriterInfoDto {
    private Long id;
    private Long readerId;
    private String writerName;
    private String writerAddress;
    private List<BookDetailDto> bookList;
}
