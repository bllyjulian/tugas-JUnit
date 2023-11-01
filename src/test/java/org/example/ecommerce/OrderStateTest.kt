package io.automationhacks.ecommerce

// Deklarasi paket (package) yang menyimpan kelas OrderStateTest dalam struktur folder 'io.automationhacks.ecommerce'.

import org.example.ecommerce.Order
import org.example.ecommerce.Warehouse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Import deklarasi yang diperlukan untuk melakukan pengujian, seperti BeforeEach, Test, dan beberapa asserstion dari Kotlin Test.

class OrderStateTest {
    // Deklarasi kelas OrderStateTest.

    private val LAPTOP = "Macbook"
    private val MOUSE = "Logitech Mouse"
    private val warehouse = Warehouse()
    // Inisialisasi variabel konstan LAPTOP dan MOUSE serta membuat objek dari kelas Warehouse.

    @BeforeEach
    fun setUp() {
        // Deklarasi metode setUp yang akan dijalankan sebelum setiap pengujian.

        warehouse.add(LAPTOP, 50)
        warehouse.add(MOUSE, 20)
        // Menambahkan barang "Macbook" sebanyak 50 dan "Logitech Mouse" sebanyak 20 ke dalam gudang.
    }

    @Test
    fun `test order is fulfilled if capacity in warehouse is sufficient`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa pesanan terpenuhi jika kapasitas gudang cukup.

        val order = Order(LAPTOP, 20)
        // Inisialisasi objek order dengan produk "Macbook" dan jumlah 20.

        order.fill(warehouse)
        // Memanggil metode fill pada objek order dengan menggunakan gudang yang telah disiapkan.

        assertTrue(order.isFilled())
        // Memeriksa apakah pesanan sudah terpenuhi.

        assertEquals(30, warehouse.getInventory(LAPTOP))
        // Memeriksa apakah inventory gudang berkurang menjadi 30 setelah pesanan terpenuhi.
    }

    @Test
    fun `test order is not fulfilled if capacity in warehouse is insufficient`() {
        // Deklarasi metode pengujian dengan nama test yang menjelaskan bahwa pesanan tidak terpenuhi jika kapasitas gudang tidak mencukupi.

        val order = Order(MOUSE, 21)
        // Inisialisasi objek order dengan produk "Logitech Mouse" dan jumlah 21.

        order.fill(warehouse)
        // Memanggil metode fill pada objek order dengan menggunakan gudang yang telah disiapkan.

        assertFalse(order.isFilled())
        // Memeriksa apakah pesanan tidak terpenuhi.

        assertEquals(20, warehouse.getInventory(MOUSE))
        // Memeriksa apakah inventory gudang tetap 20 setelah pesanan tidak dapat terpenuhi.
    }

}
