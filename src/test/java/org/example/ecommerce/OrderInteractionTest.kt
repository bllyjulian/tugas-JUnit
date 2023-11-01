package org.example.ecommerce

// Deklarasi paket (package) yang menyimpan kelas OrderInteractionTest dalam struktur folder 'org.example.ecommerce'.

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Import deklarasi yang diperlukan untuk melakukan pengujian, seperti Test, Mockito, dan beberapa asserstion dari Kotlin Test.

class OrderInteractionTest {
    // Deklarasi kelas OrderInteractionTest.

    private val LAPTOP = "Macbook"
    // Inisialisasi variabel konstanta LAPTOP dengan nilai "Macbook".

    @Test
    fun `test warehouse capacity is reduced on fulfilling order`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa kapasitas gudang berkurang ketika pesanan terpenuhi.

        val order = Order(LAPTOP, 50)
        // Inisialisasi objek order dengan produk "Macbook" dan jumlah 50.

        val warehouseMock = mock(Warehouse::class.java)
        // Membuat mock objek dari kelas Warehouse.

        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(0)
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(true)
        // Mendefinisikan perilaku mock: ketika getInventory dipanggil dengan argumen "Macbook", maka kembalikan 0.
        // Ketika remove dipanggil dengan argumen "Macbook" dan 50 sebagai jumlah, maka kembalikan true.

        order.fill(warehouseMock)
        // Memanggil metode fill pada objek order dengan menggunakan mock warehouse.

        assertTrue(order.isFilled())
        // Memeriksa apakah pesanan sudah terpenuhi.

        assertEquals(0, warehouseMock.getInventory(LAPTOP))
        // Memeriksa apakah inventory gudang berkurang menjadi 0 setelah pesanan terpenuhi.
    }

    @Test
    fun `test warehouse capacity is not reduced when order cannot be fulfilled`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa kapasitas gudang tidak berkurang ketika pesanan tidak dapat terpenuhi.

        val order = Order(LAPTOP, 51)
        // Inisialisasi objek order dengan produk "Macbook" dan jumlah 51.

        val warehouseMock = mock(Warehouse::class.java)
        // Membuat mock objek dari kelas Warehouse.

        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(50)
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(false)
        // Mendefinisikan perilaku mock: ketika getInventory dipanggil dengan argumen "Macbook", maka kembalikan 50.
        // Ketika remove dipanggil dengan argumen "Macbook" dan 50 sebagai jumlah, maka kembalikan false.

        order.fill(warehouseMock)
        // Memanggil metode fill pada objek order dengan menggunakan mock warehouse.

        assertFalse(order.isFilled())
        // Memeriksa apakah pesanan tidak terpenuhi.

        assertEquals(50, warehouseMock.getInventory(LAPTOP))
        // Memeriksa apakah inventory gudang tetap 50 setelah pesanan tidak dapat terpenuhi.
    }
}
