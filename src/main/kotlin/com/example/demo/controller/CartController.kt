@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.demo.controller

import com.example.demo.entity.CartItem
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController {
    private val cart = mutableListOf<CartItem>()

    @PostMapping("/add")
    fun addItemToCart(
        @RequestBody item: CartItem,
    ): ResponseEntity<String> {
        cart.add(item)
        return ResponseEntity.ok("Item added to cart")
    }

    @GetMapping
    fun getCartItems(): ResponseEntity<List<CartItem>> = ResponseEntity.ok(cart)

    @DeleteMapping("/remove/{itemId}")
    fun removeItemFromCart(
        @PathVariable itemId: Long,
    ): ResponseEntity<String> {
        val item = cart.find { it.id == itemId }
        return if (item != null) {
            cart.remove(item)
            ResponseEntity.ok("Item removed from cart")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found")
        }
    }
}
