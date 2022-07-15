package org.trostheide.everythingxrm.item.screen;

import io.jmix.ui.UiComponents;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.LinkButton;
import io.jmix.ui.component.Table;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.trostheide.everythingxrm.item.Item;
import org.trostheide.everythingxrm.item.ItemAttachment;

@UiController("xrm_Item.edit")
@UiDescriptor("item-edit.xml")
@EditedEntityContainer("itemDc")
public class ItemEdit extends StandardEditor<Item> {

    @Autowired
    private UiComponents uiComponents;
    @Autowired
    private Downloader downloader;

    @Install(to = "attachmentsTable.fileName", subject = "columnGenerator")
    private Component attachmentsTableFileColumnGenerator(ItemAttachment attachment) {
        if (attachment.getFile() != null) {
            LinkButton linkButton = uiComponents.create(LinkButton.class);
            linkButton.setAction(new BaseAction("download")
                    .withCaption(attachment.getFile().getFileName())
                    .withHandler(actionPerformedEvent ->
                            downloader.download(attachment.getFile())
                    )
            );
            return linkButton;
        } else {
            return new Table.PlainTextCell("<empty>");
        }
    }

}