package com.atique.orm.Controller;

import com.atique.orm.Model.WriterInfoDto;
import com.atique.orm.Model.WriterInfo;
import com.atique.orm.Service.WriterInfoService;
import com.atique.orm.Utils.WriterConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/writer/info")
public class WriterInfoController {

    private final WriterInfoService writerInfoService;

    @Autowired
    public WriterInfoController(WriterInfoService writerInfoService) {
        this.writerInfoService = writerInfoService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public WriterInfoDto addWriterInfo(@RequestBody @Validated WriterInfo writerInfo) {
        log.info("Received addWriterInfo request...");
        return writerInfoService.addWriterInfo(writerInfo);
    }

    @RequestMapping(value = "/list/{readerId}", method = RequestMethod.GET, produces = "application/json")
    public Page<WriterInfoDto> getWriterInfoList(@PathVariable(name = "readerId") Long readerId,
                                                 @RequestParam(name = "pageSize", required = false) Integer pageSize,
                                                 @RequestParam(name = "pageNumber", required = false) Integer pageNumber) {
        log.info("Received getWriterInfoList request with writerInfoId: {}", readerId);
        if (pageSize == null) {
            pageSize = WriterConstants.DefaultPageConfig.PageSize;
        }
        if (pageNumber == null) {
            pageNumber = WriterConstants.DefaultPageConfig.PageNumber;
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return writerInfoService.getWriterInfoList(readerId, pageable);
    }

    @RequestMapping(value = "/replace", method = RequestMethod.PUT, produces = "application/json")
    public WriterInfoDto replaceWriterInfo(@RequestBody @Validated WriterInfo writerInfo) {
        log.info("Received replaceWriterInfo request...");
        return writerInfoService.replaceWriterInfo(writerInfo);
    }

}
