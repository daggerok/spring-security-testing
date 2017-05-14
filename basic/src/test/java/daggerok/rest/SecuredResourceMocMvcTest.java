package daggerok.rest;

import daggerok.SecuredAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SecuredResource.class)
@AutoConfigureRestDocs("build/generated-snippets")
@ContextConfiguration(classes = SecuredAppApplication.class)
public class SecuredResourceMocMvcTest {

  @Autowired
  MockMvc mvc;

  @Test
  @WithMockUser
  public void securedMethodUsingMvc() throws Exception {

    mvc.perform(get("/").secure(true))
       .andExpect(status().isOk())
       .andDo(document("mvc-test"));
  }
}
