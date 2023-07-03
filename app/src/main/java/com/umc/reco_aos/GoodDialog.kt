package com.umc.reco_aos

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.umc.reco_aos.databinding.DialogRefillBinding

class GoodDialog(context: Context): Dialog(context){
    private lateinit var binding: DialogRefillBinding
    private lateinit var finishBtn: Button
    private lateinit var closeBtn: Button
    private lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogRefillBinding.inflate(layoutInflater)
        finishBtn = binding.btnRefillfinish
        closeBtn = binding.closeBtn
        closeBtn.setOnClickListener {
            dismiss()
        }
        editText = binding.editText
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        setCancelable(true)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(900, 700,)
        finishBtn.setOnClickListener {
            dismiss()
//            if(editText.text.isNullOrBlank()){Toast.makeText(context, "리필 양을 입력하세요!", Toast.LENGTH_SHORT)}
//            else {
//                ml(Integer.parseInt(editText.text.toString()))
//                dismiss()
        }
    }
}
