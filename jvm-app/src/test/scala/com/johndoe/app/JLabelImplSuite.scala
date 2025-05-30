package com.johndoe.app

import com.google.common.truth.Truth.assertThat
import javax.swing.JLabel
import org.junit.jupiter.api.{BeforeEach, Test}
import org.mockito.Mockito.{verify, when}
import org.scalatestplus.mockito.MockitoSugar

class JLabelImplSuite extends MockitoSugar {
    private var label: JLabel = _

    @BeforeEach
    def setup(): Unit = {
        label = mock[JLabel]
    }

    @Test
    def test(): Unit = {
        when(label.getWidth).thenReturn(2)
        when(label.getHeight).thenReturn(4)
        assertThat(new JLabelImpl(label).getSize).isEqualTo(8)
        verify(label).getWidth
        verify(label).getHeight
    }
}
