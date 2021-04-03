package com.atique.orm.Dao;

import com.atique.orm.Entity.WriterInfoEntity;
import com.atique.orm.Repository.WriterInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WriterDaoImpl implements WriterDao {

    private final WriterInfoRepository repository;

    @Autowired
    public WriterDaoImpl(WriterInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public WriterInfoEntity save(WriterInfoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Page<WriterInfoEntity> getWriterInfoList(Long readerId, Pageable pageable) {
        return repository.findWriterInfoEntitiesByReaderId(readerId, pageable);
    }

    @Override
    public WriterInfoEntity getExistingWriterInfo(Long readerId, String writerName) {
        return repository.findWriterInfoEntityByReaderIdAndWriterName(readerId, writerName);
    }
}
