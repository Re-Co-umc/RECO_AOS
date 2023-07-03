package com.umc.reco_aos

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.umc.reco_aos.databinding.DialogGoodBinding
import com.umc.reco_aos.databinding.DialogRefillBinding
import com.umc.reco_aos.databinding.DialogSadBinding
import com.umc.reco_aos.databinding.DialogSosoBinding

//class RefillDialog(context: Context, private  val ml: (Int) -> Unit,
//):Dialog(context){
class RefillDialog(context: Context):Dialog(context){
    private lateinit var binding: DialogRefillBinding
    private lateinit var bindinggood: DialogGoodBinding
    private lateinit var bindingsoso: DialogSosoBinding

    private lateinit var bindingsad: DialogSadBinding
    private lateinit var finishBtn: Button
    private lateinit var closeBtn: Button
    private lateinit var closeBtn1: Button
    private lateinit var closeBtn2: Button
    private lateinit var closeBtn3: Button

    private lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogRefillBinding.inflate(layoutInflater)
        bindinggood = DialogGoodBinding.inflate(layoutInflater)
        bindingsoso = DialogSosoBinding.inflate(layoutInflater)
        bindingsad = DialogSadBinding.inflate(layoutInflater)
        finishBtn = binding.btnRefillfinish
        closeBtn = binding.closeBtn
        closeBtn1 = bindinggood.closeBtn
        closeBtn2 = bindingsoso.closeBtn
        closeBtn3 = bindingsad.closeBtn

        closeBtn.setOnClickListener {
            dismiss()
        }
        editText = binding.editText
        setContentView(binding.root)
        initViews()
        goodDialog()
    }

    private fun initViews() = with(binding) {
        setCancelable(true)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(900, 700,)
        finishBtn.setOnClickListener {

            goodDialog()
            dismiss()
            }
//            dismiss()
//            if(editText.text.isNullOrBlank()){Toast.makeText(context, "리필 양을 입력하세요!", Toast.LENGTH_SHORT)}
//            else {
//                ml(Integer.parseInt(editText.text.toString()))
//                dismiss()
        }


    private fun goodDialog() = with(bindinggood) {
        setCancelable(true)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(900, 700,)
        closeBtn1.setOnClickListener {
            dismiss()
            }
//            dismiss()
//            if(editText.text.isNullOrBlank()){Toast.makeText(context, "리필 양을 입력하세요!", Toast.LENGTH_SHORT)}
//            else {
//                ml(Integer.parseInt(editText.text.toString()))
//                dismiss()
        }
}

