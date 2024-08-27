package com.zyc.service.core.service.impl;

import com.zyc.service.core.entity.UserAccount;
import com.zyc.service.core.mapper.UserAccountMapper;
import com.zyc.service.core.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-27
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
