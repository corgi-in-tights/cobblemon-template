package dev.reyaan.modid.fabric.utils

import net.minecraft.text.Text

fun String.literal(): Text = Text.literal(this)

fun String.translate(): Text = Text.translatable(this)