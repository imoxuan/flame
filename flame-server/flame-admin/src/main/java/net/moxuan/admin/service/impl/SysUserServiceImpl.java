package net.moxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.dto.SysUserDTO;
import net.moxuan.admin.service.SysUserService;
import net.moxuan.common.entity.SysUser;
import net.moxuan.common.manager.SysUserManager;
import net.moxuan.common.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserManager userManager;

    @Resource
    private MapperFactory mapperFactory;

    @Override
    public int deleteBatch(String ids) {
        return userManager.deleteBatch(StringUtil.stringToList(ids));
    }

    @Override
    public int deleteById(String id) {
        return userManager.deleteById(id);
    }

    @Override
    public IPage<SysUserDTO> page(IPage<SysUserDTO> page, Wrapper<SysUserDTO> queryWrapper) {
        SysUser org = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysUser.class);

        Page<SysUser> pageUser = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysUser> list = userManager.queryPage(pageUser, org);

        this.pojoToDto(list, page);
        return page;
    }

    @Override
    public long save(SysUserDTO dto) {
        SysUser user = mapperFactory.getMapperFacade().map(dto, SysUser.class);
        // TODO SET ORG_ID
        user.setOrgId(1309670702161559554L);
        user.setGmtCreate(LocalDateTime.now());
        user.setGmtModified(LocalDateTime.now());
        user.setEnabled(true);
        user.setDeleted(false);
        userManager.save(user);

        if (log.isInfoEnabled()) {
            log.info("新增用户：{}", user);
        }

        return user.getId();
    }

    @Override
    public int update(SysUserDTO dto) {
        SysUser user = mapperFactory.getMapperFacade().map(dto, SysUser.class);
        return userManager.updateById(user);
    }

    @Override
    public SysUser queryById(String id) {
        return userManager.selectById(id);
    }

    private void pojoToDto(IPage<SysUser> list, IPage<SysUserDTO> page) {
        if (list != null && list.getSize() > 0) {
            List<SysUserDTO> dots = new ArrayList<>();

            List<SysUser> records = list.getRecords();

            for (SysUser user : records) {
                SysUserDTO dto = mapperFactory.getMapperFacade().map(user, SysUserDTO.class);
                dots.add(dto);
            }
            page.setTotal(list.getTotal());
            page.setSize(list.getSize());
            page.setRecords(dots);

        }
    }
}
