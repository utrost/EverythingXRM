package org.trostheide.everythingxrm.item.screen;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.Item;

@UiController("xrm_Item.edit")
@UiDescriptor("item-edit.xml")
@EditedEntityContainer("itemDc")
public class ItemEdit extends StandardEditor<Item> {
}