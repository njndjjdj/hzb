package com.zyc.service.core.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zyc.service.core.pojo.dto.ExcelDictDTO;
import com.zyc.service.core.pojo.entity.Dict;
import com.zyc.service.core.service.IDictService;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/28
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
public class MyReadListener extends AnalysisEventListener<ExcelDictDTO> {

    private static final Integer BASE_SIZE = 10;

    private IDictService dictService;

    private ArrayList<ExcelDictDTO> dtoList = new ArrayList<>();

    public MyReadListener(IDictService dictService) {
        this.dictService = dictService;
    }

    /**
     * 每读到一行数据出发的函数
     *
     * @param dict
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelDictDTO dict, AnalysisContext analysisContext) {
        dtoList.add(dict);
        // 每读取到10行数据就写入一次数据到数据库
        if (dtoList.size() >= BASE_SIZE) {
            saveData(dtoList);
            // 清空数据
            dtoList.clear();
        }
    }

    /**
     * 保存数据到数据库
     */
    private void saveData(List<ExcelDictDTO> dtoList) {
        // 数据拷贝到entity实体中
        List<Dict> dicts = BeanUtil.copyToList(dtoList, Dict.class);
        dictService.saveBatch(dicts);
    }

    /**
     * 最终上传完成的回调函数
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData(dtoList);
    }
}
