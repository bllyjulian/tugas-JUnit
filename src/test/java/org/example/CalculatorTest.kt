package org.example

// Deklarasi paket (package) yang menyimpan kelas CalculatorTest dalam struktur folder 'org.example'.

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

// Import deklarasi yang diperlukan untuk melakukan pengujian, seperti Test dan beberapa asserstion dari JUnit.

class CalculatorTest {
    // Deklarasi kelas CalculatorTest.

    @Test
    fun `Test calculator can add two numbers`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa kalkulator dapat menambahkan dua angka.

        val calculator = Calculator()
        // Inisialisasi objek calculator dari kelas Calculator.

        val expected = 10
        // Inisialisasi variabel expected dengan nilai 10.

        assertEquals(expected, calculator.add(5, 5))
        // Memeriksa apakah hasil dari pemanggilan metode add dengan argumen 5 dan 5 adalah 10 (sesuai dengan nilai expected).
    }

    @Test
    fun `Test calculator can subtract two numbers`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa kalkulator dapat mengurangi dua angka.

        val calculator = Calculator()
        // Inisialisasi objek calculator dari kelas Calculator.

        assertEquals(5, calculator.sub(15, 10))
        // Memeriksa apakah hasil dari pemanggilan metode sub dengan argumen 15 dan 10 adalah 5.
    }
}
