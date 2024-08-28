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
 * 标的出借回款记录表
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lend_item_return")
@ApiModel(value="LendItemReturn对象", description="标的出借回款记录表")
public class LendItemReturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标的还款id")
    @TableField("lend_return_id")
    private Long lendReturnId;

    @ApiModelProperty(value = "标的项id")
    @TableField("lend_item_id")
    private Long lendItemId;

    @ApiModelProperty(value = "标的id")
    @TableField("lend_id")
    private Long lendId;

    @ApiModelProperty(value = "出借用户id")
    @TableField("invest_user_id")
    private Long investUserId;

    @ApiModelProperty(value = "出借金额")
    @TableField("invest_amount")
    private BigDecimal investAmount;

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
