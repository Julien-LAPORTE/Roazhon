package fr.samneo.roazhonapp.ui.components

fun getNextIndex(listSize: Int, index: Int): Int {
    return (index + 1) % listSize
}

fun getPreviousIndex(listSize: Int, index: Int): Int {
    return (index - 1 + listSize) % listSize
}