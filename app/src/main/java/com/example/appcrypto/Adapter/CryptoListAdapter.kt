package com.example.appcrypto.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcrypto.Activity.DetailCryptoActivity
import com.example.appcrypto.Model.CryptoModel
import com.example.appcrypto.R
import com.example.appcrypto.databinding.ViewholderWaletBinding

@Suppress("DEPRECATION", "DEPRECATION") // Abaikan peringatan deprecation
class CryptoListAdapter(private val items: MutableList<CryptoModel>) : // Adapter untuk RecyclerView
    RecyclerView.Adapter<CryptoListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderWaletBinding) : // ViewHolder untuk setiap item
        RecyclerView.ViewHolder(binding.root) // Menampung binding

    private lateinit var context: Context // Konteks aplikasi
    private var formatter: DecimalFormat? = null // Formatter angka

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // Membuat ViewHolder
        context = parent.context // Inisialisasi konteks
        formatter = DecimalFormat("###,###,###") // Inisialisasi formatter
        val binding = ViewholderWaletBinding.inflate(LayoutInflater.from(parent.context), parent, false) // Inflate layout
        return ViewHolder(binding) // Kembalikan ViewHolder
    }

    @SuppressLint("SetTextI18n", "DiscouragedApi") // Abaikan peringatan
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // Mengikat data ke ViewHolder
        val item = items[position] // Ambil item pada posisi tertentu
        holder.binding.crytpoNameText.text = item.Symbol // Set nama kripto
        holder.binding.cryptoPriceText.text = "IDR" + formatter?.format(item.Price) // Set harga kripto
        holder.binding.changePercentText.text = item.ChangePercent.toString() + "%" // Set persentase perubahan
        holder.binding.propertySizeText.text = item.AmountNumber.toString() + item.ShortSymbol.replace("/USDT", "") // Set jumlah kepemilikan
        holder.binding.propertyAmountText.text = "IDR" + formatter?.format(item.AmountRupiah) // Set nilai kepemilikan

        // Mengubah warna changePercentText berdasarkan nilai ChangePercent
        if (item.ChangePercent > 0) { // Jika positif
            holder.binding.changePercentText.setTextColor(context.resources.getColor(R.color.green)) // Hijau
        } else if (item.ChangePercent < 0) { // Jika negatif
            holder.binding.changePercentText.setTextColor(context.resources.getColor(R.color.red)) // Merah
        } else { // Jika nol
            holder.binding.changePercentText.setTextColor(context.resources.getColor(R.color.white)) // Putih
        }
        // Mengubah warna propertyAmountText berdasarkan nilai AmountRupiah
        if (item.AmountRupiah > 0) { // Jika positif
            holder.binding.propertyAmountText.setTextColor(context.resources.getColor(R.color.green)) // Hijau
        } else if (item.AmountRupiah < 0) { // Jika negatif
            holder.binding.propertyAmountText.setTextColor(context.resources.getColor(R.color.red)) // Merah
        } else { // Jika nol
            holder.binding.propertyAmountText.setTextColor(context.resources.getColor(R.color.white)) // Putih
        }
        val drawableResourceId = holder.itemView.resources.getIdentifier( // Ambil ID gambar
            item.SymboLogo, // Nama gambar
            "drawable", // Tipe sumber daya
            holder.itemView.context.packageName // Nama paket
        )

        Glide.with(context) // Load gambar
            .load(drawableResourceId)
            .into(holder.binding.logoImg) // Ke ImageView

        holder.itemView.setOnClickListener { // Listener saat item diklik
            val intent = Intent(context, DetailCryptoActivity::class.java) // Buat Intent
            intent.putExtra("object", item) // Kirim data item
            holder.itemView.context.startActivity(intent) // Mulai activity
        }
    }

    override fun getItemCount(): Int = items.size // Jumlah item
}