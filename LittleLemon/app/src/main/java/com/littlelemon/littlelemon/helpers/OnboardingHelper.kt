package com.littlelemon.littlelemon.helpers

fun validateRegistrationData(firstName: String, lastName: String, email: String): Boolean {
    var validated = false

    if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            validated = true
        }
    }

    return validated
}