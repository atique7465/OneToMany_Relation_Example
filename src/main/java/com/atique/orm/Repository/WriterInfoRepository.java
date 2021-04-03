package com.atique.orm.Repository;

import com.atique.orm.Entity.WriterInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterInfoRepository extends JpaRepository<WriterInfoEntity, Long> {
    Page<WriterInfoEntity> findWriterInfoEntitiesByReaderId(Long readerId, Pageable pageable);

    WriterInfoEntity findWriterInfoEntityByReaderIdAndWriterName(Long readerId, String writerName);
}
