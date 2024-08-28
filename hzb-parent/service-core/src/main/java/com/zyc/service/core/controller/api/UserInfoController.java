package com.zyc.service.core.controller.api;

import com.zyc.common.result.R;
import com.zyc.service.core.pojo.entity.UserInfo;
import com.zyc.service.core.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController("userInfoController")
@Api(tags = "用户相关接口")
@RequestMapping("/api/core/user")
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;

    @GetMapping("/findAllUser")
    @ApiOperation("查询所有用户")
    public R findAllUser() {
        List<UserInfo> list = userInfoService.list();
        return R.ok().data("list", list);
    }
}
