package org.trostheide.everythingxrm.screen.itemrelationship;

import io.jmix.dynattr.model.Category;
import io.jmix.ui.component.EntityComboBox;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.trostheide.everythingxrm.item.Item;
import org.trostheide.everythingxrm.item.ItemRelationship;
import org.trostheide.everythingxrm.item.ItemRelationshipClassification;


@UiController("xrm_ItemRelationship.edit")
@UiDescriptor("item-relationship-edit.xml")
@EditedEntityContainer("itemRelationshipDc")
public class ItemRelationshipEdit extends StandardEditor<ItemRelationship> {

    @Autowired
    private EntityComboBox<ItemRelationshipClassification> itemRelationshipClassificationField;

    @Autowired
    private CollectionLoader<ItemRelationshipClassification> itemRelationshipClassificationsDl;

    @Subscribe("item1Field")
    public void onItem1FieldValueChange(HasValue.ValueChangeEvent<Item> event) {
        System.out.println("Item 1 has changed!");
        //itemRelationshipClassificationField.setValue(null);
        addItemCategoryParameter(event, "item1Category");
        refreshClassificationLookup();
    }

    @Subscribe("item2Field")
    public void onItem2FieldValueChange(HasValue.ValueChangeEvent<Item> event) {
        System.out.println("Item 2 has changed!");
        //itemRelationshipClassificationField.setValue(null);
        addItemCategoryParameter(event, "item2Category");
        refreshClassificationLookup();
    }

    private void addItemCategoryParameter(HasValue.ValueChangeEvent<Item> event, String parameterName) {
        itemRelationshipClassificationsDl.setParameter(parameterName, event.getValue());

    }

    private void addObjectCategoryParameter(Category cat, String parameterName) {
        itemRelationshipClassificationsDl.setParameter(parameterName, cat);

    }

    private void refreshClassificationLookup() {

        if (getEditedEntity().getItem1() != null) {
            addObjectCategoryParameter(getEditedEntity().getItem1().getCategory(), "item1Category");
        }

        if (getEditedEntity().getItem2() != null) {
            addObjectCategoryParameter(getEditedEntity().getItem2().getCategory(), "item2Category");
        }


        if (getEditedEntity().getItem1() != null && getEditedEntity().getItem2() != null) {
            itemRelationshipClassificationField.setValue(null);
            itemRelationshipClassificationsDl.load();
        }
    }
}