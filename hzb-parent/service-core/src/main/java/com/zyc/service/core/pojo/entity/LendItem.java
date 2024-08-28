package com.zyc.service.core.pojo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 标的出借记录表
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lend_item")
@ApiModel(value="LendItem对象", description="标的出借记录表")
public class LendItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "投资编号")
    @TableField("lend_item_no")
    private String lendItemNo;

    @ApiModelProperty(value = "标的id")
    @TableField("lend_id")
    private Long lendId;

    @ApiModelProperty(value = "投资用户id")
    @TableField("invest_user_id")
    private Long investUserId;

    @ApiModelProperty(value = "投资人名称")
    @TableField("invest_name")
    private String investName;

    @ApiModelProperty(value = "投资金额")
    @TableField("invest_amount")
    private BigDecimal investAmount;

    @ApiModelProperty(value = "年化利率")
    @TableField("lend_year_rate")
    private BigDecimal lendYearRate;

    @ApiModelProperty(value = "投资时间")
    @TableField("invest_time")
    private LocalDateTime investTime;

    @ApiModelProperty(value = "开始日期")
    @TableField("lend_start_date")
    private LocalDate lendStartDate;

    @ApiModelProperty(value = "结束日期")
    @TableField("lend_end_date")
    private LocalDate lendEndDate;

    @ApiModelProperty(value = "预期收益")
    @TableField("expect_amount")
    private BigDecimal expectAmount;

    @ApiModelProperty(value = "实际收益")
    @TableField("real_amount")
    private BigDecimal realAmount;

    @ApiModelProperty(value = "状态（0：默认 1：已支付 2：已还款）")
    @TableField("status")
    private Integer status;

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
