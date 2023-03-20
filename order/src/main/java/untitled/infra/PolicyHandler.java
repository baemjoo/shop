package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InventoryIncrease'"
    )
    public void wheneverInventoryIncrease_AlertCustomer(
        @Payload InventoryIncrease inventoryIncrease
    ) {
        InventoryIncrease event = inventoryIncrease;
        System.out.println(
            "\n\n##### listener AlertCustomer : " + inventoryIncrease + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_UpdateInventory(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener UpdateInventory : " + deliveryStarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCancel'"
    )
    public void wheneverDeliveryCancel_UpdateInventory(
        @Payload DeliveryCancel deliveryCancel
    ) {
        DeliveryCancel event = deliveryCancel;
        System.out.println(
            "\n\n##### listener UpdateInventory : " + deliveryCancel + "\n\n"
        );
        // Sample Logic //

    }
}
