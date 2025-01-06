package com.example.appcrypto.Activity

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.appcrypto.Model.CryptoModel
import com.example.appcrypto.R
import com.example.appcrypto.databinding.ActivityDetailCryptoBinding

@Suppress("DEPRECATION") // Menekan peringatan deprecation
class DetailCryptoActivity : AppCompatActivity() { // Activity untuk detail kripto
    private lateinit var binding: ActivityDetailCryptoBinding // Binding untuk layout
    private lateinit var item: CryptoModel // Data kripto yang diterima
    private var formatter: DecimalFormat = DecimalFormat("#,##0.00") // Formatter angka

    override fun onCreate(savedInstanceState: Bundle?) { // Saat activity dibuat
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCryptoBinding.inflate(layoutInflater) // Inisialisasi binding
        setContentView(binding.root) // Set layout

        window.setFlags( // Fullscreen
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getBundle() // Ambil data dari intent
        orderType() // Set spinner order type
        setVariable() // Set listener tombol
    }

    @SuppressLint("SetTextI18n") // Abaikan peringatan hardcoded string
    private fun setVariable() { // Set listener tombol
        binding.beliPositionBtn.setOnClickListener { // Tombol Beli
            binding.beliPositionBtn.setBackgroundResource(R.drawable.green_bg) // Hijau
            binding.jualPositionBtn.setBackgroundResource(R.drawable.semi_white_bg) // Putih
            binding.sendOrderBtn.setBackgroundResource(R.drawable.green_bg) // Hijau
            binding.sendOrderBtn.text = "Beli" + item.ShortSymbol.replace("/USDT", "") // Teks "Beli"
        }

        binding.jualPositionBtn.setOnClickListener { // Tombol Jual
            binding.beliPositionBtn.setBackgroundResource(R.drawable.semi_white_bg) // Putih
            binding.jualPositionBtn.setBackgroundResource(R.drawable.red_bg) // Merah
            binding.sendOrderBtn.setBackgroundResource(R.drawable.red_bg) // Merah
            binding.sendOrderBtn.text = "Jual" + item.ShortSymbol.replace("/USDT", "") // Teks "Jual"
        }

        binding.plusAmountBtn.setOnClickListener { // Tombol Tambah
            if (binding.amountEdt.text.isEmpty()) { // Jika kosong
                binding.amountEdt.setText("0") // Set 0
            }
            var n: Double = binding.amountEdt.text.toString().toDouble() // Ambil nilai
            n += 1 // Tambah 1
            binding.amountEdt.setText(n.toString()) // Set nilai baru
        }

        binding.minusAmountBtn.setOnClickListener { // Tombol Kurang
            if (binding.amountEdt.text.isEmpty()) { // Jika kosong
                binding.amountEdt.setText("0") // Set 0
            }
            var n: Double = binding.amountEdt.text.toString().toDouble() // Ambil nilai
            if (n > 0) { // Jika lebih dari 0
                n -= 1 // Kurangi 1
                binding.amountEdt.setText(n.toString()) // Set nilai baru
            }
        }
    }

    @SuppressLint("SetTextI18n", "DiscouragedApi") // Abaikan peringatan
    private fun getBundle() { // Ambil data dari intent
        item = intent.getParcelableExtra("object")!! // Ambil data CryptoModel

        binding.symbolNameTxt.text = item.ShortSymbol // Set simbol
        binding.priceTxt.text = item.Price.toString() // Set harga
        binding.changePercentTxt.text = item.ChangePercent.toString() + "IDR" // Set persentase perubahan
        binding.pJualTxt1.text = formatter.format(item.JualPrice1) ?: "0" // Set harga jual 1
        binding.pJualTxt2.text = formatter.format(item.JualPrice2) ?: "0" // Set harga jual 2
        binding.pJualTxt3.text = formatter.format(item.JualPrice3) ?: "0" // Set harga jual 3
        binding.pJualTxt4.text = formatter.format(item.JualPrice4) ?: "0" // Set harga jual 4
        binding.pJualTxt5.text = formatter.format(item.JualPrice5) ?: "0" // Set harga jual 5
        binding.aJualTxt1.text = item.JualAmount1.toString() // Set jumlah jual 1
        binding.aJualTxt2.text = item.JualAmount2.toString() // Set jumlah jual 2
        binding.aJualTxt3.text = item.JualAmount3.toString() // Set jumlah jual 3
        binding.aJualTxt4.text = item.JualAmount4.toString() // Set jumlah jual 4
        binding.aJualTxt5.text = item.JualAmount5.toString() // Set jumlah jual 5
        binding.pBeliTxt1.text = formatter.format(item.BeliPrice1) ?: "0" // Set harga beli 1
        binding.pBeliTxt2.text = formatter.format(item.BeliPrice2) ?: "0" // Set harga beli 2
        binding.pBeliTxt3.text = formatter.format(item.BeliPrice3) ?: "0" // Set harga beli 3
        binding.pBeliTxt4.text = formatter.format(item.BeliPrice4) ?: "0" // Set harga beli 4
        binding.pBeliTxt5.text = formatter.format(item.BeliPrice5) ?: "0" // Set harga beli 5
        binding.aBeliTxt1.text = item.BeliAmount1.toString() // Set jumlah beli 1
        binding.aBeliTxt2.text = item.BeliAmount2.toString() // Set jumlah beli 2
        binding.aBeliTxt3.text = item.BeliAmount3.toString() // Set jumlah beli 3
        binding.aBeliTxt4.text = item.BeliAmount4.toString() // Set jumlah beli 4
        binding.aBeliTxt5.text = item.BeliAmount5.toString() // Set jumlah beli 5
        binding.openTxt.text = formatter.format(item.Open) ?: "0" // Set harga open
        binding.closeTxt.text = formatter.format(item.Close) ?: "0" // Set harga close
        binding.highTxt.text = formatter.format(item.High) ?: "0" // Set harga tertinggi
        binding.lowTxt.text = formatter.format(item.Low) ?: "0" // Set harga terendah
        binding.dailyChangeTxt.text = item.DailyChange.toString() + "%" // Set perubahan harian
        binding.dailyVolTxt.text = "IDR" + item.DailyVol.toString() + "T" // Set volume harian

        if (item.ChangePercent > 0) { // Jika positif
            binding.priceTxt.setTextColor(resources.getColor(R.color.green)) // Hijau
            binding.changePercentTxt.setTextColor(resources.getColor(R.color.green)) // Hijau
        } else { // Jika negatif
            binding.priceTxt.setTextColor(resources.getColor(R.color.red)) // Merah
            binding.changePercentTxt.setTextColor(resources.getColor(R.color.red)) // Merah
        }

        val drawable = resources.getIdentifier(item.SymboLogo, "drawable", packageName) // Ambil logo
        Glide.with(this) // Load logo
            .load(drawable)
            .into(binding.logoImg)

        binding.backBtn.setOnClickListener { // Tombol kembali
            finish() // Tutup activity
        }
    }

    private fun orderType() { // Set spinner order type
        val adapter = ArrayAdapter(this, R.layout.spinner_item, listOf("limit Order", "Market Order", "Stop Order")) // Adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // Layout dropdown
        binding.orderTypeSpin.adapter = adapter // Set adapter
    }
}