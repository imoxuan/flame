package net.moxuan.service.impl;

import com.baidu.fsg.uid.UidGenerator;
import net.moxuan.utils.SqlHelper;
import net.moxuan.entity.SysOrganization;
import net.moxuan.mapper.SysOrganizationMapper;
import net.moxuan.service.SysOrganizationService;
import net.moxuan.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: moxuan
 * @description: 集团表 服务实现类
 */
@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {

    @Resource
    private SysOrganizationMapper organizationMapper;

    @Resource
    private UidGenerator uidGenerator;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SysOrganization> save(SysOrganization organization) {
        // TODO 判断名称是否存在
        // TODO 判断编码是否存在
        organization.setId(uidGenerator.getUID());
        organization.setGmtCreate(new Date());
        organization.setGmtModified(new Date());
        // return SqlHelper.retBoolean(organizationMapper.save(organization));
        return null;
    }
}
