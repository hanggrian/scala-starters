package com.johndoe.library

import javax.swing.JLabel

class JLabelImpl(protected val label: JLabel) {
    def getSize: Int = label.getWidth * label.getHeight
}
