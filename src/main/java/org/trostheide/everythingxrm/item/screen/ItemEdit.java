package org.trostheide.everythingxrm.item.screen;

import io.jmix.core.FileRef;
import io.jmix.ui.Notifications;
import io.jmix.ui.UiComponents;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.*;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.screen.*;
import io.jmix.ui.upload.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.trostheide.everythingxrm.item.Item;

import java.io.File;
import java.util.Map;
import java.util.UUID;

@UiController("xrm_Item.edit")
@UiDescriptor("item-edit.xml")
@EditedEntityContainer("itemDc")
public class ItemEdit extends StandardEditor<Item> {
    @Autowired
    private FileMultiUploadField fileMultiUploadField;
    @Autowired
    private TemporaryStorage temporaryStorage;
    @Autowired
    private Notifications notifications;

    @Subscribe
    public void onInit(InitEvent event) {

        fileMultiUploadField.addQueueUploadCompleteListener(queueUploadCompleteEvent -> {
            for (Map.Entry<UUID, String> entry : fileMultiUploadField.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileRef fileRef = temporaryStorage.putFileIntoStorage(fileId, fileName);
            }
            notifications.create()
                    .withCaption("Uploaded files: " + fileMultiUploadField.getUploadsMap().values())
                    .show();
            fileMultiUploadField.clearUploads();
        });
        fileMultiUploadField.addFileUploadErrorListener(queueFileUploadErrorEvent ->
                notifications.create()
                        .withCaption("File upload error")
                        .show());
    }

}