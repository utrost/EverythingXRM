package org.trostheide.everythingxrm.item.screen.itemcomment;

import io.jmix.ui.screen.*;
import org.trostheide.everythingxrm.item.ItemComment;

@UiController("xrm_ItemComment.edit")
@UiDescriptor("item-comment-edit.xml")
@EditedEntityContainer("itemCommentDc")
public class ItemCommentEdit extends StandardEditor<ItemComment> {
}