package ai.knowly.langtorch.processor.llm.openai.service.schema.dto;

public class OpenAIHttpParseException extends RuntimeException {

  /** HTTP status code */
  public final int statusCode;

  /** OpenAI error code, for example "invalid_api_key" */
  public final String code;

  public final String param;

  /**
   * OpenAI error type, for example "invalid_request_error"
   * https://platform.openai.com/docs/guides/error-codes/python-library-error-types
   */
  public final String type;

  public OpenAIHttpParseException(OpenAIError error, Exception parent, int statusCode) {
    super(error.error.message, parent);
    this.statusCode = statusCode;
    this.code = error.error.code;
    this.param = error.error.param;
    this.type = error.error.type;
  }
}
