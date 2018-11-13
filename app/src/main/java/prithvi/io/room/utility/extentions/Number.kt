package prithvi.io.room.utility.extentions

fun Number.roundOff(value: Int = 2) = String.format("%.${value}f".format(this))