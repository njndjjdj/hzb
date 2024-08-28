package com.zyc.service.core.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.zyc.common.exception.BusinessException;
import com.zyc.common.result.R;
import com.zyc.common.result.ResponseEnum;
import com.zyc.service.core.pojo.dto.ExcelDictDTO;
import com.zyc.service.core.service.IDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

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
@RestController("adminDictController")
@RequestMapping("/admin/core/dict")
@Api(tags = "数据字典相关接口")
public class AdminDictController {

    @Resource
    private IDictService dictService;

    @GetMapping("/upload")
    @ApiOperation("上传excel文件并保存至数据库")
    public R upload(MultipartFile file) {
        dictService.upload(file);
        return R.ok().message("数据上传成功");
    }

    @GetMapping("/export")
    @ApiOperation("excel文件下载接口")
    public void export(HttpServletResponse response) {
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("mydict", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), ExcelDictDTO.class).sheet("数据字典").doWrite(dictService.listDictData());
        } catch (IOException e) {
            // EXPORT_DATA_ERROR(104, "数据导出失败"),
            throw new BusinessException(ResponseEnum.EXPORT_DATA_ERROR, e);
        }
    }

    @GetMapping("/listByParentId/{pid}")
    @ApiOperation("根据父节点id查找子节点")
    public R listByParentId(@PathVariable("pid") Integer pid) {
        return R.ok().data("list",dictService.listByParentId(pid));
    }
}
