package org.trostheide.everythingxrm.item;

import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ItemIntegrationTest {

    @Autowired
    DataManager dataManager;

    @Autowired
    SystemAuthenticator systemAuthenticator;

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


}