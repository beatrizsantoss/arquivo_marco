<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8" />
            <title>Deletar Livros</title>
            <link href="/css/bootstrap.min.css" rel="stylesheet" />
        </head>

        <body>
            <div class="container">
                <h1>Deletar Livros</h1>
                <p> Tem certeza que deseja remover o livro ${livro.titulo}? </p>
                <form action="/livros/delete" method="post">
                    <input type="hidden" name="id" value="${livro.id}"/>
                    <div>
                        <label class="form-label">Titulo:</label>
                    </div>
                    <br />
                    <a href="/livros/list" class="btn btn-secondary">Voltar</a>
                    <button type="submit" class="btn btn-danger">Deletar</button>
                </form>
            </div>
        </body>

        </html>