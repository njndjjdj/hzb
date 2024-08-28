package com.zyc.service.core.service;

import com.zyc.service.core.pojo.dto.ExcelDictDTO;
import com.zyc.service.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
public interface IDictService extends IService<Dict> {

    /**
     * 文件上传
     * @param file
     */
    void upload(MultipartFile file);

    List<ExcelDictDTO> listDictData();

    /**
     * 根据父节点id查找子节点
     * @param pid
     * @return
     */
    List<ExcelDictDTO> listByParentId(Integer pid);
}
