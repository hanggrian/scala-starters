package com.johndoe.app

import javax.swing.JFrame

object App {
    def main(args: Array[String]): Unit = {
        val view = new View()
        view.setBounds(10, 10, 100, 40)

        val frame = new JFrame()
        frame.add(view)
        frame.setSize(100, 100)
        frame.setLayout(null)
        frame.setVisible(true)
    }
}
