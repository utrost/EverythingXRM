package org.trostheide.everythingxrm.item.screen;


import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.Item;


@UiController("xrm_Item.browse")
@UiDescriptor("item-browse.xml")
@LookupComponent("itemsTable")
public class ItemBrowse extends StandardLookup<Item> {


}