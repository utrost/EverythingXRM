package org.trostheide.everythingxrm.item;

import io.jmix.core.FileRef;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.trostheide.everythingxrm.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "XRM_ITEM_ATTACHMENT", indexes = {
        @Index(name = "IDX_XRM_ITEM_ATTACHMENT_ITEM", columnList = "ITEM_ID")
})
@Entity(name = "xrm_ItemAttachment")
public class ItemAttachment extends StandardEntity {
    @JoinColumn(name = "ITEM_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Item item;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "FILE_", length = 1024)
    private FileRef file;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public FileRef getFile() {
        return file;
    }

    public void setFile(FileRef file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}