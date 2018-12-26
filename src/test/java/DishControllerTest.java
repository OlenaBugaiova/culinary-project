import com.olenabugaiova.tasteit.TasteItBootApplication;
import com.olenabugaiova.tasteit.dao.IDishDAO;
import com.olenabugaiova.tasteit.formatter.DimensionFormatter;
import com.olenabugaiova.tasteit.formatter.IngredientFormatter;
import com.olenabugaiova.tasteit.model.Dish;
import com.olenabugaiova.tasteit.model.DishCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by elena on 23/12/18.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = TasteItBootApplication.class)
public class DishControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private IDishDAO dishDAO;

    @MockBean
    private IngredientFormatter ingredientFormatter;

    @MockBean
    private DimensionFormatter dimensionFormatter;

    @Test
    public void whenGetDishesByCategory_thenTestListSize_ReturnTrue() {
        //  create dish category
        DishCategory dishCategory = new DishCategory();
        dishCategory.setCategoryName("Tasty");

        entityManager.persist(dishCategory);
        entityManager.flush();

        // given
        Dish dishTest1 = new Dish();
        dishTest1.setName("Fish soup");
        dishTest1.setRecipe("Default recipe");
        dishTest1.setCategory(dishCategory);

        entityManager.persist(dishTest1);
        entityManager.flush();

        Dish dishTest2 = new Dish();
        dishTest2.setName("Pasta");
        dishTest2.setRecipe("Default recipe");
        dishTest2.setCategory(dishCategory);

        entityManager.persist(dishTest2);
        entityManager.flush();

        // when
        List<Dish> found = dishDAO.getDishesByCategory(dishCategory);

        // then
        assertThat(found.size()).isEqualTo(2);
    }
}
