package com.atique.orm.Service;

import com.atique.orm.Model.WriterInfoDto;
import com.atique.orm.Model.WriterInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WriterInfoService {
    WriterInfoDto addWriterInfo(WriterInfo info);

    Page<WriterInfoDto> getWriterInfoList(Long readerId, Pageable pageable);

    WriterInfoDto replaceWriterInfo(WriterInfo writerInfo);
}
