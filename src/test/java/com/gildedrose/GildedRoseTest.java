package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Test
    void itemNameNeverChange() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void itemQualityDecreaseBeforeSellByDate() {
        Item[] items = new Item[]{new Item("foo", 5, 3)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void itemQualityDecreaseDoubleAfterSellByDate() {
        int originalQuality = 3;

        Item[] items = new Item[]{
            new Item("foo", 2, originalQuality),
            new Item("foo", -2, originalQuality)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(originalQuality - app.items[1].quality, (originalQuality - app.items[0].quality) * 2);
    }

    @Test
    void itemQualityNeverNegative() {
        Item[] items = new Item[]{new Item("foo", -2, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void itemQualityNeverMoreThan50() {
        Item[] items = new Item[]{
            new Item(AGED_BRIE, -2, 49),
            new Item(BACKSTAGE_PASSES, 20, 49)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();


        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    void itemSellInDecrease() {
        Item[] items = new Item[]{new Item("foo", 5, 3)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void agedBrieQualityIncreaseByOne() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 20, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    void agedBrieQualityIncreaseByTwo() {
        Item[] items = new Item[]{new Item(AGED_BRIE, -2, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreaseByOne() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 20, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreaseByTwo() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 8, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreaseByThree() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 3, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityZeroAfterConcert() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 1, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sulfurasQualityStay80() {
        Item[] items = new Item[]{new Item(SULFURAS, 1, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasSellInNeverChange() {
        Item[] items = new Item[]{new Item(SULFURAS, 12, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals(12, app.items[0].sellIn);
    }

    @Test
    void conjuredDegradeTwiceAsFast() {
        int origQuality = 40;

        Item[] items = new Item[]{
            new Item(CONJURED, 12, origQuality),
            new Item(CONJURED, -2, origQuality)
        };

        Item[] items2 = new Item[]{
            new Item("foo", 12, origQuality),
            new Item("foo", -2, origQuality)
        };

        GildedRose app = new GildedRose(items);
        GildedRose app2 = new GildedRose(items2);

        app.updateQuality();
        app2.updateQuality();


        assertEquals((origQuality - app2.items[0].quality) * 2, origQuality - app.items[0].quality);
        assertEquals((origQuality - app2.items[1].quality) * 2, origQuality - app.items[1].quality);

    }

    @Test
    void TestToString() {
        Item[] items = new Item[]{new Item(SULFURAS, 12, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertNotEquals("", items[0].toString());
    }
}
