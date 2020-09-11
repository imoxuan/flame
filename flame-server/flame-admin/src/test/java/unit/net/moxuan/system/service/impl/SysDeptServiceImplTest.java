package unit.net.moxuan.system.service.impl;

import net.moxuan.admin.FlameApplication;
import net.moxuan.admin.service.impl.SysDeptServiceImpl;
import net.moxuan.common.dto.SysDeptDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: moxuan
 * @description:
 */
@SpringBootTest(classes = FlameApplication.class)
public class SysDeptServiceImplTest {

    @Resource
    private SysDeptServiceImpl deptService;

    @Test
    public void save() {
        long orgId = 1298178547300851713L;

        SysDeptDTO deptDTO = new SysDeptDTO();
        deptDTO.setOrgId(orgId);
        deptDTO.setPid(1302946997892943873L);
        deptDTO.setName("部1-1");
        deptDTO.setCode("B1-1");
        deptDTO.setSortNo(1);
        deptDTO.setPath("10011001");

        int count = deptService.save(deptDTO);

    }

}
