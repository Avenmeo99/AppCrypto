package com.example.appcrypto.Activity

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.appcrypto.Model.CryptoModel
import com.example.appcrypto.R
import com.example.appcrypto.databinding.ActivityDetailCryptoBinding
import java.util.ResourceBundle.getBundle

class DetailCryptoActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailCryptoBinding
    private lateinit var item: CryptoModel
    var formatter:DecimalFormat= DecimalFormat("###, ###, ###, ##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCryptoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getBundle()
        orderType()
        setVariable()

    }

    private fun setVariable() {
        binding.beliPositionBtn.setOnClickListener{
            binding.beliPositionBtn.setBackgroundResource(R.drawable.green_bg)
            binding.jualPositionBtn.setBackgroundResource(R.drawable.semi_white_bg)
            binding.sendOrderBtn.setBackgroundResource(R.drawable.green_bg)
            binding.sendOrderBtn.setText("Beli" + item.ShortSymbol.replace("/USDT", ""))
        }

        binding.jualPositionBtn.setOnClickListener{
            binding.beliPositionBtn.setBackgroundResource(R.drawable.semi_white_bg)
            binding.jualPositionBtn.setBackgroundResource(R.drawable.red_bg)
            binding.sendOrderBtn.setBackgroundResource(R.drawable.red_bg)
            binding.sendOrderBtn.setText("Jual" + item.ShortSymbol.replace("/USDT", ""))
        }

        binding.plusAmountBtn.setOnClickListener{
            if(binding.amountEdt.text.isEmpty()) {
                binding.amountEdt.setText("0")
            }
            var n:Double=binding.amountEdt.text.toString().toDouble()
            n=n+1
            binding.amountEdt.setText(n.toString())

        }

        binding.minusAmountBtn.setOnClickListener{
            if(binding.amountEdt.text.isEmpty()) {
                binding.amountEdt.setText("0")
            }
            var n:Double=binding.amountEdt.text.toString().toDouble()
            if(n>0) {
                n=n-1
                binding.amountEdt.setText(n.toString())
            }
        }
    }

    private fun getBundle() {
        item=intent.getParcelableExtra("object")!!

        binding.symbolNameTxt.text=item.ShortSymbol
        binding.priceTxt.text=item.Price.toString()
        binding.changePercentTxt.text=item.ChangePercent.toString()+"IDR"
        binding.pJualTxt1.text=formatter?.format(item.JualPrice1)?: "0"
        binding.pJualTxt2.text=formatter?.format(item.JualPrice2)?: "0"
        binding.pJualTxt3.text=formatter?.format(item.JualPrice3)?: "0"
        binding.pJualTxt4.text=formatter?.format(item.JualPrice4)?: "0"
        binding.pJualTxt5.text=formatter?.format(item.JualPrice5)?: "0"
        binding.aJualTxt1.text=item.JualAmount1.toString()
        binding.aJualTxt2.text=item.JualAmount2.toString()
        binding.aJualTxt3.text=item.JualAmount3.toString()
        binding.aJualTxt4.text=item.JualAmount4.toString()
        binding.aJualTxt5.text=item.JualAmount5.toString()
        binding.pBeliTxt1.text=formatter?.format(item.BeliPrice1)?: "0"
        binding.pBeliTxt2.text=formatter?.format(item.BeliPrice2)?: "0"
        binding.pBeliTxt3.text=formatter?.format(item.BeliPrice3)?: "0"
        binding.pBeliTxt4.text=formatter?.format(item.BeliPrice4)?: "0"
        binding.pBeliTxt5.text=formatter?.format(item.BeliPrice5)?: "0"
        binding.aBeliTxt1.text=item.BeliAmount1.toString()
        binding.aBeliTxt2.text=item.BeliAmount2.toString()
        binding.aBeliTxt3.text=item.BeliAmount3.toString()
        binding.aBeliTxt4.text=item.BeliAmount4.toString()
        binding.aBeliTxt5.text=item.BeliAmount5.toString()
        binding.openTxt.text=formatter?.format(item.Open)?:"0"
        binding.closeTxt.text=formatter?.format(item.Close)?:"0"
        binding.highTxt.text=formatter?.format(item.High)?: "0"
        binding.lowTxt.text=formatter?.format(item.Low)?:"0"
        binding.dailyChangeTxt.text=item.DailyChange.toString()+"%"
        binding.dailyVolTxt.text="IDR"+item.DailyVol.toString()+"T"

        if(item.ChangePercent>0) {
            binding.priceTxt.setTextColor(resources.getColor(R.color.green))
            binding.changePercentTxt.setTextColor(resources.getColor(R.color.green))
        }else{
            binding.priceTxt.setTextColor(resources.getColor(R.color.red))
            binding.changePercentTxt.setTextColor(resources.getColor(R.color.red))
        }


        val drawable=resources.getIdentifier(item.SymboLogo,"drawable",packageName)

        Glide.with(this)
            .load(drawable)
            .into(binding.logoImg)

        binding.backBtn.setOnClickListener {
            finish()


        }

    }
    private fun orderType(){
        val adapter=ArrayAdapter(this,R.layout.spinner_item, listOf("limit Order", "Market Order","Stop Order"))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.orderTypeSpin.adapter=adapter

    }

}