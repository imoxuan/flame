import net.moxuan.admin.FlameApplication;
import net.moxuan.common.manager.SysDictManager;
import net.moxuan.common.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@SpringBootTest(classes = FlameApplication.class)
public class SimpleTest {
    @Resource
    private SysDictManager dictManager;

    @Test
    public void test() {
        String a = "a,,c";
        List<String> b = StringUtil.stringToList(a, ",");
        System.out.println(b);
    }
}
