package com.atique.orm.Service;

import com.atique.orm.Dao.WriterDao;
import com.atique.orm.Entity.WriterInfoEntity;
import com.atique.orm.Model.WriterInfo;
import com.atique.orm.Model.WriterInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class WriterInfoServiceImpl implements WriterInfoService {
    private final WriterHelperService helperService;
    private final WriterDao writerDao;

    @Autowired
    public WriterInfoServiceImpl(WriterHelperService helperService, WriterDao writerDao) {
        this.helperService = helperService;
        this.writerDao = writerDao;
    }

    @Override
    public WriterInfoDto addWriterInfo(WriterInfo info) {
        WriterInfoEntity entity = helperService.getWriterEntityFromInfo(info);
        entity = writerDao.save(entity);
        return helperService.getWriterDtoFromEntity(entity);
    }

    @Override
    public Page<WriterInfoDto> getWriterInfoList(Long readerId, Pageable pageable) {
        Page<WriterInfoEntity> writerInfoEntities = writerDao.getWriterInfoList(readerId, pageable);
        Page<WriterInfoDto> dtoPage = writerInfoEntities.map(entity -> helperService.getWriterDtoFromEntity(entity));
        return dtoPage;
    }

    @Override
    @Transactional
    public WriterInfoDto replaceWriterInfo(WriterInfo info) {
        WriterInfoEntity existingEntity = writerDao.getExistingWriterInfo(info.getReaderId(), info.getWriterName());

        existingEntity.setWriterAddress(info.getWriterAddress());
        existingEntity.getBooks().clear();
        existingEntity.getBooks().addAll(helperService.getBookEntities(info, existingEntity));
        existingEntity = writerDao.save(existingEntity);

        return helperService.getWriterDtoFromEntity(existingEntity);
    }


}
