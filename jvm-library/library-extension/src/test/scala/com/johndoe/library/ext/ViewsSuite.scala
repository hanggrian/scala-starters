package com.johndoe.library.ext

import com.google.common.truth.Truth.assertThat
import org.scalatest.funsuite.AnyFunSuite

class ViewsSuite extends AnyFunSuite {
    test("View exists") {
        assertThat(Views.create()).isNotNull()
    }
}
