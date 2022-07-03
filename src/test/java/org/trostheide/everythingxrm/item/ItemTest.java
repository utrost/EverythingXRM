package org.trostheide.everythingxrm.item;

import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ItemIntegrationTest {

    @Autowired
    DataManager dataManager;

    @Autowired
    SystemAuthenticator systemAuthenticator;

    @Autowired
    Validator validator;



    @Test
    void given_valid_item_when_saveItem_then_itemIsSaved() {

        // given
        Item item = dataManager.create(Item.class);

        item.setName("IntegrationTestItem");
        item.setDescription("This is a Description");

        //when
       Item savedItem =  systemAuthenticator.withSystem(() -> dataManager.save(item));

        //then
        assertThat(savedItem.getId()).isNotNull();

    }

    @Test
    void given_itemWithMissingName_when_validateItem_then_itemIsInvalid() {

        // given
        Item item = dataManager.create(Item.class);

        // item name is mandatory. therefore to test if its working i'll set it to null. ValidationViolation shall be caught then
        item.setName(null);
        item.setDescription("This is a Description");

        //when
        Set<ConstraintViolation<Item>> violations = validator.validate(item, Default.class);

        //then
        assertThat(violations).hasSize(1);

    }


}