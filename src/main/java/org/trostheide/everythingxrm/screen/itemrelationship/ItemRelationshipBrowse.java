package org.trostheide.everythingxrm.screen.itemrelationship;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.ItemRelationship;

@UiController("xrm_ItemRelationship.browse")
@UiDescriptor("item-relationship-browse.xml")
@LookupComponent("itemRelationshipsTable")
public class ItemRelationshipBrowse extends StandardLookup<ItemRelationship> {
}