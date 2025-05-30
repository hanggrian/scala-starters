package com.johndoe.library.ext

import com.google.common.truth.Truth.assertThat
import javax.swing.JLabel
import org.junit.jupiter.api.{BeforeEach, Test}
import org.mockito.Mockito.{verify, when}
import org.scalatestplus.mockito.MockitoSugar

class JLabelExtImplSuite extends MockitoSugar {
    private var label: JLabel = _

    @BeforeEach
    def setup(): Unit = {
        label = mock[JLabel]
    }

    @Test
    def test(): Unit = {
        when(label.getX).thenReturn(0)
        when(label.getY).thenReturn(1)
        assertThat(new JLabelExtImpl(label).getPosition).isEqualTo("(0,1)")
        verify(label).getX
        verify(label).getY
    }
}
