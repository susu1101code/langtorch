package ai.knowly.langtorch.processor.llm.openai.service.schema.dto.edit;

import ai.knowly.langtorch.processor.llm.openai.service.schema.dto.Usage;
import java.util.List;
import lombok.Data;

/**
 * A list of edits generated by OpenAI
 *
 * <p>https://beta.openai.com/docs/api-reference/edits/create
 */
@Data
public class EditResult {

  /** The type of object returned, should be "edit" */
  public String object;

  /** The creation time in epoch milliseconds. */
  public long created;

  /** A list of generated edits. */
  public List<EditChoice> choices;

  /** The API usage for this request */
  public Usage usage;
}
