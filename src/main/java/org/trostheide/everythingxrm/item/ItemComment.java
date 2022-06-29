package org.trostheide.everythingxrm.item;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.trostheide.everythingxrm.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "XRM_ITEM_COMMENT", indexes = {
        @Index(name = "IDX_ITEMCOMMENT_ITEM_ID", columnList = "ITEM_ID")
})
@Entity(name = "xrm_ItemComment")
public class ItemComment extends StandardEntity {
    @InstanceName
    @Column(name = "TITLE", nullable = false)
    @NotNull
    private String title;

    @Column(name = "TEXT", nullable = false)
    @Lob
    @NotNull
    private String text;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}