package org.trostheide.everythingxrm.item;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.dynattr.model.Category;
import org.trostheide.everythingxrm.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "XRM_ITEM_RELATIONSHIP_CLASSIFICATION", indexes = {
        @Index(name = "IDX_ITEMRELATIONSHIPCLASSIFICATION", columnList = "ITEM1_CATEGORY_ID"),
        @Index(name = "IDX_ITEMRELATIONSHIPCLASSIFICATION", columnList = "ITEM2_CATEGORY_ID"),
        @Index(name = "IDX_ITEMRELATIONSHIPCLASSIFICATION", columnList = "REVERSE_RELATIONSHIP_CATEGORY_ID")
})
@Entity(name = "xrm_ItemRelationshipClassification")
public class ItemRelationshipClassification extends StandardEntity {
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "REVERSE_")
    private String reverse;

    @JoinColumn(name = "ITEM1_CATEGORY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category item1Category;

    @JoinColumn(name = "ITEM2_CATEGORY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category item2Category;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "REVERSE_RELATIONSHIP_CATEGORY_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private ItemRelationshipClassification reverseRelationshipCategory;

    public String getReverse() {
        return reverse;
    }

    public void setReverse(String reverse) {
        this.reverse = reverse;
    }

    public ItemRelationshipClassification getReverseRelationshipCategory() {
        return reverseRelationshipCategory;
    }

    public void setReverseRelationshipCategory(ItemRelationshipClassification reverseRelationshipCategory) {
        this.reverseRelationshipCategory = reverseRelationshipCategory;
    }

    public Category getItem2Category() {
        return item2Category;
    }

    public void setItem2Category(Category item2Category) {
        this.item2Category = item2Category;
    }

    public Category getItem1Category() {
        return item1Category;
    }

    public void setItem1Category(Category item1Category) {
        this.item1Category = item1Category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}