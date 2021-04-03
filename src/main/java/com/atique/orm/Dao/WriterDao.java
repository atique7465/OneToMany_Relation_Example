package com.atique.orm.Dao;

import com.atique.orm.Entity.WriterInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WriterDao {
    WriterInfoEntity save(WriterInfoEntity entity);

    Page<WriterInfoEntity> getWriterInfoList(Long readerId, Pageable pageable);

    WriterInfoEntity getExistingWriterInfo(Long readerId, String writerName);
}
