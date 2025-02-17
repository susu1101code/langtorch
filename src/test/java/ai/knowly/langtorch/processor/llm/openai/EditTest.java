package ai.knowly.langtorch.processor.llm.openai;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ai.knowly.langtorch.processor.llm.openai.service.OpenAIService;
import ai.knowly.langtorch.processor.llm.openai.service.schema.dto.OpenAIHttpParseException;
import ai.knowly.langtorch.processor.llm.openai.service.schema.dto.edit.EditRequest;
import ai.knowly.langtorch.processor.llm.openai.service.schema.dto.edit.EditResult;
import ai.knowly.langtorch.utils.ApiKeyUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

@EnabledIf("ai.knowly.langtorch.TestingUtils#testWithHttpRequestEnabled")
class EditTest {

  @Test
  void edit() throws OpenAIHttpParseException {
    String token = ApiKeyUtils.getOpenAIApiKeyFromEnv();
    OpenAIService service = new OpenAIService(token);
    EditRequest request =
        EditRequest.builder()
            .model("text-davinci-edit-001")
            .input("What day of the wek is it?")
            .instruction("Fix the spelling mistakes")
            .build();

    EditResult result = service.createEdit(request);
    assertNotNull(result.getChoices().get(0).getText());
  }
}
