package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCancel extends AbstractEvent {

    private Long id;

    public DeliveryCancel(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCancel() {
        super();
    }
}
