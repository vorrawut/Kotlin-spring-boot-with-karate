@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.demo.controller

import com.example.demo.entity.CartItem
import com.example.demo.service.ShoppingCartService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController(
    private val shoppingCartService: ShoppingCartService,
) {
    private val cart = mutableListOf<CartItem>()

    @PostMapping("/add")
    fun addItemToCart(
        @RequestBody item: CartItem,
    ): ResponseEntity<String> = ResponseEntity.ok(shoppingCartService.addItem(item))

    @GetMapping
    fun getCartItems(): ResponseEntity<List<CartItem>> = ResponseEntity.ok(shoppingCartService.getCartItems())

    @DeleteMapping("/remove/{itemId}")
    fun removeItemFromCart(
        @PathVariable itemId: Long,
    ): ResponseEntity<String> =
        if (shoppingCartService.removeItem(itemId) == true) {
            ResponseEntity.ok("Item removed from cart")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to remove, Item not found")
        }
}
