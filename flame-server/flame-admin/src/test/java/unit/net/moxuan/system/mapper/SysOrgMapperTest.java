package unit.net.moxuan.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.FlameApplication;
import net.moxuan.entity.SysOrg;
import net.moxuan.mapper.SysOrgMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FlameApplication.class)
public class SysOrgMapperTest {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Autowired
    private MapperFactory mapperFactory;

    @Test
    void queryOrgByCode() {
    }

    @Test
    void queryOrgByName() {
    }

    @Test
    void save() {
    }

    @Test
    void queryAllTest() {
        SysOrg org = new SysOrg();
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysOrg> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(SysOrg::getId, SysOrg::getName, SysOrg::getEnabled);
        wrapper.select("id", "name", "is_enabled");
        List<SysOrg> list = sysOrgMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    void selectPage() {
        /*SysOrgDTO dto = new SysOrgDTO();
        Page<SysOrgDTO> dtoPage = new Page<>(1, 10);
        Wrapper<SysOrgDTO> queryWrapper = new QueryWrapper<>(dto);

        Page<SysOrg> pageOrg = new Page<>(1, 10);
        SysOrg org = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysOrg.class);
        // SysOrganization org = new SysOrganization();
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<>(org);
        IPage<SysOrg> list = sysOrgMapper.selectPage(pageOrg, wrapper);
        System.out.println(list);*/
    }

    @Test
    void deleteBatch() {
    }

    @Test
    void delete() {
        long id = 1295228380688388097L;
        int count = sysOrgMapper.deleteById(id);
        System.out.println(count);
    }


}