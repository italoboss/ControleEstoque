function confirmDelete(usuario)
{
    if (confirm("Deseja realmente excluir o usuário?"))
        window.location = "RemoverUsuario?idUsuario=" + usuario;
}

