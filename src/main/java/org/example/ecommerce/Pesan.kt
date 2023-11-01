package org.example.ecommerce

// Mendefinisikan kelas bernama Order
class Order(private val produk: String, private val jumlah: Int) {

    // Menunda inisialisasi properti warehouse
    private lateinit var gudang: Warehouse

    // Properti untuk menunjukkan apakah pesanan sudah diisi atau belum
    private var sudahDiisi: Boolean = false

    // Fungsi untuk mengisi pesanan dari gudang
    fun isi(gudang: Warehouse) {
        this.gudang = gudang
        sudahDiisi = this.gudang.hapus(produk, jumlah)
    }

    // Fungsi untuk memeriksa apakah pesanan sudah diisi atau belum
    fun sudahDiisi(): Boolean {
        return sudahDiisi
    }
}
