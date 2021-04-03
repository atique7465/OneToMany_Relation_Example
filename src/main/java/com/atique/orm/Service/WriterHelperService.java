package com.atique.orm.Service;

import com.atique.orm.Entity.BookEntity;
import com.atique.orm.Entity.WriterInfoEntity;
import com.atique.orm.Model.BookDetail;
import com.atique.orm.Model.BookDetailDto;
import com.atique.orm.Model.WriterInfo;
import com.atique.orm.Model.WriterInfoDto;

import java.util.List;

public interface WriterHelperService {
    WriterInfoEntity getWriterEntityFromInfo(WriterInfo info);

    WriterInfoDto getWriterDtoFromEntity(WriterInfoEntity entity);

    List<BookEntity> getBookEntities(WriterInfo info, WriterInfoEntity writerInfoEntity);

    BookEntity getBookEntity(WriterInfoEntity writerInfoEntity, BookDetail book);

    List<BookDetailDto> getBookDetailsFromBookEntities(List<BookEntity> bookEntities);

    BookDetailDto getBookDetailDto(BookEntity bookEntity);
}
