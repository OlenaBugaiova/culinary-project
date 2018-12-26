package integration;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by elena on 26/12/18.
 */

public class IngredientDetailsControllerIntegrationTest extends AbstractIntegrationTest{

    @Test
    public void shouldStartWebApplicationContext() {
        assertThat(context).isNotNull();
    }
}
