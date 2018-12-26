package integration;

import com.olenabugaiova.tasteit.TasteItBootApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by elena on 26/12/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = TasteItBootApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class AbstractIntegrationTest {

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    protected MockMvc mvc;
}
