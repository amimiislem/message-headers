package com.memorynotfound.kafka;

import com.memorynotfound.kafka.consumer.Listener;
import com.memorynotfound.kafka.producer.Sender;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringKafkaApplicationTest {

    private static final String FOO_TOPIC = "foo.t";

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, FOO_TOPIC);

    @Autowired
    private Listener listener;

    @Autowired
    private Sender sender;

    @Test
    public void testReceive() throws Exception {
        sender.sendFoo("Hello Spring Kafka!");
    }

}
