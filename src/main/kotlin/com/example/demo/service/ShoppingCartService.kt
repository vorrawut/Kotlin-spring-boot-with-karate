package com.example.demo.service

import com.example.demo.entity.CartItem
import org.springframework.stereotype.Service

@Service
class ShoppingCartService {
    private val cart = mutableListOf<CartItem>()

    fun addItem(item: CartItem): String {
        cart.add(item)
        return "Item added to cart successfully"
    }

    fun getCartItems(): List<CartItem> = cart

    fun removeItem(itemId: Long): Boolean? {
        val item = cart.find { it.id == itemId }
        return if (item != null) {
            cart.remove(item)
        } else {
            false
        }
    }
}
