package unit.net.moxuan.system.controller;

import net.moxuan.admin.FlameApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author: moxuan
 * @description:
 */
@SpringBootTest(classes = FlameApplication.class)
@AutoConfigureMockMvc
public class SysOrgControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void queryPage() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/sys/org/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
