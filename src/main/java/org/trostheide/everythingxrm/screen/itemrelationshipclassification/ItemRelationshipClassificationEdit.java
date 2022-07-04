package org.trostheide.everythingxrm.screen.itemrelationshipclassification;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.ItemRelationshipClassification;

@UiController("xrm_ItemRelationshipClassification.edit")
@UiDescriptor("item-relationship-classification-edit.xml")
@EditedEntityContainer("itemRelationshipClassificationDc")
public class ItemRelationshipClassificationEdit extends StandardEditor<ItemRelationshipClassification> {
}