package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenNormalItem_whenUpdateQuality_thenQualityAndSellInDecrease() {
        final Item item = new Item("Normal item", 3, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(2, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    void givenMultipleNormalItems_whenUpdateQuality_thenQualityAndSellInDecrease() {
        final Item item1 = new Item("Normal item 1", 5, 8);
        final Item item2 = new Item("Normal item 2", 10, 10);
        final Item item3 = new Item("Normal item 3", 2, 30);
        Item[] items = new Item[]{item1, item2, item3};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(4, item1.sellIn);
        assertEquals(7, item1.quality);
        assertEquals(9, item2.sellIn);
        assertEquals(9, item2.quality);
        assertEquals(1, item3.sellIn);
        assertEquals(29, item3.quality);
    }

    @Test
    void givenNormalItemPastSellIn_whenUpdateQuality_thenQualityDecreasesTwiceAsFast() {
        final Item expiredItem = new Item("Normal item", -1, 8);
        Item[] items = new Item[]{expiredItem};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(-2, expiredItem.sellIn);
        assertEquals(6, expiredItem.quality);
    }

    @Test
    void givenNormalItemAtQuality0_whenUpdateQuality_thenQualityUnchanged() {
        final Item lowQualItem = new Item("Normal item", 2, 0);
        Item[] items = new Item[]{lowQualItem};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(1, lowQualItem.sellIn);
        assertEquals(0, lowQualItem.quality);
    }

    @Test
    void givenNormalItemPastSellInAtQuality1_whenUpdateQuality_thenQualityDecreasesTo0() {
        final Item lowQualItem = new Item("Normal item", -5, 1);
        Item[] items = new Item[]{lowQualItem};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(-6, lowQualItem.sellIn);
        assertEquals(0, lowQualItem.quality);
    }

    @Test
    void givenAgedBrie_whenUpdateQuality_thenSellInDecreasesAndQualityIncreases() {
        final Item agedBrie = new Item("Aged Brie", 6, 9);
        Item[] items = new Item[]{agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(5, agedBrie.sellIn);
        assertEquals(10, agedBrie.quality);
    }

    @Test
    void givenAgedBriePastSellIn_whenUpdateQuality_thenQualityIncreasesTwiceAsFast() {
        final Item agedBrie = new Item("Aged Brie", 0, 9);
        Item[] items = new Item[]{agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(-1, agedBrie.sellIn);
        assertEquals(11, agedBrie.quality);
    }

    @Test
    void givenAgedBrieAtQuality50_whenUpdateQuality_thenQualityDoesNotChange() {
        final Item agedBrie = new Item("Aged Brie", 10, 50);
        Item[] items = new Item[]{agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(9, agedBrie.sellIn);
        assertEquals(50, agedBrie.quality);
    }

    @Test
    void givenAgedBriePastSellInAtQuality49_whenUpdateQuality_thenQualityIncreasesUpTo50() {
        final Item agedBrie = new Item("Aged Brie", -9, 49);
        Item[] items = new Item[]{agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(-10, agedBrie.sellIn);
        assertEquals(50, agedBrie.quality);
    }

    @Test
    void givenSulfuras_whenUpdateQuality_thenSellInAndQualityDoNotChange() {
        final Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        Item[] items = new Item[]{sulfuras};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(10, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
    }

    @Test
    void givenBackstagePassesWithSellInGreaterThan10_whenUpdateQuality_thenQualityIncreases() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 2);
        Item[] items = new Item[]{backstagePasses};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(19, backstagePasses.sellIn);
        assertEquals(3, backstagePasses.quality);
    }

    @Test
    void givenBackstagePassesWithSellInAtOrUnder10_whenUpdateQuality_thenQualityIncreasesBy2() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2);
        Item[] items = new Item[]{backstagePasses};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(8, backstagePasses.sellIn);
        assertEquals(4, backstagePasses.quality);
    }

    @Test
    void givenBackstagePassesWithSellInAtOrUnder5_whenUpdateQuality_thenQualityIncreasesBy3() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        Item[] items = new Item[]{backstagePasses};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(4, backstagePasses.sellIn);
        assertEquals(5, backstagePasses.quality);
    }

    @Test
    void givenBackstagePassesAfterConcert_whenUpdateQuality_thenQualityIs0() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
        Item[] items = new Item[]{backstagePasses};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(-2, backstagePasses.sellIn);
        assertEquals(0, backstagePasses.quality);
    }

    @Test
    void givenBackstagePassesWithSellIn8AndQuality49_whenUpdateQuality_thenQualityIncreasesUpTo50() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49);
        Item[] items = new Item[]{backstagePasses};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(7, backstagePasses.sellIn);
        assertEquals(50, backstagePasses.quality);
    }

    @Test
    void givenBackstagePassesWithSellIn5AndQuality48_whenUpdateQuality_thenQualityIncreasesUpTo50() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        Item[] items = new Item[]{backstagePasses};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(4, backstagePasses.sellIn);
        assertEquals(50, backstagePasses.quality);
    }

    @Test
    void givenConjuredItemWithSellIn4AndQuality10_whenUpdateQuality_thenQualityDecreasesTo8() {
        final Item conjuredItem = new Item("Conjured Mana Cake", 4, 10);
        Item[] items = new Item[]{conjuredItem};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(3, conjuredItem.sellIn);
        assertEquals(8, conjuredItem.quality);
    }

    @Test
    void givenConjuredItemPastSellInAndQuality10_whenUpdateQuality_thenQualityDecreasesTo6() {
        final Item conjuredItem = new Item("Conjured Mana Cake", -1, 10);
        Item[] items = new Item[]{conjuredItem};
        GildedRose app = new GildedRose(items);

        app.updateItems();

        assertEquals(-2, conjuredItem.sellIn);
        assertEquals(6, conjuredItem.quality);
    }
}
