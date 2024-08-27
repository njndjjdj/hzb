package com.zyc.service.core.controller.admin;

import com.zyc.common.result.R;
import com.zyc.service.core.entity.IntegralGrade;
import com.zyc.service.core.service.IIntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/27
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@RestController("adminIntegralGradeController")
@RequestMapping("/admin/core/integralGrade")
@Api(tags = "积分等级管理接口")
public class AdminIntegralGradeController {

    @Resource
    private IIntegralGradeService integralGradeService;

    @GetMapping("/list")
    @ApiOperation("查询所有积分等级")
    public R listAll() {
        return R.ok().data("list", integralGradeService.list());
    }

    @GetMapping("/findById/{id}")
    @ApiOperation("根据id查询积分等级")
    public R findById(@PathVariable("id") Long id) {
        return R.ok().data("integralGrade", integralGradeService.getById(id));
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("根据i当删除疾风等级")
    public R removeById(@PathVariable("id") Long id) {
        integralGradeService.removeById(id);
        return R.ok();
    }

    @PostMapping("/add")
    @ApiOperation("新增积分等级")
    public R save(@RequestBody IntegralGrade integralGrade) {
        integralGradeService.save(integralGrade);
        return R.ok();
    }

    @PutMapping("/update")
    @ApiOperation("修改积分等级")
    public R update(@RequestBody IntegralGrade integralGrade) {
        integralGradeService.updateById(integralGrade);
        return R.ok();
    }
}
