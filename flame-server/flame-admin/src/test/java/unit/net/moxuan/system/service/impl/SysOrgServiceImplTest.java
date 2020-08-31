package unit.net.moxuan.system.service.impl;

import net.moxuan.admin.FlameApplication;
import net.moxuan.common.dto.SysOrgDTO;
import net.moxuan.service.SysOrgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@SpringBootTest(classes = FlameApplication.class)
public class SysOrgServiceImplTest {

    @Autowired
    private SysOrgService orgService;

    @Test
    public void queryTest() {
        List<SysOrgDTO> list = orgService.queryAll();
        System.out.println(list);
    }
}
