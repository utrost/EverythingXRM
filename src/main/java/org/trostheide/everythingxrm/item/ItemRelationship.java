package org.trostheide.everythingxrm.item;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.trostheide.everythingxrm.entity.StandardEntity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "XRM_ITEM_RELATIONSHIP", indexes = {
        @Index(name = "IDX_ITEMRELATIONSHIP_ITEM1_ID", columnList = "ITEM1_ID"),
        @Index(name = "IDX_ITEMRELATIONSHIP_ITEM2_ID", columnList = "ITEM2_ID"),
        @Index(name = "IDX_ITEMRELATIONSHIP", columnList = "INVERSE_RELATIONSHIP_ID"),
        @Index(name = "IDX_ITEMRELATIONSHIP", columnList = "ITEM_RELATIONSHIP_CLASSIFICATION_ID")
})
@Entity(name = "xrm_ItemRelationship")
public class ItemRelationship extends StandardEntity {
    @JoinColumn(name = "ITEM1_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Item item1;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "ITEM_RELATIONSHIP_CLASSIFICATION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemRelationshipClassification itemRelationshipClassification;

    @JoinColumn(name = "ITEM2_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Item item2;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "INVERSE_RELATIONSHIP_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private ItemRelationship inverseRelationship;

    @Column(name = "SYSTEM_CREATED")
    private Boolean systemCreated;

    public Boolean getSystemCreated() {
        return systemCreated;
    }

    public void setSystemCreated(Boolean systemCreated) {
        this.systemCreated = systemCreated;
    }

    public ItemRelationshipClassification getItemRelationshipClassification() {
        return itemRelationshipClassification;
    }

    public void setItemRelationshipClassification(ItemRelationshipClassification itemRelationshipClassification) {
        this.itemRelationshipClassification = itemRelationshipClassification;
    }

    public ItemRelationship getInverseRelationship() {
        return inverseRelationship;
    }

    public void setInverseRelationship(ItemRelationship inverseRelationship) {
        this.inverseRelationship = inverseRelationship;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }
}