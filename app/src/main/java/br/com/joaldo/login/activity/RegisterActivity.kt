package br.com.joaldo.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import br.com.caelum.stella.format.CPFFormatter
import br.com.caelum.stella.validation.CPFValidator
import br.com.caelum.stella.validation.InvalidStateException
import br.com.joaldo.login.R
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<TextInputLayout>(R.id.register_complete_name)
        validatedEmptyFields(name)

        val cpf = findViewById<TextInputLayout>(R.id.register_cpf)
        validatedFieldCPF(cpf)

        val phone = findViewById<TextInputLayout>(R.id.register_phone)
        validatedEmptyFields(phone)

        val mail = findViewById<TextInputLayout>(R.id.register_mail)
        validatedEmptyFields(mail)

        val password = findViewById<TextInputLayout>(R.id.register_password)
        validatedEmptyFields(password)


    }

    private fun validatedEmptyFields(textField: TextInputLayout) {
        val field = textField.editText as EditText
        field.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                if (field.text.isEmpty()) {
                    textField.error = "Campo Obrigatório"
                }else{
                    textField.error = null
                    textField.isErrorEnabled = false
                }
            }
        }
    }

    private fun removeError(textField: TextInputLayout) {
        textField.error = null
        textField.isErrorEnabled = false
    }

    private fun validatedFieldCPF(textField: TextInputLayout) {
        val field = textField.editText as EditText
        val cpfFormatter = CPFFormatter()
        field.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                if (field.text.isEmpty()) {
                    textField.error = "Campo Obrigatório"
                    return@setOnFocusChangeListener
                }
                if (field.length() != 11){
                    textField.error = "CPF precisa ter 11 digitos"
                    return@setOnFocusChangeListener
                }
                try {
                    val cpfValidator = CPFValidator()
                    cpfValidator.assertValid(field.text.toString())
                }catch (e: InvalidStateException){
                    textField.error = "CPF inválido"
                    return@setOnFocusChangeListener
                }
                removeError(textField)

                val cpfFormat = cpfFormatter.format(field.text.toString())
                field.setText(cpfFormat)

            }else{
                try {
                    val cpfUnformat = cpfFormatter.unformat(field.text.toString())
                    field.setText(cpfUnformat)
                }catch (e: IllegalArgumentException){
                    Log.e("Format CPF", e.message.toString())
                }
            }
        }
    }
}