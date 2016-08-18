function validateUser()
{
    var l = $("#ulogin").val();
    var s = $("#usenha").val();
    var sr = $("#usenharep").val();

    if (l === "") {
        $("#error_label").html("Usuário inválido! Digite algum nome.")
        return false;
    }
    else if (s === "") {
        $("#error_label").html("Senha inválida! Digite alguma senha.")
        return false;
    }
    else if (sr === "") {
        $("#error_label").html("Senha inválida! Digite alguma senha.")
        return false;
    }
    else if (s !== sr) {
        $("#error_label").html("Senhas não correspondem! Tente novamente.")
        return false;
    }
    return true;
}

