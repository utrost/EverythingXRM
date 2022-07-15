package org.trostheide.everythingxrm.item;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.dynattr.model.Categorized;
import io.jmix.dynattr.model.Category;
import org.trostheide.everythingxrm.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@JmixEntity
@Table(name = "XRM_ITEM", indexes = {
        @Index(name = "IDX_ITEM_CATEGORY_ID", columnList = "CATEGORY_ID")
})
@Entity(name = "xrm_Item")
public class Item extends StandardEntity implements Categorized {
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "item")
    private List<ItemAttachment> attachments;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "item1")
    private List<ItemRelationship> item1Relationship;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "item2")
    private List<ItemRelationship> item2Relationship;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "item")
    private List<ItemComment> comments;

    @JoinColumn(name = "CATEGORY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public List<ItemAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ItemAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<ItemRelationship> getItem2Relationship() {
        return item2Relationship;
    }

    public void setItem2Relationship(List<ItemRelationship> item2Relationship) {
        this.item2Relationship = item2Relationship;
    }

    public List<ItemRelationship> getItem1Relationship() {
        return item1Relationship;
    }

    public void setItem1Relationship(List<ItemRelationship> item1Relationship) {
        this.item1Relationship = item1Relationship;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ItemComment> getComments() {
        return comments;
    }

    public void setComments(List<ItemComment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DependsOnProperties({"name"})
    public String getInstanceName(){
        return String.format("%s", name);

    }

}