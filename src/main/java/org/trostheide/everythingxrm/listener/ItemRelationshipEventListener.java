package org.trostheide.everythingxrm.listener;

import io.jmix.core.SaveContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.trostheide.everythingxrm.item.Item;
import org.trostheide.everythingxrm.item.ItemRelationship;
import io.jmix.core.event.EntityChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import io.jmix.core.DataManager;
import org.trostheide.everythingxrm.item.ItemRelationshipClassification;

import javax.inject.Inject;

@Component("xrm_ItemRelationshipEventListener")
public class ItemRelationshipEventListener {

    @Autowired
    private DataManager dataManager ;

    @Autowired
    private DataManager dataManager2 ;

    @EventListener
    public void onItemRelationshipChangedBeforeCommit(EntityChangedEvent<ItemRelationship> event) {

        if (event.getType() == EntityChangedEvent.Type.CREATED) {
            ItemRelationship currentRelationship = dataManager.load(event.getEntityId()).one();

            Item item1= currentRelationship.getItem1();
            Item item2= currentRelationship.getItem2();
            ItemRelationshipClassification currentRealtionshipClassification = currentRelationship.getItemRelationshipClassification();
            Boolean systemCreated = currentRelationship.getSystemCreated();

            if (systemCreated == null || !systemCreated) {
                ItemRelationship newRelationship = dataManager2.create(ItemRelationship.class);

                newRelationship.setItem1(item2);
                newRelationship.setItem2(item1);
                newRelationship.setItemRelationshipClassification(currentRealtionshipClassification.getReverseRelationshipCategory());
                newRelationship.setInverseRelationship(currentRelationship);
                newRelationship.setSystemCreated(true);

                System.out.println("New relationship has Item1: " + newRelationship.getItem1().getName());
                System.out.println("New relationship has Item2: " + newRelationship.getItem2().getName());
                System.out.println("New relationship has relationship: " + newRelationship.getItemRelationshipClassification().getName());


                dataManager2.save(newRelationship);

                currentRelationship.setInverseRelationship(newRelationship);
                dataManager.save(currentRelationship);
            }


        }

    }
}