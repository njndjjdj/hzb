package com.zyc.service.core.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExcelDictDTO {
    @ExcelProperty("id")
    private Long id;
    @ExcelProperty("上级id")
    private Long parentId;
    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("值")
    private Integer value;
    @ExcelProperty("编码")
    private String dictCode;
    @ApiModelProperty(value = "是否包含子节点")
    private boolean hasChildren;
}