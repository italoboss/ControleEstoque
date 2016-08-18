function confirmDelete(produto)
{
    if (confirm("Deseja realmente excluir o produto?"))
        window.location = "RemoverProduto?idProduto=" + produto;
}

