package com.example.paramvir.mlsmart.dummy

import java.util.*

object ActionsContent {


    val ITEMS: MutableList<ActionItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, ActionItem> = HashMap()

    private val COUNT = 5

    init {
        // Add some sample items.
        addItem(ActionItem("1", "Text Detection", makeDetails(1)))
        addItem(ActionItem("2", "Image Labeling", makeDetails(2)))
        addItem(ActionItem("3", "Landmark detection", makeDetails(2)))
        addItem(ActionItem("4", "Face Detection", makeDetails(2)))
        addItem(ActionItem("5", "Barcode Scanning", makeDetails(2)))


    }

    private fun addItem(item: ActionItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class ActionItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
