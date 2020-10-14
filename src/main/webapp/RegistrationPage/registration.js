function checkUsername() {
    const username = document.getElementById("username")
    const xml = new XMLHttpRequest()

    xml.open("GET", "http://localhost:8080/logInCheck?username=" + username.value, false)
    xml.send()

    const result = xml.responseText;

    if (result === "true") {
        document.getElementById("username-error").style.display = "none"
    }

    if (xml.status !== 200) {
        document.getElementById(username-error).style.display = "block"
    } else {
        if (result === "false") {
            document.getElementById("username-error").style.display = "block"
        }
    }
}