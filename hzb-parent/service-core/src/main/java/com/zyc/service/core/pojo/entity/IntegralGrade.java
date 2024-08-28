package com.zyc.service.core.pojo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 积分等级表
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("integral_grade")
@ApiModel(value="IntegralGrade对象", description="积分等级表")
public class IntegralGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "积分区间开始")
    @TableField("integral_start")
    private Integer integralStart;

    @ApiModelProperty(value = "积分区间结束")
    @TableField("integral_end")
    private Integer integralEnd;

    @ApiModelProperty(value = "借款额度")
    @TableField("borrow_amount")
    private BigDecimal borrowAmount;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;


}
