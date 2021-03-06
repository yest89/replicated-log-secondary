package ua.edu.ucu.open;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {

  @Autowired
  private ReplicatedLogClient replicatedLogClient;

  @Test
  public void testStoreLog() {
    assertThat(replicatedLogClient.storeLog("Test"))
    .isEqualTo("ACK");
  }
}
