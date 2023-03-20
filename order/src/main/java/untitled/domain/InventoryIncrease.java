package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class InventoryIncrease extends AbstractEvent {

    private Long id;
}
