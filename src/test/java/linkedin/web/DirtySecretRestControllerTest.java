package linkedin.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DirtySecretRestController.class)
public class DirtySecretRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private DirtySecretsRepository repository;

  @Test
  public void shouldSaveSecrets() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.post("/dirty-secrets")
        .contentType("application/json")
        .content("{ \"name\": \"Paradiser\", \"secret\": \"Takes an oil bath every day\"}"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void shouldCountSecrets() throws Exception {
    System.out.println("Number of entries in repository: " + String.valueOf(repository.count()));
    ResultActions actions = this.mockMvc.perform(MockMvcRequestBuilders.get("/count"));
    ResultActions expectActions = actions.andExpect(MockMvcResultMatchers.status().isOk());
  }
}
