package com.zyc.service.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyc.common.exception.BusinessException;
import com.zyc.service.core.pojo.dto.ExcelDictDTO;
import com.zyc.service.core.pojo.entity.Dict;
import com.zyc.service.core.mapper.DictMapper;
import com.zyc.service.core.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.service.core.utils.MyReadListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

    @Resource
    private DictMapper dictMapper;

    @Override
    public void upload(MultipartFile file) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            // 开始读取文件
            EasyExcel.read(inputStream, ExcelDictDTO.class, new MyReadListener(this)).sheet().doRead();
        } catch (IOException e) {
            throw new BusinessException("文件解析失败");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new BusinessException("文件解析失败");
            }
        }

    }

    /**
     * 查询所有数据字典数据
     *
     * @return
     */
    @Override
    public List<ExcelDictDTO> listDictData() {
        List<Dict> list = list();
        return BeanUtil.copyToList(list, ExcelDictDTO.class);
    }

    /**
     * 根据父节点id查找子节点
     *
     * @param pid
     * @return
     */
    @Override
    public List<ExcelDictDTO> listByParentId(Integer pid) {
        List<Dict> dictList = dictMapper.selectList(new QueryWrapper<Dict>().eq("parent_id", pid));
        List<ExcelDictDTO> dictDTOS = BeanUtil.copyToList(dictList, ExcelDictDTO.class);
        dictDTOS.forEach(dto->{
            Boolean has = hasParentNode(dto.getId());
            dto.setHasChildren(has);
        });
        return dictDTOS;
    }

    /**
     * 根据父节点id判断是否含有子节点
     */
    public Boolean hasParentNode(Long pid) {
        return dictMapper.selectCount(new QueryWrapper<Dict>().eq("parent_id", pid)) > 0;
    }
}
