package dao;

import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGenero {

    private final Connection connection;

    public DaoGenero(Connection connection) {
        this.connection = connection;
    }

    public void insert(Genero genero) throws SQLException {
        final String SQL = "INSERT INTO Genero (nome, descricao) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, genero.getNome());
        preparedStatement.setString(2, genero.getDescricao());
        preparedStatement.executeUpdate();
    }

    public void update(Genero genero) throws SQLException {
        final String SQL = "UPDATE Genero SET nome = ?, descricao = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, genero.getNome());
        preparedStatement.setString(2, genero.getDescricao());
        preparedStatement.setInt(3, genero.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Genero genero) throws SQLException {
        final String SQL = "DELETE FROM Genero WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, genero.getId());
        preparedStatement.executeUpdate();
    }

    public List<Genero> select() throws SQLException {
        final String SQL = "SELECT id, nome, descricao FROM Genero";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Genero> generoList = new ArrayList<>();

        while (resultSet.next()) {
            Genero genero = new Genero();

            genero.setId(resultSet.getInt("id"));
            genero.setNome(resultSet.getString("nome"));
            genero.setDescricao(resultSet.getString("descricao"));

            generoList.add(genero);
        }
        return  generoList;
    }
}
