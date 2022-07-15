package com.example.playerapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class dataid(
    @StringRes val stringResourceId: Int,   //@Str... @Dra... Son anotaciones de recursos empleadas para validar el orden de argumentos
    @DrawableRes val imageResourceId: Int   //pasados como parametros.
    ) {

}