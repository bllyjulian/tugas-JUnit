package org.example

// Deklarasi paket (package) yang menyimpan kelas CalculatorWithMockTest dalam struktur folder 'org.example'.

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.opentest4j.AssertionFailedError
import kotlin.test.assertEquals

// Import deklarasi yang diperlukan untuk melakukan pengujian, seperti Test, assertThrows, dan beberapa fungsi dari Mockito dan Kotlin Test.

class CalculatorWithMockTest {
    // Deklarasi kelas CalculatorWithMockTest.

    @Test
    fun `test mock calculator add method returns mocked value`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa metode add pada kalkulator palsu mengembalikan nilai yang di-mock.

        val mockCalculator = mock(Calculator::class.java)
        // Membuat objek palsu dari kelas Calculator.

        `when`(mockCalculator.add(5, 5)).thenReturn(20)
        // Mendefinisikan perilaku mock: ketika add dipanggil dengan argumen 5 dan 5, maka kembalikan 20.

        val actual = mockCalculator.add(5, 5)
        // Memanggil metode add pada objek mockCalculator.

        println("Actual result from mock: $actual")
        // Mencetak hasil yang diperoleh dari mockCalculator.

        assertEquals(expected = 20, actual)
        // Memeriksa apakah hasil yang diperoleh dari mock adalah 20 (sesuai dengan nilai yang di-mock).
    }

    @Test
    fun `test mock calculator add method does not return a value for unhandled case`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa metode add pada kalkulator palsu tidak mengembalikan nilai untuk kasus yang tidak di-handel.

        val mockCalculator = mock(Calculator::class.java)
        // Membuat objek palsu dari kelas Calculator.

        `when`(mockCalculator.add(5, 5)).thenReturn(20)
        // Mendefinisikan perilaku mock: ketika add dipanggil dengan argumen 5 dan 5, maka kembalikan 20.

        val actual = mockCalculator.add(5, 10)
        // Memanggil metode add pada objek mockCalculator dengan argumen yang berbeda.

        println("Actual result from mock: $actual")
        // Mencetak hasil yang diperoleh dari mockCalculator.

        assertThrows<AssertionFailedError> { assertEquals(expected = 15, actual) }
        // Memeriksa bahwa tidak ada nilai yang dikembalikan untuk kasus yang tidak di-handel, dan akan menghasilkan AssertionFailedError.
    }
}
