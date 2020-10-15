function checkUsername() {
    const username = document.getElementById("username")
    const xml = new XMLHttpRequest()

    xml.open("GET", "http://localhost:8080/logInCheck?username=" + username.value, false)
    xml.send()

    const result = xml.responseText;

    if (result === "true") {
        document.getElementById("username-error").style.display = "none"
        document.getElementById("lgn").disabled = true
    }

    if (xml.status !== 200) {
        document.getElementById("username-error").style.display = "block"
        document.getElementById("lgn").disabled = false
    } else {
        if (result === "false") {
            document.getElementById("username-error").style.display = "block"
            document.getElementById("lgn").disabled = false
        }
    }
}

function checkPasswords() {
    const password = document.getElementById("password")
    const secondPassword = document.getElementById("password-two")

    if (password.value !== secondPassword.value) {
        document.getElementById("password-error").style.display = "block"
        document.getElementById("lgn").disabled = false
    } else {
        document.getElementById("password-error").style.display = "none"
        document.getElementById("lgn").disabled = true
    }
}
