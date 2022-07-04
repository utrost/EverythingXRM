package org.trostheide.everythingxrm.screen.itemrelationship;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.ItemRelationship;

@UiController("xrm_ItemRelationship.edit")
@UiDescriptor("item-relationship-edit.xml")
@EditedEntityContainer("itemRelationshipDc")
public class ItemRelationshipEdit extends StandardEditor<ItemRelationship> {
}