package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.SupportingApplication;
import untitled.domain.InventoryDecreased;
import untitled.domain.InventoryIncrease;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        InventoryDecreased inventoryDecreased = new InventoryDecreased(this);
        inventoryDecreased.publishAfterCommit();

        InventoryIncrease inventoryIncrease = new InventoryIncrease(this);
        inventoryIncrease.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = SupportingApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void decreaseInventory(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        InventoryDecreased inventoryDecreased = new InventoryDecreased(inventory);
        inventoryDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            InventoryDecreased inventoryDecreased = new InventoryDecreased(inventory);
            inventoryDecreased.publishAfterCommit();

         });
        */

    }

    public static void increaseInventory(DeliveryCancel deliveryCancel) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        InventoryIncrease inventoryIncrease = new InventoryIncrease(inventory);
        inventoryIncrease.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancel.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            InventoryIncrease inventoryIncrease = new InventoryIncrease(inventory);
            inventoryIncrease.publishAfterCommit();

         });
        */

    }
}
