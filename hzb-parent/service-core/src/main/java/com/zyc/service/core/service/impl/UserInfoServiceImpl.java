package com.zyc.service.core.service.impl;

import com.zyc.service.core.entity.UserInfo;
import com.zyc.service.core.mapper.UserInfoMapper;
import com.zyc.service.core.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
