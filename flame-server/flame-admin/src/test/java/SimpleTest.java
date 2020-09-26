import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.FlameApplication;
import net.moxuan.admin.dto.SysOrgDTO;
import net.moxuan.common.entity.SysOrg;
import net.moxuan.common.manager.SysDictManager;
import net.moxuan.common.util.StringUtil;
import net.moxuan.common.vo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@SpringBootTest(classes = FlameApplication.class)
public class SimpleTest {
    @Resource
    private SysDictManager dictManager;

    @Resource
    private MapperFactory mapperFactory;

    @Test
    public void test() {
        String a = "a,,c";
        List<String> b = StringUtil.stringToList(a, ",");
        System.out.println(b);

        List<SysOrgDTO> list;
        List<SysOrg> orgList = new ArrayList<>();
        list = mapperFactory.getMapperFacade().mapAsList(orgList, SysOrgDTO.class);
        System.out.println(Result.success(list));
    }
}
