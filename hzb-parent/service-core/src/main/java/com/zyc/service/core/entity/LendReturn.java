package com.zyc.service.core.entity;

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
 * 还款记录表
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lend_return")
@ApiModel(value="LendReturn对象", description="还款记录表")
public class LendReturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标的id")
    @TableField("lend_id")
    private Long lendId;

    @ApiModelProperty(value = "借款信息id")
    @TableField("borrow_info_id")
    private Long borrowInfoId;

    @ApiModelProperty(value = "还款批次号")
    @TableField("return_no")
    private String returnNo;

    @ApiModelProperty(value = "借款人用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "借款金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "计息本金额")
    @TableField("base_amount")
    private BigDecimal baseAmount;

    @ApiModelProperty(value = "当前的期数")
    @TableField("current_period")
    private Integer currentPeriod;

    @ApiModelProperty(value = "年化利率")
    @TableField("lend_year_rate")
    private BigDecimal lendYearRate;

    @ApiModelProperty(value = "还款方式 1-等额本息 2-等额本金 3-每月还息一次还本 4-一次还本")
    @TableField("return_method")
    private Integer returnMethod;

    @ApiModelProperty(value = "本金")
    @TableField("principal")
    private BigDecimal principal;

    @ApiModelProperty(value = "利息")
    @TableField("interest")
    private BigDecimal interest;

    @ApiModelProperty(value = "本息")
    @TableField("total")
    private BigDecimal total;

    @ApiModelProperty(value = "手续费")
    @TableField("fee")
    private BigDecimal fee;

    @ApiModelProperty(value = "还款时指定的还款日期")
    @TableField("return_date")
    private LocalDate returnDate;

    @ApiModelProperty(value = "实际发生的还款时间")
    @TableField("real_return_time")
    private LocalDateTime realReturnTime;

    @ApiModelProperty(value = "是否逾期")
    @TableField("is_overdue")
    private Boolean isOverdue;

    @ApiModelProperty(value = "逾期金额")
    @TableField("overdue_total")
    private BigDecimal overdueTotal;

    @ApiModelProperty(value = "是否最后一次还款")
    @TableField("is_last")
    private Boolean isLast;

    @ApiModelProperty(value = "状态（0-未归还 1-已归还）")
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
