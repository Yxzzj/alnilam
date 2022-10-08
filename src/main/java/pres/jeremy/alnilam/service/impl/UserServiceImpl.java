package pres.jeremy.alnilam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pres.jeremy.alnilam.entity.User;
import pres.jeremy.alnilam.mapper.UserMapper;
import pres.jeremy.alnilam.service.UserService;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
