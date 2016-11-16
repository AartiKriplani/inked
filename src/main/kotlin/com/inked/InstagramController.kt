package com.inked

import com.github.kittinunf.fuel.Fuel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
open class InstagramController {
    val redirect_uri = "https://inked.cfapps.io/instagram/callback"

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping("/instagram/callback")
    fun receiveAccessToken(@RequestParam(required = false, defaultValue = "") code: String) {
        print(code)
        val instagram_url = "https://api.instagram.com/oauth/access_token"
        val client_secret = "5e0092b9cb294dd8aa442d5407bc5e7f"
        val client_id = "d1a059f035b84212b209fcb0fde37f5a"
        val parameters = listOf(
                "client_id" to client_id,
                "client_secret" to client_secret,
                "redirect_uri" to redirect_uri,
                "grant_type" to "authorization_code",
                "code" to code
        )
        Fuel.get(instagram_url, parameters).response { request, response, result ->
            print(result)
            print(response)

        }

    }

    @RequestMapping("instagram/request_access_token")
    fun requestNewToken() {
        val instagram_url = "https://api.instagram.com/oauth/authorize/"
        val client_id = "d1a059f035b84212b209fcb0fde37f5a"
        val responseType = "code"
        val parameters = listOf(
                "client_id" to client_id,
                "redirect_uri" to redirect_uri,
                "response_type" to responseType
        )
        Fuel.get(instagram_url, parameters).response { request, response, result ->
            print(response)
            print(result)
        }


    }

}
