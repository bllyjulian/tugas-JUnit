package org.example.ecommerce

// Mendefinisikan kelas bernama Warehouse
class Warehouse {

    // Membuat HashMap pribadi untuk menyimpan produk dan jumlahnya
    private val gudang: HashMap<String, Int> = hashMapOf()

    // Fungsi untuk menambahkan produk dan jumlahnya ke gudang
    fun tambahProduk(namaProduk: String, jumlah: Int) {
        gudang[namaProduk] = jumlah
    }

    // Fungsi untuk menghapus sejumlah tertentu produk dari gudang
    fun hapusProduk(namaProduk: String, jumlah: Int): Boolean {

        // Memeriksa apakah produk tidak ada di gudang
        if (gudang.contains(namaProduk).not()) {
            println("Produk tidak ditemukan di gudang")
            return false
        }

        // Memeriksa apakah tidak ada item untuk produk ini di gudang
        if (gudang[namaProduk] == 0) {
            println("Tidak ada item untuk produk ini di gudang")
            return false
        }

        // Memeriksa apakah tidak cukup item di gudang
        if (gudang[namaProduk]!! < jumlah) {
            println("Tidak cukup item di gudang")
            return false
        }

        // Memperbarui jumlah produk di gudang
        val jumlahSaatIni = gudang[namaProduk]
        val jumlahBaru = jumlahSaatIni!!.minus(jumlah)
        gudang[namaProduk] = jumlahBaru
        return true
    }

    // Fungsi untuk mendapatkan inventaris (jumlah) dari suatu produk di gudang
    fun dapatkanInventaris(namaProduk: String): Int? {
        return gudang.get(namaProduk)
    }
}
