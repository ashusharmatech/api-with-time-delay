package com.github.ashusharmatech.apiwithtimedelay.resources

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {
    var logger: Logger = LoggerFactory.getLogger(ApiController::class.java)

    /**
     * This method will delay the response by the number of seconds passed as argument
     */
    @GetMapping("/{secondsToDelay}")
    fun main(@PathVariable secondsToDelay: Integer): String {
        logger.info("Going for sleep for $secondsToDelay seconds")
        try {
            Thread.sleep((secondsToDelay.toInt() * 1000).toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        logger.info("Sending response now after $secondsToDelay")
        return "Success response after $secondsToDelay seconds"
    }
}