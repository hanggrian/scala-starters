package com.johndoe.app

import java.awt.Font
import java.awt.Font.PLAIN
import javax.swing.{JFrame, JLabel}

object App {
    def main(args: Array[String]): Unit = {
        val label = new JLabel
        label.setFont(new Font("Default", PLAIN, 20))
        label.setBounds(50, 50, 300, 100)
        label.setText(s"${new JLabelImpl(label).getSize} pixels")

        val frame = new JFrame
        frame.add(label)
        frame.setSize(400, 300)
        frame.setLayout(_)
        frame.setVisible(true)
    }
}
