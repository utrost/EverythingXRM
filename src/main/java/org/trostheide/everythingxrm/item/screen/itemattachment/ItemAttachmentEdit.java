package org.trostheide.everythingxrm.item.screen.itemattachment;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.ItemAttachment;

@UiController("xrm_ItemAttachment.edit")
@UiDescriptor("item-attachment-edit.xml")
@EditedEntityContainer("itemAttachmentDc")
public class ItemAttachmentEdit extends StandardEditor<ItemAttachment> {
}