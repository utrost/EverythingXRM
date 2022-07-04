package org.trostheide.everythingxrm.screen.itemrelationshipclassification;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.ItemRelationshipClassification;

@UiController("xrm_ItemRelationshipClassification.browse")
@UiDescriptor("item-relationship-classification-browse.xml")
@LookupComponent("itemRelationshipClassificationsTable")
public class ItemRelationshipClassificationBrowse extends StandardLookup<ItemRelationshipClassification> {
}