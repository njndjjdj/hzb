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
 * 标的准备表
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lend")
@ApiModel(value="Lend对象", description="标的准备表")
public class Lend implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "借款用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "借款信息id")
    @TableField("borrow_info_id")
    private Long borrowInfoId;

    @ApiModelProperty(value = "标的编号")
    @TableField("lend_no")
    private String lendNo;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "标的金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "投资期数")
    @TableField("period")
    private Integer period;

    @ApiModelProperty(value = "年化利率")
    @TableField("lend_year_rate")
    private BigDecimal lendYearRate;

    @ApiModelProperty(value = "平台服务费率")
    @TableField("service_rate")
    private BigDecimal serviceRate;

    @ApiModelProperty(value = "还款方式")
    @TableField("return_method")
    private Integer returnMethod;

    @ApiModelProperty(value = "最低投资金额")
    @TableField("lowest_amount")
    private BigDecimal lowestAmount;

    @ApiModelProperty(value = "已投金额")
    @TableField("invest_amount")
    private BigDecimal investAmount;

    @ApiModelProperty(value = "投资人数")
    @TableField("invest_num")
    private Integer investNum;

    @ApiModelProperty(value = "发布日期")
    @TableField("publish_date")
    private LocalDateTime publishDate;

    @ApiModelProperty(value = "开始日期")
    @TableField("lend_start_date")
    private LocalDate lendStartDate;

    @ApiModelProperty(value = "结束日期")
    @TableField("lend_end_date")
    private LocalDate lendEndDate;

    @ApiModelProperty(value = "说明")
    @TableField("lend_info")
    private String lendInfo;

    @ApiModelProperty(value = "平台预期收益")
    @TableField("expect_amount")
    private BigDecimal expectAmount;

    @ApiModelProperty(value = "实际收益")
    @TableField("real_amount")
    private BigDecimal realAmount;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "审核时间")
    @TableField("check_time")
    private LocalDateTime checkTime;

    @ApiModelProperty(value = "审核用户id")
    @TableField("check_admin_id")
    private Long checkAdminId;

    @ApiModelProperty(value = "放款时间")
    @TableField("payment_time")
    private LocalDateTime paymentTime;

    @ApiModelProperty(value = "放款人id")
    @TableField("payment_admin_id")
    private LocalDateTime paymentAdminId;

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
