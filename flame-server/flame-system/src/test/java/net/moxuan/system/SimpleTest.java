package net.moxuan.system;

import com.baidu.fsg.uid.UidGenerator;
import net.moxuan.entity.SysOrganization;
import net.moxuan.mapper.SysOrganizationMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: moxuan
 * @description:
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SimpleTest {

    @Resource
    private SysOrganizationMapper sysOrgMapper;

    @Resource
    UidGenerator uidGenerator;

    @Test
    public void selectData() {
        //int count = sysOrgMapper.total();
        //Assert.assertEquals(0, count);
        //System.out.println("=====================" + count);
        //System.out.println(uidGenerator.getUID());


        //userList.forEach(System.out::println);*/
    }

    @Test
    @DisplayName("新增集团信息")
    public void insertData() {
        SysOrganization organization = new SysOrganization();
        organization.setId(uidGenerator.getUID());
        organization.setName("新元集团");
        organization.setShortName("新元");
        organization.setCode("xinyuan");
        organization.setGmtCreate(new Date());
        organization.setGmtModified(new Date());
        //int count = sysOrgMapper.addSysOrganization(organization);
       // Assertions.assertEquals(1, count);
    }
}
