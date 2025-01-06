package com.example.appcrypto.Adapter

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


class CryptoListAdapter(private val items: MutableList<CryptoModel>):RecyclerView.Adapter<CryptoListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ViewholderWaletBinding):RecyclerView.ViewHolder(binding.root) // Perbaikan di sini: hapus spasi

    private lateinit var context: Context
    var formatter:DecimalFormat? =null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        formatter = DecimalFormat( "###,###,###")
        val binding = ViewholderWaletBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.crytpoNameText.text=item.Symbol
        holder.binding.cryptoPriceText.text="IDR"+formatter?.format(item.Price)
        holder.binding.changePercentText.text=item.ChangePercent.toString()+ "%"
        holder.binding.propertySizeText.text=item.AmountNumber.toString()+item.ShortSymbol.replace( "/USDT", "")
        holder.binding.propertyAmountText.text="IDR"+formatter?.format(item.AmountRupiah)

        // Mengubah warna changePercentText berdasarkan nilai ChangePercent
        if (item.ChangePercent > 0) {
            holder.binding.changePercentText.setTextColor(
                context.resources.getColor(R.color.green)
            )
        } else if (item.ChangePercent < 0) {
            holder.binding.changePercentText.setTextColor(
                context.resources.getColor(R.color.red)
            )
        } else {
            holder.binding.changePercentText.setTextColor(
                context.resources.getColor(R.color.white)
            )
        }
        // Mengubah warna propertyAmountText berdasarkan nilai AmountRupiah
        if (item.AmountRupiah > 0) {
            holder.binding.propertyAmountText.setTextColor(
                context.resources.getColor(R.color.green)
            )
        } else if (item.AmountRupiah < 0) {
            holder.binding.propertyAmountText.setTextColor(
                context.resources.getColor(R.color.red)
            )
        } else {
            holder.binding.propertyAmountText.setTextColor(
                context.resources.getColor(R.color.white)
            )
        }
                val drawableResourceId = holder.itemView.resources.getIdentifier(
            item.SymboLogo,
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.binding.logoImg)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailCryptoActivity::class.java)
        intent.putExtra("object", item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
    }
