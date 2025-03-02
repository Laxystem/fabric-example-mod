package com.example.modid

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.oshai.kotlinlogging.slf4j.logger
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

data object ExampleMod : ModInitializer {
	@JvmField internal val LOGGER = LoggerFactory.getLogger(this::class.java)!! // for Java
	internal val logger = KotlinLogging.logger(LOGGER) // for Kotlin

	override fun onInitialize() {
		logger.info { "Hello World!" }
	}
}
