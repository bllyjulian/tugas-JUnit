package org.example

// Deklarasi paket (package) untuk menempatkan kelas dalam hierarki struktur folder.
// Dalam hal ini, kelas Calculator berada dalam paket 'org.example'.

class Calculator {

    // Deklarasi kelas Calculator.

    fun add(first: Int, second: Int): Int {
        // Deklarasi fungsi 'add' yang menerima dua parameter bertipe Int dan mengembalikan Int.

        return first + second
        // Fungsi ini melakukan penjumlahan dari dua parameter yang diterima dan mengembalikan hasilnya.
    }

    fun sub(first: Int, second: Int): Int {
        // Deklarasi fungsi 'sub' yang menerima dua parameter bertipe Int dan mengembalikan Int.

        return first - second
        // Fungsi ini melakukan pengurangan antara parameter pertama dan kedua, lalu mengembalikan hasilnya.
    }
}
