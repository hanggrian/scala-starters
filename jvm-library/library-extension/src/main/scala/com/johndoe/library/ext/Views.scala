package com.johndoe.library.ext

import com.johndoe.library.View

object Views {
    def create(): View = {
        val view = new View()
        view.setBounds(10, 10, 100, 40)
        view
    }
}
