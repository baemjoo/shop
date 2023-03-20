package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class OrderCancel extends AbstractEvent {

    private Long id;

    public OrderCancel(Order aggregate) {
        super(aggregate);
    }

    public OrderCancel() {
        super();
    }
}
