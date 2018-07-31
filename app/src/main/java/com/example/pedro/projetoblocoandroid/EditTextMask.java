package com.example.pedro.projetoblocoandroid;


import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditTextMask implements TextWatcher {

    private boolean isRunning = false;
    private boolean isDeleting = false;
    private String mask;

    public EditTextMask(String mask){
        this.mask = mask;
    }

    //Construtor de mascara para CPF,feito para n deixar hardcoded a mascara e caso exista uma necessidade de reutilizar a mascara
    public static EditTextMask construirCPF(){
        return new EditTextMask("###.###.###-##");
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        isDeleting = count > after;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    //Codigo para adicionar a mask no EditText enquanto o user digita, aplicando apos o mesmo digitar o ultimo char antes dos pontos
    @Override
    public void afterTextChanged(Editable s) {
        if(isRunning || isDeleting){
            return;
        }

        isRunning = true;

        int editableLength = s.length();

            if (editableLength < mask.length()) {
                if (mask.charAt(editableLength) != '#') {
                    s.append(mask.charAt(editableLength));
                } else if (mask.charAt(editableLength - 1) != '#') {
                    s.insert(editableLength - 1, mask, editableLength - 1, editableLength);
                }
            }

        isRunning = false;

    }
}
