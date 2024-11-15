package io.jdev.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unchecked")
class JSONUtilsTest {


  @Test
  void readFromNodeWithPaths() throws IOException {
    Map<String, Object> properties = JSONUtils.readFromNode("json_utils_test.json",
        new String[]{"gmail", "properties"}, Map.class);
    assertThat(properties).isNotNull();
    assertThat(properties.get("mail")).isNotNull().isInstanceOf(Map.class);

    Integer timeout = JSONUtils.readFromNode("json_utils_test.json",
        new String[]{"gmail", "properties", "mail", "smtp", "timeout"}, Integer.class);
    assertThat(timeout).isNotNull().isEqualTo(5000);

    Boolean startTlsEnabled = JSONUtils.readFromNode("json_utils_test.json",
        new String[]{"gmail", "properties", "mail", "smtp", "starttls.enable"}, Boolean.class);
    assertThat(startTlsEnabled).isNotNull().isEqualTo(true);
  }


}

