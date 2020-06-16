package net.moxuan.system;

import com.baidu.fsg.uid.UidGenerator;
import junit.framework.TestCase;
import net.moxuan.system.mapper.SysOrganizationMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: moxuan
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest extends TestCase {

    @Resource
    private SysOrganizationMapper sysOrgMapper;

    @Resource
    UidGenerator uidGenerator;

    @Test
    public void selectData() {
        int count = sysOrgMapper.total();
        Assert.assertEquals(0, count);
        System.out.println("=====================" + count);
        System.out.println(uidGenerator.getUID());


        //userList.forEach(System.out::println);*/
    }
}
