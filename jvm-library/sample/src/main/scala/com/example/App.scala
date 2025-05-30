package com.example

import com.johndoe.library.ext.JLabelExtImpl
import java.awt.Font
import java.awt.Font.PLAIN
import javax.swing.{JFrame, JLabel}

object App {
    def main(args: Array[String]): Unit = {
        val label = new JLabel
        label.setFont(new Font("Default", PLAIN, 20))
        label.setBounds(50, 50, 300, 100)

        val impl = new JLabelExtImpl(label)
        label.setText(s"${impl.getSize} pixels")
        label.setText(s"${label.getText} at ${impl.getPosition}")

        val frame = new JFrame
        frame.add(label)
        frame.setSize(400, 300)
        frame.setLayout(_)
        frame.setVisible(true)
    }
}
