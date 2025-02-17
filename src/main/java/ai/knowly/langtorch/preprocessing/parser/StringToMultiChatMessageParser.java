package ai.knowly.langtorch.preprocessing.parser;

import ai.knowly.langtorch.schema.chat.UserMessage;
import ai.knowly.langtorch.schema.text.MultiChatMessage;

public final class StringToMultiChatMessageParser implements Parser<String, MultiChatMessage> {

  private StringToMultiChatMessageParser() {
    super();
  }

  public static StringToMultiChatMessageParser create() {
    return new StringToMultiChatMessageParser();
  }

  @Override
  public MultiChatMessage parse(String content) {
    return MultiChatMessage.of(UserMessage.of(content));
  }
}
