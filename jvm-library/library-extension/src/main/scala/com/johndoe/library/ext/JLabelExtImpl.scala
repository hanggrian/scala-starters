package com.johndoe.library.ext

import com.johndoe.library.JLabelImpl
import javax.swing.JLabel

class JLabelExtImpl(label: JLabel) extends JLabelImpl(label) {
    def getPosition: String = s"(${label.getX},${label.getY})"
}
