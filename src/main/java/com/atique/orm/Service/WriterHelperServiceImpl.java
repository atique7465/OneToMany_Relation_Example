package com.atique.orm.Service;

import com.atique.orm.Entity.BookEntity;
import com.atique.orm.Entity.WriterInfoEntity;
import com.atique.orm.Model.BookDetail;
import com.atique.orm.Model.BookDetailDto;
import com.atique.orm.Model.WriterInfo;
import com.atique.orm.Model.WriterInfoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WriterHelperServiceImpl implements WriterHelperService {
    /**
     * @param info
     * @return
     */
    @Override
    public WriterInfoEntity getWriterEntityFromInfo(WriterInfo info) {
        WriterInfoEntity writerInfoEntity = WriterInfoEntity.builder()
                .readerId(info.getReaderId())
                .writerName(info.getWriterName())
                .writerAddress(info.getWriterAddress())
                .books(new ArrayList<>())
                .build();
        writerInfoEntity.setBooks(getBookEntities(info, writerInfoEntity));
        return writerInfoEntity;
    }

    /**
     * @param info
     * @param writerInfoEntity
     * @return
     */
    @Override
    public List<BookEntity> getBookEntities(WriterInfo info, WriterInfoEntity writerInfoEntity) {
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookDetail book : info.getBookList()) {
            BookEntity bookEntity = getBookEntity(writerInfoEntity, book);
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }

    /**
     * @param writerInfoEntity
     * @param book
     * @return
     */
    @Override
    public BookEntity getBookEntity(WriterInfoEntity writerInfoEntity, BookDetail book) {
        return BookEntity.builder()
                .bookName(book.getBookName())
                .bookType(book.getBookType())
                .cnt(book.getCnt())
                .writerInfoEntity(writerInfoEntity)
                .build();
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public WriterInfoDto getWriterDtoFromEntity(WriterInfoEntity entity) {
        return WriterInfoDto.builder()
                .id(entity.getId())
                .readerId(entity.getReaderId())
                .writerName(entity.getWriterName())
                .writerAddress(entity.getWriterAddress())
                .bookList(getBookDetailsFromBookEntities(entity.getBooks()))
                .build();
    }

    /**
     * @param bookEntities
     * @return
     */
    @Override
    public List<BookDetailDto> getBookDetailsFromBookEntities(List<BookEntity> bookEntities) {
        List<BookDetailDto> dtos = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            BookDetailDto detailDto = getBookDetailDto(bookEntity);
            dtos.add(detailDto);
        }
        return dtos;
    }

    /**
     * @param bookEntity
     * @return
     */
    @Override
    public BookDetailDto getBookDetailDto(BookEntity bookEntity) {
        return BookDetailDto.builder()
                .id(bookEntity.getId())
                .bookName(bookEntity.getBookName())
                .bookType(bookEntity.getBookType())
                .cnt(bookEntity.getCnt())
                .build();
    }

}
