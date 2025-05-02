package com.johndoe.app

import com.google.common.truth.Truth.assertThat
import org.scalatest.funsuite.AnyFunSuite

class ViewSuite extends AnyFunSuite {
    test("View text match") {
        assertThat(new View().getText).isEqualTo("Hello World")
    }
}
